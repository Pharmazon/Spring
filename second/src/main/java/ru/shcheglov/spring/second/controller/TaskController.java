package ru.shcheglov.spring.second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.model.Task;
import ru.shcheglov.spring.second.repository.PersonRepository;
import ru.shcheglov.spring.second.repository.TaskRepository;

import java.util.Collection;
import java.util.Map;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/task-list")
    public String list(final Model model) {
        final Collection<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @GetMapping("/task-create")
    public String create() {
        taskRepository.merge(new Task());
        return "redirect:/task-list";
    }

    @GetMapping("/task-remove")
    public String remove(@RequestParam("id") String id) {
        taskRepository.removeById(id);
        return "redirect:/task-list";
    }

    @GetMapping("/task-edit")
    public String edit(@RequestParam("id") String id, Map<String, Object> model) {
        final Task task = taskRepository.findOneById(id);
        final Collection<Person> persons = personRepository.findAll();
        model.put("task", task);
        model.put("persons", persons);
        model.put("lastSelected", id);
        return "task-edit";
    }

    @PostMapping("/task-save")
    public String save(@ModelAttribute("task") Task task) {
        taskRepository.merge(task);
        return "redirect:/task-list";
    }

}
