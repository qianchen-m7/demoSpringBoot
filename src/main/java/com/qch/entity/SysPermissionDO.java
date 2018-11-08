package com.qch.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysPermissionDO {
    /** */
    private Integer id;

    /** 名称*/
    private String name;

    /** 资源类型，[menu|button]*/
    private String resourcetype;

    /** 资源路径*/
    private String url;

    /** 权限字符串,menu例子：role:*，button例子：role:create*/
    private String perssion;

    /** 父编号*/
    private Integer parentid;

    /** 是否有效（0：无效；1：有效）*/
    private String available;


}