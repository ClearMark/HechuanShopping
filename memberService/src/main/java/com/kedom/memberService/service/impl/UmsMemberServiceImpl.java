package com.kedom.memberService.service.impl;

import com.google.gson.Gson;
import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.common.entity.memberServiceEntity.UmsMember;
import com.kedom.memberService.dao.UmsMemberDao;
import com.kedom.memberService.entity.AdminEditPasswordDTO;
import com.kedom.memberService.service.UmsMemberService;
import com.kedom.openFeignService.entity.vo.UserVO;
import com.kedom.productService.entity.UserSearchVO;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * 会员(UmsMember)表服务实现类
 *
 * @author makejava
 * @since 2022-10-29 22:37:16
 */
@Service("umsMemberService")
public class UmsMemberServiceImpl implements UmsMemberService {
    @Resource
    private UmsMemberDao umsMemberDao;
    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private Gson gson;

    Logger logger = LoggerFactory.getLogger(UmsMemberServiceImpl.class);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsMember queryById(Long id) {
        UmsMember umsMember = this.umsMemberDao.queryById(id);
        return umsMember;
    }


    /**
     * 新增数据
     *
     * @param umsMember 实例对象
     * @return 实例对象
     */
    @Override
    public Byte insert(UmsMember umsMember) {
        this.umsMemberDao.insert(umsMember);
        return null;
    }


    @Override
    public void updateDB(UmsMember umsMember) throws RuntimeException {
        //修改数据库
        int update = umsMemberDao.update(umsMember);
        if (update != 1) {
            throw new KedomException(KedomExceptionEnum.UPDATE_ERROR);
        }

    }

    @Override
    public void updateCache(UmsMember umsMember, String accessToken) throws RuntimeException {
        RBucket<Object> bucket = redissonClient.getBucket(accessToken, new StringCodec("utf-8"));
        bucket.set(umsMember);
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Byte deleteById(Long id) {
        this.umsMemberDao.deleteById(id);
        return null;
    }

    @Override
    public void register(UserVO userRegisterVO) throws RuntimeException {
        //验证唯一性+加密密码。
        checkUsernameIsUnique(userRegisterVO.getUsername());
//        checkMobileIsUnique(userRegisterVO.getMobile());
        checkEmailIsUnique(userRegisterVO.getEmail());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodeAfterPassword = bCryptPasswordEncoder.encode(userRegisterVO.getPassword());

        //新增用户
        UmsMember umsMember = new UmsMember();
//        umsMember.setUsername(userRegisterVO.getUsername());

//        umsMember.setMobile(userRegisterVO.getMobile());
//        umsMember.setEmail(userRegisterVO.getEmail());

        BeanUtils.copyProperties(userRegisterVO, umsMember);
        umsMember.setPassword(encodeAfterPassword);
        umsMemberDao.insert(umsMember);

    }


    @Override
    public UmsMember login(UserVO userLoginVo) {
        UmsMember umsMember = umsMemberDao.queryPublicInfoByUsername(userLoginVo.getUsername());
        if (umsMember == null) {
            throw new KedomException(KedomExceptionEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches(userLoginVo.getPassword(), umsMember.getPassword());
        if (matches) {
            return umsMember;
        } else {
            throw new KedomException(KedomExceptionEnum.USERNAME_OR_PASSWORD_ERROR);
        }
    }


    //region 协助服务的方法
    public void checkUsernameIsUnique(String username) throws RuntimeException {
        int i = umsMemberDao.queryUsernameIsUnique(username);
        if (i > 0) {
            throw new KedomException(KedomExceptionEnum.USERNAME_IS_EXIST);
        }
    }

    public void checkMobileIsUnique(String mobile) throws RuntimeException {
        int i = umsMemberDao.queryMobileIsUnique(mobile);
        if (i > 0) {
            throw new KedomException(KedomExceptionEnum.Mobile_IS_EXIST);
        }
    }

    public void checkEmailIsUnique(String email) throws RuntimeException {
        int i = umsMemberDao.queryEmailIsUnique(email);
        if (i > 0) {
            throw new KedomException(KedomExceptionEnum.EMAIL_IS_EXIST);
        }
    }


    @Override
    public UmsMember getMemberByAccessToken(String accessToken) {
        RBucket<String> bucket = redissonClient.getBucket(accessToken+"data", new StringCodec("utf-8"));
        UmsMember umsMember = gson.fromJson(bucket.get(), UmsMember.class);
        return umsMember;
    }

    @Override
    public List<UmsMember> queryAll(UserSearchVO vo) {

        vo.setPageNum((vo.getPageNum() - 1) * vo.getPageSize());
        List<UmsMember> userDataList = umsMemberDao.queryAll(vo);
        return userDataList;
    }

    @Override
    public Integer queryAllTotal(UserSearchVO userSearchVO) {

        return umsMemberDao.queryAllTotal(userSearchVO);
    }

    @Override
    public String resetPassword(Integer id) {
        String s = makeRandomPassword(8);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodeAfterPassword = bCryptPasswordEncoder.encode(s);
        umsMemberDao.resetPassword(id, encodeAfterPassword);
        return s;
    }

    @Override
    public String editPassword(AdminEditPasswordDTO umsAdmin) {
        UmsMember umsMember = umsMemberDao.queryById(Long.valueOf(umsAdmin.getId()));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches(umsAdmin.getOldPassword(), umsMember.getPassword());
        if (matches) {
            String encodeAfterPassword = bCryptPasswordEncoder.encode(umsAdmin.getNewPassword());
            umsMemberDao.updatePassword(umsAdmin.getId(), encodeAfterPassword);
            return "修改成功";
        } else {
            return "原密码错误";
        }
    }


    //产生8位随机数
    public String makeRandomPassword(int len) {
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*.?".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }

}
