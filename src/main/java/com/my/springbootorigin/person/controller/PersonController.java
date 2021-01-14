package com.my.springbootorigin.person.controller;

import com.my.springbootorigin.person.pojo.model.Person;
import com.my.springbootorigin.person.service.PersonService;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/get/list/page")
    public ResultVO getPersonListPage() {
        return personService.getPersonListPage();
    }

    @RequestMapping("/get/list")
    public ResultVO getPersonList() {
        return personService.getPersonList();
    }

    @RequestMapping("/get/byId")
    public ResultVO getPersonById(@RequestParam("id") Integer id) {
        return personService.getPersonById(id);
    }

    @RequestMapping("/add/one")
    public ResultVO addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @RequestMapping("/update/byId")
    public ResultVO updatePersonById(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @RequestMapping("/delete/byId")
    public ResultVO deletePersonById(@RequestParam("id") Integer id) {
        return personService.deletePersonById(id);
    }
}
