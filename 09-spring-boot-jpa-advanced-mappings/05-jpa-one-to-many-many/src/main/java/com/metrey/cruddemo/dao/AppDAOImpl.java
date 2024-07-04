package com.metrey.cruddemo.dao;

import com.metrey.cruddemo.entity.Course;
import com.metrey.cruddemo.entity.Instructor;
import com.metrey.cruddemo.entity.InstructorDetail;
import com.metrey.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class AppDAOImpl implements AppDAO{

    // define the field for entity manager

    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstuctor = entityManager.find(Instructor.class,theId);

        // get the course in instructor
        List<Course> tempCourse = tempInstuctor.getCourses();

        // break association for all course for the instructor
        tempCourse.forEach(t -> t.setInstructor(null));

        // delete the instructor
        entityManager.remove(tempInstuctor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return  entityManager.find(InstructorDetail.class,theId);
    }


    @Override
    @Transactional
    public void deleteInstuctorDetailById(int theId) {
        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,theId);

        // remove the associated object reference
        //
        // break bi-directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor detail
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data",Course.class);
        query.setParameter("data",theId);

        // execute query
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                                                "select i from Instructor i join fetch i.courses where i.id = :data ", Instructor.class);

        query.setParameter("data",theId);
        //execute the query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course tempCourse = entityManager.find(Course.class,theId);
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void saveCourse(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c join fetch c.reviews where c.id = :data"
                ,Course.class);
        query.setParameter("data",theId);
        Course theCourse = query.getSingleResult();
        return theCourse;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c join fetch c.students where c.id = :data",Course.class);
        query.setParameter("data",theId);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentByStudentId(int theId) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s join fetch s.courses where s.id = :student_id",Student.class);
        query.setParameter("student_id",theId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        Student theStudent = entityManager.find(Student.class,theId);
        entityManager.remove(theStudent);
    }

}// end of class
