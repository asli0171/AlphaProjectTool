package dk.alpha.alphaprojecttool.service;

import dk.alpha.alphaprojecttool.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAll();
    Optional<Project> findById(Long projectId);
    Project save(Project project);
    void deleteById(Long projectId);
}
