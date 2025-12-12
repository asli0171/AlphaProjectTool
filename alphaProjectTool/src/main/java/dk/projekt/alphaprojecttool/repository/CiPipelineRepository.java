package dk.projekt.alphaprojecttool.repository;

import dk.projekt.alphaprojecttool.model.CiPipeline;
import dk.projekt.alphaprojecttool.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CiPipelineRepository extends JpaRepository<CiPipeline, Long> {
    Optional<CiPipeline> findByProject(Project project);
}
