package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.doma.dao.PersonDao;
import sample.doma.domain.GroupId;
import sample.doma.entity.Person;
import sample.doma.entity.SafePerson;

import javax.validation.Valid;

/**
 * Created by chibana on 2017/05/26.
 */
@Service
public class ValidationDemoService {

    /**
     * validation on interceptor service
     * @param person
     * @return
     */
    public Person validateOnServiceIntercept(@Valid Person person) {
        // clean data
        return person;
    }

    // on dao exapmle
    @Autowired
    PersonDao personDao;
    /**
     * validation on interceptor service
     * @param person
     * @return
     */
    public Person validateWithDomaDomain(Person person) {
        SafePerson safePerson = new SafePerson();
        safePerson.setFirstName(person.getFirstName());
        safePerson.setLastName(person.getLastName());
        // should be thrown Exception if in-valid value
        safePerson.setGroupId(new GroupId(person.getGroupId()));
        // clean data if here
        personDao.insert(person);
        return person;
    }
}
