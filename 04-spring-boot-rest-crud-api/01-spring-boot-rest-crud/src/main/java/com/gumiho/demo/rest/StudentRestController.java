package com.gumiho.demo.rest;

import com.gumiho.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    @PostConstruct
    public void loadData(){
        theStudent = new ArrayList<>();
        theStudent.add(new Student("Hem","Chanmetrey"));
        theStudent.add(new Student("Chan","Sok"));
        theStudent.add(new Student("Sok","Thorn"));
    }

    // define endpoint for "/student" - return a list of student
    @GetMapping("/students")
    public List<Student> getStudent(){

        return theStudent;
    }

    // define endpoint or "/student/{studentId}" - return student at index

    @GetMapping("/students/id={studentId}")
    public Student getTheStudent(@PathVariable int studentId) {
        System.out.println(studentId);
        // just index into the list--- keep it simple for now

        // check the studentId again list size
        if((studentId >= theStudent.size()) || (studentId <0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudent.get(studentId);
    }

    //find student by lastName
    @GetMapping("/students/lastName={lastName}")
    public Student getTheStudent(@PathVariable String lastName){
        int index = 0;

        for(int i =0 ; i< theStudent.size(); i++){
            boolean isEqual = lastName.equalsIgnoreCase(theStudent.get(i).getLastName());
            if (isEqual){
                index = i; return theStudent.get(index);
            }else if(!isEqual && i >= theStudent.size()){
                throw new StudentNotFoundException("Student name not found - " + lastName);
            }
        }

        return null;


    }

    //If don't use @ControllerAdvice un command this line
//
//    // Add an exception handler using @ExceptionHandler
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException exc){
//
//        // create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStemp(System.currentTimeMillis());
//
//        // return ResponseEntity
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }
//
//    // add another exception handler ... to catch any exception (catch all)
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//
//        // create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStemp(System.currentTimeMillis());
//        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//    }
//


}// end of class
