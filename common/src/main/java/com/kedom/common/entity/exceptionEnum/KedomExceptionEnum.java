package com.kedom.common.entity.exceptionEnum;

import lombok.Getter;

@Getter
public enum KedomExceptionEnum {

    //用户异常
    USERNAME_IS_EXIST("用户名已存在"),
    Mobile_IS_EXIST("手机号已存在"),
    EMAIL_IS_EXIST("邮箱已存在"),
    USERNAME_PASSWORD_ERROR("账号或密码错误"),
    //通用异常
    UPDATE_ERROR("信息更新失败"),
    INSERT_ERROR("信息插入失败"),
    //产品管理异常
    CategoryNotIsThereLevelCateGory("分类不是三级分类"),
    AttrGroupNotUniqueOnCategory("同一分类下属性分组名称不能重复"),
    AttrGroupNotIsExist("分类 分组不存在"),
    GROUP_ATTR_IS_EXIST("分组属性已存在");



    KedomExceptionEnum(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }


    private final String exceptionMessage;
}
