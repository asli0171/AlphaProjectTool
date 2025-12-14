package dk.projekt.alphaprojecttool.service;

import dk.projekt.alphaprojecttool.model.Project;
import dk.projekt.alphaprojecttool.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findByProject(Project project);
    Optional<Task> findById(Long taskId);
    Task save(Task task);
    void deleteById(Long taskId);
}
