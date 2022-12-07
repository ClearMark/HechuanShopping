package com.kedom.memberService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.common.entity.memberServiceEntity.UmsMember;
import com.kedom.memberService.dao.UmsMemberDao;
import com.kedom.memberService.service.UmsMemberService;
import com.kedom.openFeignService.entity.vo.UserRegisterVO;
import com.kedom.openFeignService.entity.vo.UserVO;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    private RedissonClient redissonClient;

    Logger logger = LoggerFactory.getLogger(UmsMemberServiceImpl.class);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsMember queryById(Long id) {
        this.umsMemberDao.queryById(id);
        return null;
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
    public void register(UserRegisterVO userRegisterVO) throws RuntimeException {
        //验证唯一性+加密密码。
        checkUsernameIsUnique(userRegisterVO.getUsername());
//        checkMobileIsUnique(userRegisterVO.getMobile());
        checkEmailIsUnique(userRegisterVO.getEmail());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodeAfterPassword = bCryptPasswordEncoder.encode(userRegisterVO.getPassword());

        //新增用户
            UmsMember umsMember = new UmsMember();
//        umsMember.setUsername(userRegisterVO.getUsername());
//        umsMember.setPassword(encodeAfterPassword);
//        umsMember.setMobile(userRegisterVO.getMobile());
//        umsMember.setEmail(userRegisterVO.getEmail());

        BeanUtils.copyProperties(userRegisterVO, umsMember);
        umsMemberDao.insert(umsMember);

    }


    @Override
    public UmsMember login(UserVO userLoginVo) {
        UmsMember umsMember = umsMemberDao.queryPublicInfoByUsername(userLoginVo.getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean matches = bCryptPasswordEncoder.matches(userLoginVo.getPassword(), umsMember.getPassword());
        if (matches) {
            return umsMember;
        } else {
            throw new KedomException(KedomExceptionEnum.USERNAME_PASSWORD_ERROR);
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
            throw new KedomException(KedomExceptionEnum.Mobile_IS_EXIST);
        }
    }


    @Override
    public UmsMember getMemberByAccessToken(String accessToken) {
        RBucket<Object> bucket = redissonClient.getBucket(accessToken, new StringCodec("utf-8"));
        UmsMember umsMember;
        if ((umsMember = (UmsMember) bucket.get()) != null) {
            return umsMember;
        }
        return null;
    }

    //endregion
}
