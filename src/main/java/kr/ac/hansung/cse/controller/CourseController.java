package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

//    @GetMapping("/earnedCredits")
//    public String showCourses(Model model){
//        List<Course> courses = courseService.getAllCourses();
//        model.addAttribute("id_courses", courses);
//
//        return  "earnedCredits";
//    }

//    @GetMapping("/earnedCredits")
//    public String showEarnedCredits(Model model) {
//        List<Object[]> earnedCredits = courseService.getEarnedCreditsByYearAndSemester();
//        model.addAttribute("earnedCredits", earnedCredits);
//        int totalCredits = courseService.getTotalCredits();
//        model.addAttribute("totalCredits", totalCredits);
//        return "earnedCredits";
//    }

    @GetMapping("/earnedCredits")
    public String showEarnedCredits(Model model) {
        List<Object[]> allEarnedCredits = courseService.getEarnedCreditsByYearAndSemester();

        List<Object[]> filteredEarnedCredits = allEarnedCredits.stream()
                .filter(credit -> !credit[0].equals(2024) || !credit[1].equals(2))
                .collect(Collectors.toList());

        model.addAttribute("earnedCredits", filteredEarnedCredits);

        int totalCredits = courseService.getTotalCredits();
        model.addAttribute("totalCredits", totalCredits);

        return "earnedCredits";
    }

    @GetMapping("/register")
    public String registerCourse(Model model) {
        model.addAttribute("course", new Course());
        return "register";
    }

    @PostMapping("/doRegister")
    public String doCreate(Model model, @Valid Course course, BindingResult result) {

        if(result.hasErrors()){
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "register";
        }

        course.setYear(2024);
        course.setSemester(2);
        courseService.insert(course);
        return "afterRegister";
    }

    @GetMapping("/registeredCourses")
    public String showRegisteredCourses(Model model) {
        List<Course> courses = courseService.getNextSemesterCourses();
        model.addAttribute("courses", courses);

        return "registeredCourses";
    }

    @GetMapping("/details")
    public String showDetails(@RequestParam("year") String year,
                              @RequestParam("semester") String semester,
                              Model model) {
        // 해당하는 년도와 학기의 데이터를 조회
        List<Course> courses = courseService.getCoursesByYearAndSemester(year, semester);

        // 조회된 데이터를 모델에 담아서 뷰로 전달
        model.addAttribute("year", year);
        model.addAttribute("semester", semester);
        model.addAttribute("courses", courses);

        return "details";
    }
}
