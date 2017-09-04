package com.wucy.fileupload.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T,ID extends Serializable> {

    /**
     * 保存
     * @param model
     */
    T save(T model);

    /**
     *混合方法
     * @param model
     */
    T merge(T model);

    /**
     *根据Id删除
     * @param id
     */
    void delete(ID id);

    /**
     *根据对象删除
     * @param model
     */
    void deleteObject(T model);

    /**
     * 根据Id获取对象
     * @param id
     * @return
     */
    T get(ID id);

    /**
     * 统计总条数
     * @return
     */
    long countAll();

    /**
     *查询列表
     * @return
     */
    List<T> listAll();

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<T> findByPage(Pageable pageable);

    /**
     * 根据Id判断对象是否存在
     * @param id
     * @return
     */
    boolean exists(ID id);

    void flush();

    void clear();


}
