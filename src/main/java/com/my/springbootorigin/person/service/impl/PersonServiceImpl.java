package com.my.springbootorigin.person.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.springbootorigin.common.enums.BaseErrEnum;
import com.my.springbootorigin.person.mapper.PersonMapper;
import com.my.springbootorigin.person.pojo.model.Person;
import com.my.springbootorigin.person.service.PersonService;
import com.my.springbootorigin.utils.ResultVOUtil;
import com.my.springbootorigin.common.exception.BaseErrorException;
import com.my.springbootorigin.utils.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired(required = false)
    private PersonMapper personMapper;

    @Override
    public ResultVO getPersonListPage() {
        Page<Person> personPage = personMapper.selectPage(new Page<>(), new QueryWrapper<>());
        return ResultVOUtil.success(personPage);
    }

    @Override
    public ResultVO getPersonList() {
        return ResultVOUtil.success(personMapper.selectList(new QueryWrapper<>()));
    }

    @Override
    public ResultVO getPersonById(Integer id) {
        LambdaQueryWrapper<Person> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Person::getId, id);
        return ResultVOUtil.success(personMapper.selectOne(wrapper));
    }

    @Override
    public ResultVO addPerson(Person person) {
        int count = personMapper.insert(person);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.UPDATE_ERR);

        return ResultVOUtil.success(person);
    }

    @Override
    public ResultVO updatePerson(Person person) {
        //boolean b = new LambdaUpdateChainWrapper<>(personMapper).eq(Person::getId, person.getId()).update();
        int count = personMapper.updateById(person);
        if (count != 1) throw new BaseErrorException(BaseErrEnum.UPDATE_ERR);

        return ResultVOUtil.success(person);
    }

    @Override
    public ResultVO deletePersonById(Integer id) {
        return ResultVOUtil.success(personMapper.deleteById(id));
    }
}
