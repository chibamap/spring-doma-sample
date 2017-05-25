package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.doma.dao.PersonDao;
import sample.doma.entity.Groups;
import sample.doma.entity.Person;

import java.util.List;

/**
 * Created by chibana on 2017/05/25.
 */
@Service
public class DemoService {
    @Autowired
    PersonDao personDao;

    public List<Person> findByGname(String gname) {
        Groups group = new Groups();
        group.setName(gname);
        return personDao.findByGroup(group);
    }
}
