package com.example.demoSpringBoot;

import com.qch.entity.User;
import com.qch.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void testas(){
        String s="调整1001-1031上海jgkhg;gjvbh暂fg";
        String reg="(?<=[0-9]+(?=[^0-9]*$)).+(?=暂)";
        Pattern r = Pattern.compile(reg);

        Matcher m = r.matcher(s);
        int i = 0;
        while (m.find()) {
            // group(0)或group()将会返回整个匹配的字符串（完全匹配）；group(i)则会返回与分组i匹配的字符
            // 这个例子只有一个分组
            System.out.println(m.group(0) );

        }

    }
}
