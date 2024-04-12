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

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/earnedCredits")
    public String showEarnedCredits(Model model) {
        List<Object[]> earnedCredits = courseService.getEarnedCreditsByYearAndSemester();
        model.addAttribute("earnedCredits", earnedCredits);
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
}
