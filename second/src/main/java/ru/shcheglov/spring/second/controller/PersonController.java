package ru.shcheglov.spring.second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.service.PersonService;

import java.util.Collection;
import java.util.Map;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person-list")
    public String list(final Model model) {
        final Collection<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);
        return "person-list";
    }

    @GetMapping("/person-create")
    public String create() {
        personService.merge(new Person());
        return "redirect:/person-list";
    }

    @GetMapping("/person-remove")
    public String remove(@RequestParam("id") String id) {
        personService.removeById(id);
        return "redirect:/person-list";
    }

    @GetMapping("/person-edit")
    public String edit(@RequestParam("id") String id, Map<String, Object> model) {
        final Person person = personService.findOneById(id);
        model.put("person", person);
        return "person-edit";
    }

    @PostMapping("/person-save")
    public String save(@ModelAttribute("person") Person person) {
        personService.merge(person);
        return "redirect:/person-list";
    }

}
