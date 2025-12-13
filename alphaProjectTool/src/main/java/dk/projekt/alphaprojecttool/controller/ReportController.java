package dk.projekt.alphaprojecttool.controller;

import dk.projekt.alphaprojecttool.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("projectSummaries", reportService.getProjectSummaries());
        return "reports/index";
    }

    @GetMapping("/projects/{projectId}")
    public String projectReport(@PathVariable Long projectId, Model model) {
        model.addAttribute("report", reportService.getProjectReport(projectId));
        return "reports/project-detail";
    }
}
