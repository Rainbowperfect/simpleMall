package org.mall.manager.service;

import java.util.List;

public interface BaseService<T> {

    /**
     * 跟据id查询数据
     * @param id
     * @return
     */
    T queryById(Long id);

    /**
     * 查询所有数据
     * @return
     */
    List<T> queryAll();

    /**
     * 跟据查询条件查询记录数
     * @param t
     * @return
     */
    Integer queryCountByWhere(T t);

    /**
     * 跟据查询条件查询数据列表
     * @param t
     * @return
     */
    List<T> queryListByWhere(T t);

    /**
     * 分页查询数据
     * @param pages
     * @param rows
     * @return
     */
    List<T> queryByPage(Integer pages,Integer rows);

    List<T> queryListByPage(Integer pages, Integer rows);

    /**
     * 跟据查询条件查询一个数据
     * @param t
     * @return
     */
    T queryOne(T t);

    /**
     * 保存数据
     * @param t
     */
    void save(T t);
    /**
     * 保存数据，忽略空字段
     * @param t
     */
    void saveSelective(T t);

    /**
     * 更新数据
     * @param t
     */
    void updateById(T t);

    /**
     * 更新数据，忽略空字段
     * @param t
     */
    void updateByIdSelective(T t);

    /**
     * 跟据id删除数据
     * @param id
     */
    void deleteById(Long id);

    /**
     * 跟据id列表删除数据
     * @param ids
     */
    void deleteByIds(List<Object> ids);
}
