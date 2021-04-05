package pucrs.construcao.de.software.disciplinas.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name = "subjects")
public class Subject {

    public Subject(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Subject() {}

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
}
