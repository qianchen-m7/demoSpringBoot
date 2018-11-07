package com.qch.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by BF100499 on 2018/11/6.
 */
@Setter
@Getter
public class User implements Serializable{
        private String id;
        private String userNo;
        private String userName;
        private String tel;
        private String email;
        private String password;
        private String identity;
}
