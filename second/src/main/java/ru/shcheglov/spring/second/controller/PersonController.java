package ru.shcheglov.spring.second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shcheglov.spring.second.model.Person;
import ru.shcheglov.spring.second.repository.PersonRepository;

import java.util.Collection;
import java.util.Map;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person-list")
    public String list(final Model model) {
        final Collection<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "person-list";
    }

    @GetMapping("/person-create")
    public String create() {
        personRepository.merge(new Person());
        return "redirect:/person-list";
    }

    @GetMapping("/person-remove")
    public String remove(@RequestParam("id") String id) {
        personRepository.removeById(id);
        return "redirect:/person-list";
    }

    @GetMapping("/person-edit")
    public String edit(@RequestParam("id") String id, Map<String, Object> model) {
        final Person person = personRepository.findOneById(id);
        model.put("person", person);
        return "person-edit";
    }

    @PostMapping("/person-save")
    public String save(@ModelAttribute("person") Person person) {
        personRepository.merge(person);
        return "redirect:/person-list";
    }

}
