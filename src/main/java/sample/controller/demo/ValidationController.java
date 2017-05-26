package sample.controller.demo;

/**
 * Created by chibana on 2017/05/26.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sample.doma.entity.Person;
import sample.dto.Demo;
import sample.service.PersonService;

import javax.validation.Valid;

/**
 * Validation implementation pattern
 */
@RequestMapping("/validate")
@RestController
public class ValidationController {

    @Autowired
    PersonService personService;

    /**
     * validate on request
     *
     * @param demo
     * @return
     */
    @RequestMapping(value = "/on-req", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Demo add(@Valid @RequestBody Demo demo) {
        return demo;
    }

}
