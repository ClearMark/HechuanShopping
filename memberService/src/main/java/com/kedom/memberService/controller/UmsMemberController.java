package com.kedom.memberService.controller;

import com.google.gson.Gson;
import com.kedom.common.entity.KedomResponse;
import com.kedom.common.entity.memberServiceEntity.UmsMember;
import com.kedom.memberService.service.UmsMemberService;
import com.kedom.openFeignService.entity.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员(UmsMember)表控制层
 *
 * @author makejava
 * @since 2022-10-29 22:37:16
 */
@RestController
@RequestMapping("/umsMember")
public class UmsMemberController {
    @Resource
    Gson gson;
    /**
     * 服务对象
     */
    @Resource
    private UmsMemberService umsMemberService;

    @PostMapping("/register")
    public KedomResponse register(@RequestBody UserVO userRegisterVO) {

        umsMemberService.register(userRegisterVO);

        return KedomResponse.ok();
    }

    @PostMapping("/login")
    public KedomResponse login(@RequestBody UserVO userLoginVo) {
        UmsMember umsMember = umsMemberService.login(userLoginVo);
        umsMember.setPassword(null);
        return KedomResponse.okAddData(gson.toJson(umsMember));
    }

    @PostMapping("/updateMemberInfo")
    public KedomResponse updateUserInfo(@RequestBody UmsMember umsMember,@RequestHeader("accessToken") String accessToken) {
        //校验参数
//        UmsMember redisMember = umsMemberService.getMemberByAccessToken(accessToken);
//        umsMember.setId(redisMember.getId());
//        umsMember.setUsername(redisMember.getUsername());
        umsMemberService.updateDB(umsMember);
//        umsMemberService.updateCache(umsMember, accessToken);
        return KedomResponse.ok();
    }

    @GetMapping("/queryAll/{pageNum}")
    public KedomResponse queryAll(@PathVariable("pageNum") Integer pageNum) {
       List<UmsMember> userDataList = umsMemberService.queryAll(pageNum);
        return KedomResponse.okAddData(userDataList);
    }





//    @ExceptionHandler(Exception.class)
//    public KedomResponse exceptionHandling(Exception e) {
//
//        KedomResponse kedomResponse = new KedomResponse();
//
//
//        kedomResponse.fillCode(9999,e.getMessage());
//        return kedomResponse;
//    }


}
