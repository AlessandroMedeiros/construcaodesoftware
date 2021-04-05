package pucrs.construcao.de.software.disciplinas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucrs.construcao.de.software.disciplinas.controller.DTO.NewSubjectDTO;
import pucrs.construcao.de.software.disciplinas.model.Subject;
import pucrs.construcao.de.software.disciplinas.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> listSubjects() {
        return subjectRepository.findAll();
    }

    public Subject addSubject(NewSubjectDTO subjectDTO) {
        Subject subject = new Subject(subjectDTO.getId(), subjectDTO.getTitle(), subjectDTO.getDescription());
        subject = subjectRepository.save(subject);
        return subject;
    }

    public Optional<Subject> getSubject(Integer id){
        return subjectRepository.findById(id);
    }

    public boolean deleteSubject(Integer id) {
        Optional<Subject> subjectModel = getSubject(id);
        if(subjectModel.isPresent()){
            subjectRepository.delete(subjectModel.get());
            return true;
        }
        return false;
    }

    public boolean updateSubject(Integer id, String title) {
        Optional<Subject> subjectModel = getSubject(id);
        if(subjectModel.isPresent()){
            subjectModel.get().setTitle(title);
            subjectRepository.save(subjectModel.get());
            return true;
        }
        return false;
    }
}
