package pucrs.construcao.de.software.disciplinas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pucrs.construcao.de.software.disciplinas.controller.DTO.NewCourseDTO;
import pucrs.construcao.de.software.disciplinas.model.Course;
import pucrs.construcao.de.software.disciplinas.service.CourseService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CourseService courseService;

    @GetMapping //GET /courses: recuperação dos dados de todos os usuários
    public List<Course> listCourses() {
        return courseService.listCourses();
    }

    @PostMapping //POST /courses: criação de um curso
    public ResponseEntity<Course> addCourse(@RequestBody NewCourseDTO newCourseDTO) {
        Course course = courseService.addCourse(newCourseDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(course);
    }

    @GetMapping(path = "/{id}") //GET /courses/id: buscar um novo curso
    public Optional<Course> getCourse(@PathVariable Integer id){
        return courseService.getCourse(id);
    }

    @DeleteMapping(path = "{id}") //DELETE /courses/id: deletar um curso
    public ResponseEntity<Course> deleteCourse(@PathVariable Integer id){
        boolean isDeleted =  courseService.deleteCourse(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/updateCourse") //PUT //subjects/updateCourse atualizar um curso
    public ResponseEntity<Course> updateSubject(@RequestBody Integer id, @RequestBody String title){
        if(courseService.updateCourse(id, title)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
