package dk.alpha.alphaprojecttool.repository;

import dk.alpha.alphaprojecttool.model.Project;
import dk.alpha.alphaprojecttool.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject(Project project);
}
