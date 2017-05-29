package sample.doma.entity;

import org.seasar.doma.jdbc.entity.*;

/**
 * 
 */
public class PersonListener implements EntityListener<Person> {

    @Override
    public void preInsert(Person entity, PreInsertContext<Person> context) {
    }

    @Override
    public void preUpdate(Person entity, PreUpdateContext<Person> context) {
    }

    @Override
    public void preDelete(Person entity, PreDeleteContext<Person> context) {
    }

    @Override
    public void postInsert(Person entity, PostInsertContext<Person> context) {
    }

    @Override
    public void postUpdate(Person entity, PostUpdateContext<Person> context) {
    }

    @Override
    public void postDelete(Person entity, PostDeleteContext<Person> context) {
    }
}
