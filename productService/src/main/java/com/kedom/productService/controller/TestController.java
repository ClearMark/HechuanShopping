package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.aop.ann.LogRecord;
import com.kedom.productService.aop.ann.VerifyAPIRequestCode;
import com.kedom.productService.entity.context.LogRecordContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productService/test")
@Slf4j
public class TestController {

    @Autowired
    private TestController testController;

    @PostMapping("/001")
    public void ab_1() {
        testController.a();
    }

    @PostMapping("/0011")
    @LogRecord(success = "测试")
    public void ab_11() {
        testController.a();
    }


    @PostMapping("/002")
    public void ab_2() {
        testController.a();
        testController.b();
    }

    @PostMapping("/0022")
    @LogRecord(success = "测试")
    public void ab_22() {
        testController.a();
        testController.b();
    }

    @PostMapping("/003")
    public void ab_3() {
        testController.a();
        testController.b();
        testController.c();
    }

    @PostMapping("/0033")
    @LogRecord(success = "测试")
    public void ab_33() {
        testController.a();
        testController.b();
        testController.c();
    }


    @PostMapping("/004")
    public void ab_4() {
        testController.a_1();
        testController.b();
        testController.c();
    }

    @PostMapping("/0044")
    @LogRecord(success = "测试")
    public void ab_44() {
        testController.a_1();
        testController.b();
        testController.c();
    }
    @PostMapping("/005")
    public void ab_5() {
        testController.a();
        testController.b_1();
        testController.c();
    }
    @PostMapping("/0055")
    @LogRecord(success = "测试")
    public void ab_55() {
        testController.a();
        testController.b_1();
        testController.c();
    }
    @PostMapping("/006")
    public void ab_6() {
        testController.a();
        testController.b();
        testController.c_1();
    }

    @PostMapping("/0066")
    @LogRecord(success = "测试")
    public void ab_66() {
        testController.a();
        testController.b();
        testController.c_1();
    }


    @LogRecord(success = "修改地址{address}")
    public void a() {
        LogRecordContext.putVariable("address", "重庆万州");
    }

    @LogRecord(success = "修改地址{address}")
    public void a_1() {
        LogRecordContext.putVariable("address", "重庆万州");
        throw new RuntimeException("测试异常");
    }




    @LogRecord(success = "修改配送人{name}")
    public void b() {
        LogRecordContext.putVariable("name", "杨永奇");
    }

    @LogRecord(success = "修改配送人{name}")
    public void b_1() {
        LogRecordContext.putVariable("name", "杨永奇");
        throw new RuntimeException("测试异常");
    }

    @LogRecord(success = "修改时间{date}")
    public void c() {
        LogRecordContext.putVariable("date", "2021-12-12");
    }

    @LogRecord(success = "修改时间{date}")
    public void c_1() {
        LogRecordContext.putVariable("date", "2021-12-12");
        throw new RuntimeException("测试异常");
    }



}
