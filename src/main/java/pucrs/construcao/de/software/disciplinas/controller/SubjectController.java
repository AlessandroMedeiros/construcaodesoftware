package pucrs.construcao.de.software.disciplinas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pucrs.construcao.de.software.disciplinas.controller.DTO.NewSubjectDTO;
import pucrs.construcao.de.software.disciplinas.model.Subject;
import pucrs.construcao.de.software.disciplinas.service.SubjectService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping //GET /courses: recuperação dos dados de todos os subjects
    public List<Subject> listSubjects() {
        return subjectService.listSubjects();
    }

    @PostMapping //POST /subjects: criação de um subjects
    public ResponseEntity<Subject> addCourse(@RequestBody NewSubjectDTO newSubjectDTO) {
        Subject subject = subjectService.addSubject(newSubjectDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(subject.getId()).toUri();
        return ResponseEntity.created(uri).body(subject);
    }

    @GetMapping(path = "/{id}") //GET /courses/id: buscar um novo curso
    public Optional<Subject> getSubject(@PathVariable Integer id){
        return subjectService.getSubject(id);
    }

    @DeleteMapping(path = "{id}") //DELETE /courses/id: deletar um assunto
    public ResponseEntity<Subject> deleteSubject(@PathVariable Integer id){
        boolean isDeleted =  subjectService.deleteSubject(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/updateSubject") //PUT //subjects/updateSubject atualizar um assunto
    public ResponseEntity<Subject> updateSubject(@RequestBody Integer id, @RequestBody String title){
        if(subjectService.updateSubject(id, title)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
