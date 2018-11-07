package com.example.demoSpringBoot;

import com.qch.entity.User;
import com.qch.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by BF100499 on 2018/11/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTest {

    @Autowired
    private UserMapper UserMapper;

    @Test
    public void testInsert() throws Exception {
        User user=new User();
        user.setUserName("小李飞刀");
        UserMapper.insert(user);


    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = UserMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = UserMapper.getOne(1l);
        System.out.println(user.toString());
;
    }
}
