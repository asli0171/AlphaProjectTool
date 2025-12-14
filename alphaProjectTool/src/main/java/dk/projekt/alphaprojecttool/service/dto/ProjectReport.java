package dk.projekt.alphaprojecttool.service.dto;

import java.util.ArrayList;
import java.util.List;

public class ProjectReport {

    private Long projectId;
    private String projectName;
    private String customer;
    private String status;
    private double totalHours;
    private List<TaskReportRow> tasks = new ArrayList<>();

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public List<TaskReportRow> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskReportRow> tasks) {
        this.tasks = tasks;
    }
}
