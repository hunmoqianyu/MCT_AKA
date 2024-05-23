package com.example.vehicle.service;
import com.example.model.entity.VeC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (VeC)表服务接口
 *
 * @author makejava
 * @since 2024-05-13 15:03:24
 */
public interface
VeCService {

    /**
     * 通过ID查询单条数据
     *
     * @param vid 主键
     * @return 实例对象
     */
    VeC queryById(String vid);

    /**
     * 分页查询
     *
     * @param veC 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<VeC> queryByPage(VeC veC, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param veC 实例对象
     * @return 实例对象
     */
    VeC insert(VeC veC);

    /**
     * 修改数据
     *
     * @param veC 实例对象
     * @return 实例对象
     */
    VeC update(VeC veC);

    /**
     * 通过主键删除数据
     *
     * @param vid 主键
     * @return 是否成功
     */
    boolean deleteById(String vid);

}
