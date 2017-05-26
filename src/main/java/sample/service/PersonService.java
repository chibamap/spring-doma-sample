package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.doma.dao.PersonDao;
import sample.doma.entity.Person;

import java.util.List;

/**
 * Created by chibana on 2017/05/26.
 */
@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public Person findById(Long id) {
        return personDao.findById(id);
    }

    public Person add(Person person) {
        personDao.insert(person);
        return person;
    }

    public Person update(Person person) {
        personDao.update(person);
        return person;
    }

    public int delete(Long id) {
        Person person = personDao.findById(id);
        return personDao.delete(person);
    }
}
