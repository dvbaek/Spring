package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseDao;
import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getAllCourses() {
        return courseDao.getCourses();
    }

    public List<Object[]> getEarnedCreditsByYearAndSemester() {
        return courseDao.getEarnedCreditsByYearAndSemester();
    }

    public int getTotalCredits() {
        return courseDao.getTotalCredits();
    }

    public int getTotalCreditsExcluding20242() {
        return courseDao.getTotalCreditsExcluding20242();
    }

    public void insert(Course course) { courseDao.insert(course); }

    public List<Course> getNextSemesterCourses() {
        return courseDao.getNextSemesterCourses(2024, 2);
    }

    public List<Course> getCoursesByYearAndSemester(String year, String semester){
        return courseDao.getCoursesByYearAndSemester(year, semester);
    }
}
