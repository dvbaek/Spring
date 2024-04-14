package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement= "select count(*) from courses";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    public Course getCourse(String name) {

        String sqlStatement= "select * from courses where name=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name},
                new RowMapper<Course>() {

                    @Override
                    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Course course= new Course();

                        course.setYear(rs.getInt("year"));
                        course.setSemester(rs.getInt("semester"));
                        course.setCourseName(rs.getString("courseName"));
                        course.setCourseCode(rs.getString("courseCode"));
                        course.setClassification(rs.getString("classification"));
                        course.setProfessor(rs.getString("professor"));
                        course.setCredit(rs.getInt("credit"));

                        return course;
                    }
                });
    }

    //query and return multiple objects
    // cRud method (create Read update delete)
    public List<Course> getCourses() {

        String sqlStatement= "select * from courses";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                Course course= new Course();

                course.setYear(rs.getInt("year"));
                course.setSemester(rs.getInt("semester"));
                course.setCourseName(rs.getString("courseName"));
                course.setCourseCode(rs.getString("courseCode"));
                course.setClassification(rs.getString("classification"));
                course.setProfessor(rs.getString("professor"));
                course.setCredit(rs.getInt("credit"));

                return course;
            }
        });
    }

    // Crud method
    public boolean insert(Course course) {

        int year = course.getYear();
        int semester = course.getSemester();
        String courseName = course.getCourseName();
        String courseCode = course.getCourseCode();
        String classification = course.getClassification();
        String professor = course.getProfessor();
        int credit = course.getCredit();

        String sqlStatement= "insert into courses (year, semester, courseName, courseCode, classification, professor, credit) values (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, courseName, courseCode, classification, professor, credit}) == 1);
    }

    // crUd method
    public boolean update(Course course) {

        int year = course.getYear();
        int semester = course.getSemester();
        String courseName = course.getCourseName();
        String courseCode = course.getCourseCode();
        String classification = course.getClassification();
        String professor = course.getProfessor();
        int credit = course.getCredit();

        String sqlStatement= "update courses set year=?, semester=?, courseName=?, courseCode=?, classification=?, professor=?, credit=? where id=?";

        return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, courseName, courseCode, classification, professor, credit}) == 1);
    }

    //cruD method
    public boolean delete(int id) {
        String sqlStatement= "delete from courses where id=?";
        return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
    }

    public List<Object[]> getEarnedCreditsByYearAndSemester() {
        String sqlStatement = "SELECT year, semester, SUM(credit) AS earned_credits FROM courses GROUP BY year, semester ORDER BY year ASC, semester ASC";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Object[]>() {
            @Override
            public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] result = new Object[3];
                result[0] = rs.getInt("year");
                result[1] = rs.getInt("semester");
                result[2] = rs.getInt("earned_credits");
                return result;
            }
        });
    }

    public int getTotalCredits() {
        String sqlStatement = "SELECT SUM(credit) FROM courses";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    public int getTotalCreditsExcluding20242() {
        String sqlStatement = "SELECT SUM(credit) FROM courses WHERE year != 2024 OR semester != 2";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    public List<Course> getNextSemesterCourses(int year, int semester) {
        String sql = "SELECT * FROM courses WHERE year = ? AND semester = ?";
        return jdbcTemplate.query(sql, new Object[] { year, semester }, new CourseRowMapper());
    }

    private static class CourseRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course course = new Course();
            course.setYear(rs.getInt("year"));
            course.setSemester(rs.getInt("semester"));
            course.setCourseName(rs.getString("courseName"));
            course.setCourseCode(rs.getString("courseCode"));
            course.setClassification(rs.getString("classification"));
            course.setProfessor(rs.getString("professor"));
            course.setCredit(rs.getInt("credit"));
            return course;
        }
    }

    public List<Course> getCoursesByYearAndSemester(String year, String semester) {
        String sql = "SELECT * FROM courses WHERE year = ? AND semester = ?";
        return jdbcTemplate.query(sql, new Object[]{year, semester}, new CourseRowMapper());
    }
}
