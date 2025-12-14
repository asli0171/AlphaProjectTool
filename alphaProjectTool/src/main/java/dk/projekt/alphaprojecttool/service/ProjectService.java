package dk.projekt.alphaprojecttool.service;

import dk.projekt.alphaprojecttool.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAll();
    Optional<Project> findById(Long projectId);
    Project save(Project project);
    void deleteById(Long projectId);
}
