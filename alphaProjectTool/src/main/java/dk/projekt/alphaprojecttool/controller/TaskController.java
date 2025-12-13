package dk.projekt.alphaprojecttool.controller;

import dk.projekt.alphaprojecttool.model.Project;
import dk.projekt.alphaprojecttool.model.Task;
import dk.projekt.alphaprojecttool.service.ProjectService;
import dk.projekt.alphaprojecttool.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/projects/{projectId}/tasks")
public class TaskController {

    private final ProjectService projectService;
    private final TaskService taskService;

    public TaskController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @ModelAttribute("project")
    public Project loadProject(@PathVariable Long projectId) {
        return projectService.findById(projectId).orElseThrow();
    }

    @GetMapping
    public String list(@ModelAttribute("project") Project project, Model model) {
        model.addAttribute("tasks", taskService.findByProject(project));
        return "tasks/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("project") Project project, Model model) {
        Task task = new Task();
        task.setProject(project);
        model.addAttribute("task", task);
        return "tasks/form";
    }

    @GetMapping("/{taskId}/edit")
    public String editForm(@PathVariable Long taskId,
                           @ModelAttribute("project") Project project,
                           Model model) {
        Task task = taskService.findById(taskId).orElseThrow();
        model.addAttribute("task", task);
        return "tasks/form";
    }

    @PostMapping
    public String save(@ModelAttribute("project") Project project,
                       @ModelAttribute Task task,
                       RedirectAttributes redirectAttributes) {
        task.setProject(project);
        taskService.save(task);
        redirectAttributes.addFlashAttribute("message", "Opgave gemt");
        return "redirect:/projects/" + project.getProjectId() + "/tasks";
    }

    @PostMapping("/{taskId}/delete")
    public String delete(@PathVariable Long taskId,
                         @ModelAttribute("project") Project project,
                         RedirectAttributes redirectAttributes) {
        taskService.deleteById(taskId);
        redirectAttributes.addFlashAttribute("message", "Opgave slettet");
        return "redirect:/projects/" + project.getProjectId() + "/tasks";
    }
}
