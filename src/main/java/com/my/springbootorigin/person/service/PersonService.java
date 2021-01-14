package com.my.springbootorigin.person.service;

import com.my.springbootorigin.person.pojo.model.Person;
import com.my.springbootorigin.utils.vo.ResultVO;

public interface PersonService {

    ResultVO getPersonListPage();

    ResultVO getPersonList();

    ResultVO getPersonById(Integer id);

    ResultVO addPerson(Person person);

    ResultVO updatePerson(Person person);

    ResultVO deletePersonById(Integer id);

}
