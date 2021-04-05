package pucrs.construcao.de.software.disciplinas.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

    public Course(Integer id, String title, String description, List<Subject> listSubjects) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.listSubjects = listSubjects;
    }

    public Course() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Max(50)
    @Column(name = "title")
    private String title;

    @NotNull
    @Max(200)
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "listSubjects")
    @ManyToMany
    private List<Subject> listSubjects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Subject> getListSubjects() {
        return listSubjects;
    }

    public void setListSubjects(List<Subject> listSubjects) {
        this.listSubjects = listSubjects;
    }

}
