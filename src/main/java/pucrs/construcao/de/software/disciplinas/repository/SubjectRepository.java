package pucrs.construcao.de.software.disciplinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pucrs.construcao.de.software.disciplinas.model.Subject;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Optional<Subject> findById(Integer id);

    Optional<Subject> findByTitle(String title);
}
