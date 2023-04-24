package com.kedom.memberService.service;

import com.kedom.common.entity.memberServiceEntity.UmsMember;
import com.kedom.memberService.entity.AdminEditPasswordDTO;
import com.kedom.openFeignService.entity.vo.UserVO;
import com.kedom.productService.entity.UserSearchVO;

import java.util.List;


/**
 * 会员(UmsMember)表服务接口
 *
 * @author makejava
 * @since 2022-10-29 22:37:16
 */
public interface UmsMemberService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsMember queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsMember 实例对象
     * @return 实例对象
     */
    Byte insert(UmsMember umsMember);

    /**
     * 修改数据
     *
     * @param umsMember 实例对象
     * @return 实例对象
     */
    void updateDB(UmsMember umsMember) throws RuntimeException;

    void updateCache(UmsMember umsMember,String cacheKey) throws RuntimeException;
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Byte deleteById(Long id);

    void register(UserVO userRegisterVO) throws RuntimeException;

    void checkUsernameIsUnique(String username) throws RuntimeException;

    void checkMobileIsUnique(String username) throws RuntimeException;

    UmsMember login(UserVO userLoginVo);

    public UmsMember getMemberByAccessToken(String accessToken);

    List<UmsMember> queryAll(UserSearchVO pageNum);

    Integer queryAllTotal(UserSearchVO userSearchVO);

    String resetPassword(Integer id);

    String editPassword(AdminEditPasswordDTO umsAdmin);
}
