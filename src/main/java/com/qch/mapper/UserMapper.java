package com.qch.mapper;

import com.qch.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by BF100499 on 2018/11/6.
 */
public interface UserMapper {


        @Select("SELECT * FROM user")
        //@Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
        @Results({
                @Result(property = "userName", column = "USER_NAME")
        })
        List<User> getAll();

        @Select("SELECT * FROM user WHERE id = #{id}")
        @Results({
                @Result(property = "userName", column = "USER_NAME")
        })
        User getOne(Long id);

        @Insert("INSERT INTO user(USER_NO,USER_NAME,TEL,EMAIL,PASSWORD,IDENTITY) VALUES(#{userNo},#{userName},#{tel},#{email}, #{password},#{identity})")
        void insert(User user);

        @Update("UPDATE user SET userName=#{userName} WHERE id =#{id}")
        void update(User user);


}
