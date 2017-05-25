package sample.doma.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class GroupsListener implements EntityListener<Groups> {

    @Override
    public void preInsert(Groups entity, PreInsertContext<Groups> context) {
    }

    @Override
    public void preUpdate(Groups entity, PreUpdateContext<Groups> context) {
    }

    @Override
    public void preDelete(Groups entity, PreDeleteContext<Groups> context) {
    }

    @Override
    public void postInsert(Groups entity, PostInsertContext<Groups> context) {
    }

    @Override
    public void postUpdate(Groups entity, PostUpdateContext<Groups> context) {
    }

    @Override
    public void postDelete(Groups entity, PostDeleteContext<Groups> context) {
    }
}