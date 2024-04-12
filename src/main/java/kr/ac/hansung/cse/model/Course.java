package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
    private int year;
    private int semester;
    private String courseCode;
    private String courseName;
    private String classification; //교과구분
    private String professor;
    private int credit;
}
