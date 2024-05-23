package com.example.cloud.service;
import com.example.model.entity.UserC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (UserC)表服务接口
 *
 * @author makejava
 * @since 2024-05-13 20:30:58
 */
public interface UserCService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserC queryById(String userId);

    /**
     * 分页查询
     *
     * @param userC 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<UserC> queryByPage(UserC userC, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userC 实例对象
     * @return 实例对象
     */
    UserC insert(UserC userC);

    /**
     * 修改数据
     *
     * @param userC 实例对象
     * @return 实例对象
     */
    UserC update(UserC userC);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}
