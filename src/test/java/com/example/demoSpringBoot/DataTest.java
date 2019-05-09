package com.example.demoSpringBoot;

import com.qch.entity.User;
import com.qch.mapper.UserMapper;
import org.assertj.core.util.introspection.FieldUtils;
import org.json.JSONString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
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

    @Test
    public void testasCII() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
   /* String d=stringToAscii("ddName");
        System.out.println(d);*/
        User u=new User();
        u.setEmail("ds@1.com");
        u.setPaId("ds");
        u.setId("ef");
        u.setPassword("gewugen");
        Class tempClass=User.class;
       /* Method[] methods=cl.getMethods();
        List<String>list=new ArrayList<>();
        for(Method m:methods)
        {
            Parameter[] parameters=m.getParameters();
            if(m.getName().equals("get"))
            {
                for (Parameter p:parameters) {
                    list.add(p.getName());

                }
            }
        }*/
        List<Field> fieldList = new ArrayList<>() ;
        while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(tempClass .getDeclaredFields()));
            tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
        }
        List<String>list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        for (Field field : fieldList) {
            // 得到成员变量的类型的类类型
            Class<?> filedType = field.getType();
            String typeName = filedType.getName();
            String fieldName = field.getName();
          /*  *//**拼接get方法,如getId  **//*
            String getMethod = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1,fieldName.length());
            *//**
             调用clazz的getMethod方法获取类的指定get方法
             通过invoke执行获取变量值
             **//*
            System.out.println(tempClass.getMethod(getMethod).invoke(u));*/

            field.setAccessible(true);
           // System.out.println(field.get(u));

            if(field.get(u)!=null)
            {
                list.add(fieldName);
                map.put(fieldName,field.get(u));
            }


        }

        Collections.sort(list);
        StringBuffer sbu = new StringBuffer();
        for(String s:list)
        {
           /* System.out.println(s);
            Field field = tempClass.getDeclaredField(s);
            field.setAccessible(true);
            if(field.get(u)!=null) {
                sbu.append(s).append("=").append(field.get(u)).append("&");
            }*/
            if(map.get(s)!=null) {
                sbu.append(s).append("=").append(map.get(s)).append("&");
            }

        }
        String sbu1=sbu.substring(0,sbu.length()-1);

        System.out.println(sbu1);

    }
    public static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }

    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {

            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
    public static int compareToMax(String value1,String value2)
    {
        value1.compareTo(value2);
        char[] v1=value1.toCharArray();
        char[] v2=value2.toCharArray();
        int[] in1=charToInt(v1);
        int[] in2=charToInt(v2);

        for(int i=0;i<in1.length;i++)
        {
            for(int j=0;j<in2.length;j++)
            {

            }
        }

        return 0;
    }
    public static int[] charToInt(char[] v)
    {
        int[] in=new int[v.length];
        for(int i=0;i<v.length;i++)
        {
            in[i]=Integer.parseInt(String.valueOf(v[i]));
        }
        return in;
    }
}
