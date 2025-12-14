package dk.alpha.alphaprojecttool.controller;

import dk.alpha.alphaprojecttool.model.Project;
import dk.alpha.alphaprojecttool.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "projects/list";
    }

    @GetMapping("/{projectId}")
    public String details(@PathVariable Long projectId, Model model) {
        Project project = projectService.findById(projectId).orElseThrow();
        model.addAttribute("project", project);
        return "projects/detail";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("project", new Project());
        return "projects/form";
    }

    @GetMapping("/{projectId}/edit")
    public String editForm(@PathVariable Long projectId, Model model) {
        model.addAttribute("project", projectService.findById(projectId).orElseThrow());
        return "projects/form";
    }

    @PostMapping
    public String save(@ModelAttribute Project project, RedirectAttributes redirectAttributes) {
        projectService.save(project);
        redirectAttributes.addFlashAttribute("message", "Projekt gemt");
        return "redirect:/projects";
    }

    @PostMapping("/{projectId}/delete")
    public String delete(@PathVariable Long projectId, RedirectAttributes redirectAttributes) {
        projectService.deleteById(projectId);
        redirectAttributes.addFlashAttribute("message", "Projekt slettet");
        return "redirect:/projects";
    }
}
