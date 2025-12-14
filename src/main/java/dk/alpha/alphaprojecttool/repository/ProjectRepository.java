package dk.alpha.alphaprojecttool.repository;

import dk.alpha.alphaprojecttool.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
