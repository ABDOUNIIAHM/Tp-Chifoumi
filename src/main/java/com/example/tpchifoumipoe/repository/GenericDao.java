package com.example.tpchifoumipoe.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T,ID> {
    void save(T entity) throws SQLException;
    List<T> findAll();
    void update(T entity);
    T findById(ID id);
    void deleteById(ID id);

}
