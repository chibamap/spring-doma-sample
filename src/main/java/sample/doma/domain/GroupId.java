package sample.doma.domain;

import org.seasar.doma.Domain;
import sample.ApplicationContextProvider;
import sample.doma.dao.GroupsDao;
import sample.doma.entity.Groups;

/**
 * Created by chibana on 2017/05/29.
 */
@Domain(valueType = Integer.class)
public class GroupId {

    private final Integer value;

    public GroupId(Integer value) {
        if (!checkValue(value)) {
            throw new IllegalArgumentException(String.format("Illegal group_id[%d] given.", value));
        }
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    private boolean checkValue(Integer groupId) {
        if (null == groupId) {
            return true;
        }
        Groups group = groupDao().selectById(groupId);
        return null != group;
    }

    static GroupsDao _groupsDao = null;
    private static GroupsDao groupDao() {
        if (null == _groupsDao) {
            _groupsDao = ApplicationContextProvider.getContext()
                    .getBean(GroupsDao.class);
        }
        return _groupsDao;
    }
}
