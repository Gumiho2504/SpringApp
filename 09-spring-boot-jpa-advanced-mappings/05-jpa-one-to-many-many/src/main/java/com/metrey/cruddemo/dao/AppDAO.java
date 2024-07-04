package com.metrey.cruddemo.dao;

import com.metrey.cruddemo.entity.Course;
import com.metrey.cruddemo.entity.Instructor;
import com.metrey.cruddemo.entity.InstructorDetail;
import com.metrey.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void  deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstuctorDetailById(int theId);

    List<Course> findCourseByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void saveCourse(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentByCourseId(int theId);
    Student findStudentByStudentId(int theId);

    void updateStudent(Student theStudent);

    void deleteStudentById(int theId);

}
