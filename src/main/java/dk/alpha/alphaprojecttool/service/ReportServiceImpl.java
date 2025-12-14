package dk.alpha.alphaprojecttool.service;

import dk.alpha.alphaprojecttool.model.Project;
import dk.alpha.alphaprojecttool.model.Task;
import dk.alpha.alphaprojecttool.model.TimeEntry;
import dk.alpha.alphaprojecttool.repository.ProjectRepository;
import dk.alpha.alphaprojecttool.service.dto.ProjectReport;
import dk.alpha.alphaprojecttool.service.dto.ProjectSummary;
import dk.alpha.alphaprojecttool.service.dto.TaskReportRow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ProjectRepository projectRepository;

    public ReportServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectSummary> getProjectSummaries() {
        List<ProjectSummary> summaries = new ArrayList<>();

        for (Project p : projectRepository.findAll()) {
            double totalHours = 0.0;

            for (Task t : p.getTasks()) {
                for (TimeEntry e : t.getTimeEntries()) {
                    totalHours += e.getHours();
                }
            }

            ProjectSummary s = new ProjectSummary();
            s.setProjectId(p.getProjectId());
            s.setProjectName(p.getName());
            s.setCustomer(p.getCustomer());
            s.setStatus(p.getStatus() != null ? p.getStatus().name() : "");
            s.setTotalHours(totalHours);

            summaries.add(s);
        }

        return summaries;
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectReport getProjectReport(Long projectId) {
        Project p = projectRepository.findById(projectId).orElseThrow();

        ProjectReport report = new ProjectReport();
        report.setProjectId(p.getProjectId());
        report.setProjectName(p.getName());
        report.setCustomer(p.getCustomer());
        report.setStatus(p.getStatus() != null ? p.getStatus().name() : "");

        double projectHours = 0.0;

        for (Task t : p.getTasks()) {
            double taskHours = 0.0;

            for (TimeEntry e : t.getTimeEntries()) {
                taskHours += e.getHours();
            }

            TaskReportRow row = new TaskReportRow();
            row.setTaskId(t.getTaskId());
            row.setTaskName(t.getName());
            row.setStatus(t.getStatus() != null ? t.getStatus().name() : "");
            row.setTotalHours(taskHours);

            report.getTasks().add(row);
            projectHours += taskHours;
        }

        report.setTotalHours(projectHours);
        return report;
    }
}
