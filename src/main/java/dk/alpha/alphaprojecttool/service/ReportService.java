package dk.alpha.alphaprojecttool.service;

import dk.alpha.alphaprojecttool.service.dto.ProjectReport;
import dk.alpha.alphaprojecttool.service.dto.ProjectSummary;

import java.util.List;

public interface ReportService {
    List<ProjectSummary> getProjectSummaries();
    ProjectReport getProjectReport(Long projectId);
}
