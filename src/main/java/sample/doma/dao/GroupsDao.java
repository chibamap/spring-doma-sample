package sample.doma.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import sample.doma.entity.Groups;

/**
 */
@Dao
public interface GroupsDao {

    /**
     * @param id
     * @return the Groups entity
     */
    @Select
    Groups selectById(Integer id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Groups entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Groups entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Groups entity);
}