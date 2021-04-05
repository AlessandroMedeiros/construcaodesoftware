package pucrs.construcao.de.software.disciplinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucrs.construcao.de.software.disciplinas.model.Course;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findById(Integer id);

    Optional<Course> findByTitle(String title);
}
