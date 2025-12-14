package dk.projekt.alphaprojecttool.service;

import dk.projekt.alphaprojecttool.model.Task;
import dk.projekt.alphaprojecttool.model.TimeEntry;

import java.util.List;
import java.util.Optional;

public interface TimeEntryService {
    List<TimeEntry> findByTask(Task task);
    Optional<TimeEntry> findById(Long timeEntryId);
    TimeEntry save(TimeEntry timeEntry);
    void deleteById(Long timeEntryId);
}
