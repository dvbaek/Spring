package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
    @NotNull(message = "Year cannot be null")
    private int year;

    @NotNull(message = "Year cannot be null")
    private int semester;

    @NotBlank(message = "Course code is required")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Course code must contain only letters and numbers")
    private String courseCode;

    @NotBlank(message = "CourseName is required")
    @Length(max = 100, message = "Course name must be less than 100 characters")
    private String courseName;

    @NotBlank(message = "Classification is required")
    private String classification; //교과구분

    @NotBlank(message = "Professor name is required")
    @Length(max = 100, message = "Professor name must be less than 100 characters")
    private String professor;

    @NotNull(message = "Credit cannot be null")
    @Range(min = 1, max = 21, message = "Semester must be between 1 and 21")
    private int credit;
}
