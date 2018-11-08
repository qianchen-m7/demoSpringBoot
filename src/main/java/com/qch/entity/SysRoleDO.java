package com.qch.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class SysRoleDO implements Serializable{
    /** */
    private Integer id;

    /** 角色*/
    private String role;

    /** 描述*/
    private String decription;

    /** 是否有效（0：无效；1：有效）*/
    private String available;


}