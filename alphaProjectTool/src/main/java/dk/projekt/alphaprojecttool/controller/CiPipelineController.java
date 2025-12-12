package dk.projekt.alphaprojecttool.controller;

import dk.projekt.alphaprojecttool.model.CiPipeline;
import dk.projekt.alphaprojecttool.model.Project;
import dk.projekt.alphaprojecttool.service.CiPipelineService;
import dk.projekt.alphaprojecttool.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/projects/{projectId}/pipeline")
public class CiPipelineController {

    private final ProjectService projectService;
    private final CiPipelineService ciPipelineService;

    public CiPipelineController(ProjectService projectService, CiPipelineService ciPipelineService) {
        this.projectService = projectService;
        this.ciPipelineService = ciPipelineService;
    }

    @ModelAttribute("project")
    public Project loadProject(@PathVariable Long projectId) {
        return projectService.findById(projectId).orElseThrow();
    }

    @GetMapping
    public String show(@ModelAttribute("project") Project project, Model model) {
        CiPipeline pipeline = ciPipelineService
                .findByProject(project)
                .orElseGet(() -> {
                    CiPipeline p = new CiPipeline();
                    p.setCiTool("GitHub Actions");
                    p.setBranch("main");
                    return p;
                });

        model.addAttribute("pipeline", pipeline);
        return "pipeline";
    }

    @PostMapping
    public String save(@ModelAttribute("project") Project project,
                       @ModelAttribute("pipeline") CiPipeline pipeline,
                       RedirectAttributes redirectAttributes) {

        ciPipelineService.saveForProject(project, pipeline);
        redirectAttributes.addFlashAttribute("message", "CI pipeline gemt");
        return "redirect:/projects/" + project.getId() + "/pipeline";
    }

    @PostMapping("/trigger")
    public String trigger(@ModelAttribute("project") Project project,
                          RedirectAttributes redirectAttributes) {
        ciPipelineService.triggerBuild(project);
        redirectAttributes.addFlashAttribute("message", "Build er trigget (simuleret)");
        return "redirect:/projects/" + project.getId() + "/pipeline";
    }
}
