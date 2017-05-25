package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
