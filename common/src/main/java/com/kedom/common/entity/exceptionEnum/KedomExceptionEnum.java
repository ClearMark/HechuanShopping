package com.kedom.common.entity.exceptionEnum;

import lombok.Getter;

@Getter
public enum KedomExceptionEnum {


    //用户异常 10开
    USERNAME_IS_EXIST(1001, "用户名已存在"),
    Mobile_IS_EXIST(1002, "手机号已存在"),
    EMAIL_IS_EXIST(1003, "邮箱已存在"),
    USERNAME_OR_PASSWORD_ERROR(1004, "账号或密码错误"),
    //通用异常 20开
    UPDATE_ERROR(2001, "信息更新失败"),
    INSERT_ERROR(2002, "信息插入失败"),
    API_REQUEST_CODE_ERROR(2003, "重复请求了"),
    VERIFY_CODE_ERROR(2004, "验证码错误"),
    REQUEST_PARAMETER_ERROR(2005, "请求参数错误"),
    TOKEN_AND_USERID_ERROR(2006, "Token与用户信息不符"),
    //产品管理异常 30开
    CategoryNotIsThereLevelCateGory(3001, "分类不是三级分类"),
    AttrGroupNotUniqueOnCategory(3002, "同一分类下属性分组名称不能重复"),
    AttrGroupNotIsExist(3003, "分类 分组不存在"),
    GROUP_ATTR_IS_EXIST(3004, "分组属性已存在"),
    PUT_ON_SHELVES_ERROR(3005, "上架失败"),
    SKU_WARE_EXIST(3006, "库存信息已存在"),
    SKU_INTO_WARE_ERROR_BY_CREATE_ID_ERROR(3007, "入库失败创建人ID错误"),
    SKU_NOT_EXIST(3008, "商品不存在"),
    SKU_ID_NOT_EMPTY(3020, "SKU不能为空"), SHOP_NO_HAVE(4001,"店铺不存在" ), DELETE_ERROR(4002,"删除失败" );


    KedomExceptionEnum(Integer exceptionCode, String exceptionMessage) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }

    private final Integer exceptionCode;

    private final String exceptionMessage;

}
