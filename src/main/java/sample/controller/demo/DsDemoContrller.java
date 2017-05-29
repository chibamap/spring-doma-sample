package sample.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.doma.dao.GroupsDao;
import sample.doma.entity.Groups;

import javax.validation.constraints.NotNull;

/**
 * Created by chibana on 2017/05/29.
 */
@RequestMapping("/ds-demo")
@RestController
public class DsDemoContrller {

    @Autowired
    GroupsDao groupsDao;

    @RequestMapping("/slave/{id}")
    public Groups fromSlave(@NotNull @PathVariable Integer id) {
        return groupsDao.selectById(id);
    }
}
