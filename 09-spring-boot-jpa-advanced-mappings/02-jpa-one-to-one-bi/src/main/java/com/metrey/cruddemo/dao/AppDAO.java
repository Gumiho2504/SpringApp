package com.metrey.cruddemo.dao;

import com.metrey.cruddemo.entity.Instructor;
import com.metrey.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void  deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstuctorDetailById(int theId);
}
