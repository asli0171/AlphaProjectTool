package dk.projekt.alphaprojecttool.service;

import dk.projekt.alphaprojecttool.service.dto.ProjectReport;
import dk.projekt.alphaprojecttool.service.dto.ProjectSummary;

import java.util.List;

public interface ReportService {
    List<ProjectSummary> getProjectSummaries();
    ProjectReport getProjectReport(Long projectId);
}
