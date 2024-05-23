package com.example.cloud.service.impl;

import com.example.cloud.dao.UserCDao;
import com.example.cloud.service.UserCService;
import com.example.model.entity.UserC;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (UserC)表服务实现类
 *
 * @author makejava
 * @since 2024-05-13 20:30:59
 */
@Service
public class UserCServiceImpl implements UserCService {
    @Resource
    private UserCDao userCDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public UserC queryById(String userId) {
        return this.userCDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param userC 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserC> queryByPage(UserC userC, PageRequest pageRequest) {
        long total = this.userCDao.count(userC);
        return new PageImpl<>(this.userCDao.queryAllByLimit(userC, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userC 实例对象
     * @return 实例对象
     */
    @Override
    public UserC insert(UserC userC) {
        this.userCDao.insert(userC);
        return userC;
    }

    /**
     * 修改数据
     *
     * @param userC 实例对象
     * @return 实例对象
     */
    @Override
    public UserC update(UserC userC) {
        this.userCDao.update(userC);
        return this.queryById(userC.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.userCDao.deleteById(userId) > 0;
    }
}
