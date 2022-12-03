package com.kedom.common.entity.exceptionEnum;

import lombok.Getter;

@Getter
public enum KedomExceptionEnum {


    //用户异常 10开
    USERNAME_IS_EXIST(1001, "用户名已存在"),
    Mobile_IS_EXIST(1002, "手机号已存在"),
    EMAIL_IS_EXIST(1003, "邮箱已存在"),
    USERNAME_PASSWORD_ERROR(1004, "账号或密码错误"),
    //通用异常 20开
    UPDATE_ERROR(2001, "信息更新失败"),
    INSERT_ERROR(2002, "信息插入失败"),

    //产品管理异常 30开
    CategoryNotIsThereLevelCateGory(3001, "分类不是三级分类"),
    AttrGroupNotUniqueOnCategory(3002, "同一分类下属性分组名称不能重复"),
    AttrGroupNotIsExist(3003, "分类 分组不存在"),
    GROUP_ATTR_IS_EXIST(3004, "分组属性已存在"),
    PUT_ON_SHELVES_ERROR(3005, "上架失败");


    KedomExceptionEnum(Integer exceptionCode, String exceptionMessage) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }

    private final Integer exceptionCode;

    private final String exceptionMessage;

}
