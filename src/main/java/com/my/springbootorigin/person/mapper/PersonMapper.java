package com.my.springbootorigin.person.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.springbootorigin.person.pojo.model.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}
