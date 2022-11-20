package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.entity.PmsSpuComment;
import com.kedom.productService.dao.PmsSpuCommentDao;
import com.kedom.productService.service.PmsSpuCommentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

/**
 * 商品评价(PmsSpuComment)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Service("pmsSpuCommentService")
public class PmsSpuCommentServiceImpl implements PmsSpuCommentService {
    @Resource
    private PmsSpuCommentDao pmsSpuCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsSpuComment queryById(Long id) {
       PmsSpuComment obj=this.pmsSpuCommentDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsSpuComment 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsSpuComment pmsSpuComment) {
       int count= this.pmsSpuCommentDao.insert(pmsSpuComment);
       if(count==0)
       {
       throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsSpuComment 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsSpuComment pmsSpuComment) {
       int count= this.pmsSpuCommentDao.update(pmsSpuComment);
       if(count==0)
       {
        throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

}
