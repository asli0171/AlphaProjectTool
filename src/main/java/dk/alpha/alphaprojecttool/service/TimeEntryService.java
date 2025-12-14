package dk.alpha.alphaprojecttool.service;

import dk.alpha.alphaprojecttool.model.Task;
import dk.alpha.alphaprojecttool.model.TimeEntry;

import java.util.List;
import java.util.Optional;

public interface TimeEntryService {
    List<TimeEntry> findByTask(Task task);
    Optional<TimeEntry> findById(Long timeEntryId);
    TimeEntry save(TimeEntry timeEntry);
    void deleteById(Long timeEntryId);
}
