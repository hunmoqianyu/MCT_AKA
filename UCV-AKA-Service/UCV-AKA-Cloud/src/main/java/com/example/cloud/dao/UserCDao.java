package com.example.cloud.dao;
import com.example.model.entity.UserC;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (UserC)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-13 20:30:57
 */
@Mapper
public interface UserCDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserC queryById(String userId);

    /**
     * 查询指定行数据
     *
     * @param userC 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<UserC> queryAllByLimit(UserC userC, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userC 查询条件
     * @return 总行数
     */
    long count(UserC userC);

    /**
     * 新增数据
     *
     * @param userC 实例对象
     * @return 影响行数
     */
    int insert(UserC userC);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserC> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserC> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserC> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserC> entities);

    /**
     * 修改数据
     *
     * @param userC 实例对象
     * @return 影响行数
     */
    int update(UserC userC);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

}

