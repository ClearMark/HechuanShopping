package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsCommentReplayDao;
import com.kedom.productService.entity.PmsCommentReplay;
import com.kedom.productService.service.PmsCommentReplayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品评价回复关系(PmsCommentReplay)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Service("pmsCommentReplayService")
public class PmsCommentReplayServiceImpl implements PmsCommentReplayService {
    @Resource
    private PmsCommentReplayDao pmsCommentReplayDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsCommentReplay queryById(Long id) {
       PmsCommentReplay obj=this.pmsCommentReplayDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsCommentReplay 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsCommentReplay pmsCommentReplay) {
       int count= this.pmsCommentReplayDao.insert(pmsCommentReplay);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsCommentReplay 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsCommentReplay pmsCommentReplay) {
       int count= this.pmsCommentReplayDao.update(pmsCommentReplay);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

}
