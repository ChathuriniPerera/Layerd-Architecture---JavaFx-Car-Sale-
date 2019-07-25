package Dao;

import Entity.SuperEntity;

import java.util.List;

public interface CrudDao<T extends SuperEntity, ID> extends SuperDao {

    boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID entityId) throws Exception;

    List<T> findAll() throws Exception;

    T find(ID entityId) throws Exception;
}