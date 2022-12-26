package app.controller;


import app.dao.PersonDAO;
import app.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonDAO personDAO;

    @Autowired
    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id_person){
        model.addAttribute("person", personDAO.show(id_person));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") Person person){
        personDAO.createPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/update")
    public String editPage(@PathVariable("id") int id,
                           Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/update";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("person") Person person,
                       @PathVariable("id") int id){
        personDAO.update(person, id);
        return "redirect:/people";
    }
}
