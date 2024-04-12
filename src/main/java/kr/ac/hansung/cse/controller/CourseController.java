package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
