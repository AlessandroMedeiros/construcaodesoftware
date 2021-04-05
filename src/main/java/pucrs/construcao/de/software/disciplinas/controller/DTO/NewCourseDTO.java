package pucrs.construcao.de.software.disciplinas.controller.DTO;

import pucrs.construcao.de.software.disciplinas.model.Subject;

import java.io.Serializable;
import java.util.List;

public class NewCourseDTO implements Serializable {

    private Integer id;
    private String title;
    private String description;
    private List<Subject> listSubjetcs;

    public NewCourseDTO() {}

    public NewCourseDTO(Integer id, String title, String description, List<Subject> listSubjetcs) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.listSubjetcs = listSubjetcs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Subject> getListSubjetcs() {
        return listSubjetcs;
    }

    public void setListSubjetcs(List<Subject> listSubjetcs) {
        this.listSubjetcs = listSubjetcs;
    }
}
