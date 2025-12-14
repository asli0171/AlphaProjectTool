package dk.alpha.alphaprojecttool.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeEntryId;

    private LocalDate date;
    private double hours;
    private String description;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Long getTimeEntryId() {
        return timeEntryId;
    }

    public void setTimeEntryId(Long timeEntryId) {
        this.timeEntryId = timeEntryId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
