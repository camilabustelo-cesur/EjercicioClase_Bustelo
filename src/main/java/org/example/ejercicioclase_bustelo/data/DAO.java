package org.example.ejercicioclase_bustelo.data;


import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> findByNombre(String nombre);
    List<T> findAll();
    T save(T obj);
    void update(T entity);
    void deleteByNombre(String nombre);
}
