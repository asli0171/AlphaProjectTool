package dk.projekt.alphaprojecttool.service;

import dk.projekt.alphaprojecttool.model.CiPipeline;
import dk.projekt.alphaprojecttool.model.PipelineStatus;
import dk.projekt.alphaprojecttool.model.Project;
import dk.projekt.alphaprojecttool.repository.CiPipelineRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CiPipelineServiceImpl implements CiPipelineService {

    private final CiPipelineRepository ciPipelineRepository;

    public CiPipelineServiceImpl(CiPipelineRepository ciPipelineRepository) {
        this.ciPipelineRepository = ciPipelineRepository;
    }

    @Override
    public Optional<CiPipeline> findByProject(Project project) {
        return ciPipelineRepository.findByProject(project);
    }

    @Override
    public CiPipeline saveForProject(Project project, CiPipeline pipeline) {
        pipeline.setProject(project);
        return ciPipelineRepository.save(pipeline);
    }

    @Override
    public CiPipeline triggerBuild(Project project) {
        CiPipeline pipeline = ciPipelineRepository
                .findByProject(project)
                .orElseThrow(() -> new IllegalStateException("Ingen pipeline konfigureret for projektet"));


        pipeline.setStatus(PipelineStatus.RUNNING);
        pipeline.setLastRun(LocalDateTime.now());
        pipeline = ciPipelineRepository.save(pipeline);


        pipeline.setStatus(PipelineStatus.OK);
        pipeline.setLastRun(LocalDateTime.now());
        return ciPipelineRepository.save(pipeline);
    }
}
