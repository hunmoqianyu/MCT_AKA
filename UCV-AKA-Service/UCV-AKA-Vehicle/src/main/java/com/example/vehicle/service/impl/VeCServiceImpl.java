package com.example.vehicle.service.impl;

import com.example.model.entity.VeC;
import com.example.vehicle.dao.VeCDao;
import com.example.vehicle.service.VeCService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (VeC)表服务实现类
 *
 * @author makejava
 * @since 2024-05-13 15:03:24
 */
@Service("veCService")
public class VeCServiceImpl implements VeCService {
    @Resource
    private VeCDao veCDao;

    /**
     * 通过ID查询单条数据
     *
     * @param vid 主键
     * @return 实例对象
     */
    @Override
    public VeC queryById(String vid) {
        return this.veCDao.queryById(vid);
    }

    /**
     * 分页查询
     *
     * @param veC 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<VeC> queryByPage(VeC veC, PageRequest pageRequest) {
        long total = this.veCDao.count(veC);
        return new PageImpl<>(this.veCDao.queryAllByLimit(veC, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param veC 实例对象
     * @return 实例对象
     */
    @Override
    public VeC insert(VeC veC) {
        this.veCDao.insert(veC);
        return veC;
    }

    /**
     * 修改数据
     *
     * @param veC 实例对象
     * @return 实例对象
     */
    @Override
    public VeC update(VeC veC) {
        this.veCDao.update(veC);
        return this.queryById(veC.getVid());
    }

    /**
     * 通过主键删除数据
     *
     * @param vid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String vid) {
        return this.veCDao.deleteById(vid) > 0;
    }
}
