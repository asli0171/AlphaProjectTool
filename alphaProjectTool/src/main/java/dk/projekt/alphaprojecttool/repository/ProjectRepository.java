package dk.projekt.alphaprojecttool.repository;

import dk.projekt.alphaprojecttool.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
