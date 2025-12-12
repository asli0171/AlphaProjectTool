package dk.projekt.alphaprojecttool.service;

import dk.projekt.alphaprojecttool.model.CiPipeline;
import dk.projekt.alphaprojecttool.model.Project;

import java.util.Optional;

public interface CiPipelineService {

    Optional<CiPipeline> findByProject(Project project);

    CiPipeline saveForProject(Project project, CiPipeline pipeline);

    CiPipeline triggerBuild(Project project);
}
