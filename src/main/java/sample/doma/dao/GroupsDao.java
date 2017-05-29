package sample.doma.dao;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import sample.doma.config.UseSlave;
import sample.doma.entity.Groups;

/**
 */
@Dao
@UseSlave
@ConfigAutowireable
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