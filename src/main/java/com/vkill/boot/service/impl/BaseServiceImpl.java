package com.vkill.boot.service.impl;

import com.vkill.boot.model.BaseModel;
import com.vkill.boot.service.BaseService;
import com.vkill.boot.hdao.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public abstract class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T,ID> {

    @Autowired
    BaseRepository<T,ID> baseRepository;


    @Override
    public T save(T model) {
        BaseModel bm = (BaseModel) model;
        bm.setCreateTime(new Date());
        bm.setUpdateTime(new Date());
        return baseRepository.save(model);
    }

    @Override
    public T merge(T model) {
        return null;
    }

    @Override
    public void delete(ID id) {
         baseRepository.delete(id);
    }

    @Override
    public void deleteObject(T model) {
        baseRepository.delete(model);
    }

    @Override
    public T get(ID id) {
        return baseRepository.findOne(id);
    }

    @Override
    public long countAll() {
        return baseRepository.count();
    }

    @Override
    public List<T> listAll() {
        return baseRepository.findAll();
    }

    @Override
    public Page<T> findByPage(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    @Override
    public boolean exists(ID id) {
        return baseRepository.exists(id);
    }

    @Override
    public void flush() {
        baseRepository.flush();
    }

    @Override
    public void clear() {

    }


}
