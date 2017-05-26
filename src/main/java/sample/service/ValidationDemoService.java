package sample.service;

import org.springframework.stereotype.Service;
import sample.doma.entity.Person;

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
    public Person validateTest(@Valid Person person) {
        return person;
    }

}
