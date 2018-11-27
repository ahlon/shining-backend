package com.redq.shining.common;

import java.util.List;

/**
 * @author ahlon
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseMapper<T> getMapper();

    @Override
    public List<T> findAll() {
        return getMapper().selectAll();
    }

    @Override
    public T findById(Long id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public int save(T t) {
         return getMapper().insert(t);
    }

    @Override
    public int remove(Long id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int update(T t) {
        return getMapper().updateByPrimaryKey(t);
    }
}
