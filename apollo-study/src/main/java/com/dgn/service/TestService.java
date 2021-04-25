package com.dgn.service;

import com.dgn.entity.People;
import com.dgn.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/4/23 17:24
 */
@Service
public class TestService {
    @Autowired
    PeopleMapper peopleMapper;

    public void test(){
        List<People> peopleList = peopleMapper.selectAll();
        System.out.println(peopleList);
    }
}
