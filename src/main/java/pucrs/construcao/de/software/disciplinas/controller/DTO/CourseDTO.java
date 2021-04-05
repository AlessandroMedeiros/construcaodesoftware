package pucrs.construcao.de.software.disciplinas.controller.DTO;

import pucrs.construcao.de.software.disciplinas.model.Subject;

import java.io.Serializable;
import java.util.List;

public class CourseDTO implements Serializable {

    private Integer id;
    private String nome;
    private List<Subject> listSubjects;

    public CourseDTO() {}

    public CourseDTO(Integer id, String nome, List<Subject> listSubjects) {
        this.id = id;
        this.nome = nome;
        this.listSubjects = listSubjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Subject> getListSubjects() {
        return listSubjects;
    }

    public void setListSubjects(List<Subject> listSubjects) {
        this.listSubjects = listSubjects;
    }
}
