package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.doma.dao.PersonDao;
import sample.doma.entity.Groups;
import sample.doma.entity.Person;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by chibana on 2017/05/25.
 */
@Service
@Transactional
public class DemoService {
    @Autowired
    PersonDao personDao;

    public List<Person> findByGname(String gname) {
        Groups group = new Groups();
        group.setName(gname);
        return personDao.findByGroup(group);
    }

    /**
     * roll back sample
     */
    public void rollbackTest() {
        this.insertPersons(0, 10);

        Person groupIdNotFound = new Person();
        groupIdNotFound.setGroupId(5);
        groupIdNotFound.setFirstName("GroupId");
        groupIdNotFound.setLastName("NotFound");
        // ここでFKEY例外でロールバック
        personDao.insert(groupIdNotFound);
    }

    /**
     * commit work sample
     *
     * @param from name index from
     * @param to name index to
     */
    public void batchInsert(int from, int to) {
        this.insertPersons(from, to);
    }

    private void insertPersons(int from, int to) {
        final String firstNameTemplate = "First%d";
        final String lastNameTemplate = "Last%d";

        IntStream.range(from, to)
                .forEach(i -> {
                    Person person = new Person();
                    person.setFirstName(String.format(firstNameTemplate, i));
                    person.setLastName(String.format(lastNameTemplate, i));
                    personDao.insert(person);
                });

    }
}
