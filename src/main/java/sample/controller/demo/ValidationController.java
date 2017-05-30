package sample.controller.demo;

/**
 * Created by chibana on 2017/05/26.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sample.doma.entity.Person;
import sample.dto.Demo;
import sample.dto.DomainDemo;
import sample.service.ValidationDemoService;

import javax.validation.Valid;

/**
 * Validation implementation pattern
 */
@RequestMapping("/validate")
@RestController
public class ValidationController {

    @Autowired
    ValidationDemoService validationDemoService;

    /**
     * validate on request
     *
     * @param demo
     * @return
     */
    @RequestMapping(value = "/request", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Demo onRequest(@Valid @RequestBody Demo demo) {
        // already clean data;
        return demo;
    }

    /**
     * validate on request
     *
     * @param demo
     * @return
     */
    @RequestMapping(value = "/request_with_domain", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public DomainDemo onRequestWithDomain(@Valid @RequestBody DomainDemo demo) {
        // already clean data;
        return demo;
    }

    /**
     * validate on service
     *
     * @param demo
     * @return
     */
    @RequestMapping(value = "/service", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person onService(@RequestBody Demo demo) {
        // here is dirty yet.
        Person person = new Person();
        person.setFirstName(demo.getFirstName());
        person.setLastName(demo.getLastName());
        person.setGroupId(demo.getGroupId());
        validationDemoService.validateOnServiceIntercept(person);
        return person;
    }

    /**
     * validate on dao
     *
     * @param demo
     * @return
     */
    @RequestMapping(value = "/dao", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person onDao(@RequestBody Demo demo) {
        // here is dirty yet.
        Person person = new Person();
        person.setFirstName(demo.getFirstName());
        person.setLastName(demo.getLastName());
        person.setGroupId(demo.getGroupId());
        person = validationDemoService.validateWithDomaDomain(person);
        // generated person(should be clean)
        return person;
    }
}
