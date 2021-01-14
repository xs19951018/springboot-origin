package com.my.springbootorigin.person.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.my.springbootorigin.person.mapper.PersonMapper;
import com.my.springbootorigin.person.pojo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonServiceTest {

    @Autowired(required = false)
    private PersonMapper personMapper;

    @Test
    public void testUpdate() {
        LambdaQueryWrapper<Person> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Person::getId, "3");
        Person person = new Person();
        person.setSex(1);
//        int count = personMapper.updateById(person);
        personMapper.update(person, wrapper);
        System.out.println(person);

    }
}
