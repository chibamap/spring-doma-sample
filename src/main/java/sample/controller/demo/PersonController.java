package sample.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sample.doma.entity.Person;
import sample.service.PersonService;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by chibana on 2017/05/26.
 */
@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> listAll() {
        return personService.findAll();
    }

    /**
     * get one by id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}")
    public Person get(@PathVariable Long id) {
        return personService.findById(id);
    }

    /**
     * create one
     *
     * @param person
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person add(@RequestBody Person person) {
        return personService.add(person);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable Long id) {
        return personService.delete(id);
    }
}
