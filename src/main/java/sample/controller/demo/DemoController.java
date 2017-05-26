package sample.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sample.doma.entity.Person;
import sample.service.DemoService;

import java.util.List;

/**
 * Created by chibana on 2017/05/25.
 */
@RequestMapping("/demo")
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public List<Person> test(@RequestParam(value="groupName", defaultValue="hoge") String name) {
        return demoService.findByGname(name);
    }


    @RequestMapping("/rollback")
    public String rollback() {
        demoService.rollbackTest();
        return "rollback";
    }

    @RequestMapping("/noTx")
    public String noTx() {
        demoService.nonTxTest();
        return "nonTxTest";
    }

    @RequestMapping("/commit")
    public String commit(@RequestParam(value = "from", defaultValue="10") int from,
                           @RequestParam(value = "to", defaultValue = "20") int to) {
        demoService.batchInsert(from, to);
        return "commit";
    }

}
