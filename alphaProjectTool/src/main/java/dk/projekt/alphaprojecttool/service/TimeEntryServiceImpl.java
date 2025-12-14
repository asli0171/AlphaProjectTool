package dk.projekt.alphaprojecttool.service;

import dk.projekt.alphaprojecttool.model.Task;
import dk.projekt.alphaprojecttool.model.TimeEntry;
import dk.projekt.alphaprojecttool.repository.TimeEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeEntryServiceImpl implements TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryServiceImpl(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @Override
    public List<TimeEntry> findByTask(Task task) {
        return timeEntryRepository.findByTask(task);
    }

    @Override
    public Optional<TimeEntry> findById(Long timeEntryId) {
        return timeEntryRepository.findById(timeEntryId);
    }

    @Override
    public TimeEntry save(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }

    @Override
    public void deleteById(Long timeEntryId) {
        timeEntryRepository.deleteById(timeEntryId);
    }
}
