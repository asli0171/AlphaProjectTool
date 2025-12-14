package dk.projekt.alphaprojecttool.controller;

import dk.projekt.alphaprojecttool.model.Project;
import dk.projekt.alphaprojecttool.model.Task;
import dk.projekt.alphaprojecttool.model.TimeEntry;
import dk.projekt.alphaprojecttool.service.ProjectService;
import dk.projekt.alphaprojecttool.service.TaskService;
import dk.projekt.alphaprojecttool.service.TimeEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/projects/{projectId}/tasks/{taskId}/timeentries")
public class TimeEntryController {

    private final ProjectService projectService;
    private final TaskService taskService;
    private final TimeEntryService timeEntryService;

    public TimeEntryController(ProjectService projectService,
                               TaskService taskService,
                               TimeEntryService timeEntryService) {
        this.projectService = projectService;
        this.taskService = taskService;
        this.timeEntryService = timeEntryService;
    }

    @ModelAttribute("project")
    public Project loadProject(@PathVariable Long projectId) {
        return projectService.findById(projectId).orElseThrow();
    }

    @ModelAttribute("task")
    public Task loadTask(@PathVariable Long taskId) {
        return taskService.findById(taskId).orElseThrow();
    }

    @GetMapping
    public String list(@ModelAttribute("task") Task task, Model model) {
        model.addAttribute("timeEntries", timeEntryService.findByTask(task));
        return "timeentries/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("task") Task task, Model model) {
        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setTask(task);
        model.addAttribute("timeEntry", timeEntry);
        return "timeentries/form";
    }

    @GetMapping("/{timeEntryId}/edit")
    public String editForm(@PathVariable Long timeEntryId,
                           @ModelAttribute("task") Task task,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        TimeEntry timeEntry = timeEntryService.findById(timeEntryId).orElse(null);
        if (timeEntry == null) {
            redirectAttributes.addFlashAttribute("error", "Tidsregistrering ikke fundet");
            return "redirect:/projects/" + task.getProject().getProjectId()
                    + "/tasks/" + task.getTaskId()
                    + "/timeentries";
        }
        model.addAttribute("timeEntry", timeEntry);
        return "timeentries/form";
    }

    @PostMapping
    public String save(@ModelAttribute("task") Task task,
                       @ModelAttribute TimeEntry timeEntry,
                       RedirectAttributes redirectAttributes) {
        timeEntry.setTask(task);
        timeEntryService.save(timeEntry);
        redirectAttributes.addFlashAttribute("message", "Tidsregistrering gemt");
        return "redirect:/projects/" + task.getProject().getProjectId()
                + "/tasks/" + task.getTaskId()
                + "/timeentries";
    }

    @PostMapping("/{timeEntryId}/delete")
    public String delete(@PathVariable Long timeEntryId,
                         @ModelAttribute("task") Task task,
                         RedirectAttributes redirectAttributes) {
        timeEntryService.deleteById(timeEntryId);
        redirectAttributes.addFlashAttribute("message", "Tidsregistrering slettet");
        return "redirect:/projects/" + task.getProject().getProjectId()
                + "/tasks/" + task.getTaskId()
                + "/timeentries";
    }
}
