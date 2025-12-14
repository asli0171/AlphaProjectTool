package dk.alpha.alphaprojecttool.repository;

import dk.alpha.alphaprojecttool.model.Task;
import dk.alpha.alphaprojecttool.model.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
    List<TimeEntry> findByTask(Task task);
}
