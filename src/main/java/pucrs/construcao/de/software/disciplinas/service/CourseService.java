package pucrs.construcao.de.software.disciplinas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucrs.construcao.de.software.disciplinas.controller.DTO.NewCourseDTO;
import pucrs.construcao.de.software.disciplinas.model.Course;
import pucrs.construcao.de.software.disciplinas.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    public Course addCourse(NewCourseDTO newCourseDTO) {
        Course course = new Course(newCourseDTO.getId(), newCourseDTO.getTitle(), newCourseDTO.getDescription(), newCourseDTO.getListSubjetcs());
        course = courseRepository.save(course);
        return course;
    }

    public Optional<Course> getCourse(Integer id){
        return courseRepository.findById(id);
    }

    public boolean deleteCourse(Integer id) {
        Optional<Course> curseModel = courseRepository.findById(id);
        if(curseModel.isPresent()){
            courseRepository.delete(curseModel.get());
            return true;
        }
        return false;
    }

    public boolean updateCourse(Integer id, String title) {
        Optional<Course> courseModel = getCourse(id);
        if(courseModel.isPresent()){
            courseModel.get().setTitle(title);
            courseRepository.save(courseModel.get());
            return true;
        }
        return false;
    }
}
