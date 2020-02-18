package club.mikusun.iadmin.post.service.impl;


import club.mikusun.iadmin.post.service.BaseService;
import lombok.Getter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    @Getter
    private JpaRepository<T, ID> dao;

    public BaseServiceImpl(JpaRepository dao) {
        this.dao = this.getDao();
    }

    public List<T> findAll() {
        return this.getDao().findAll();
    }

    public List<T> findAll(Sort sort) {
        return this.getDao().findAll(sort);
    }

    public List<T> findAllById(Iterable<ID> ids) {
        return this.getDao().findAllById(ids);
    }

    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return this.getDao().saveAll(entities);
    }

    public void flush() {
        this.getDao().flush();
    }

    public <S extends T> S saveAndFlush(S entity) {
        return this.getDao().saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<T> entities) {
        this.getDao().deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        this.getDao().deleteAllInBatch();
    }

    public T getOne(ID id) {
        return this.getDao().getOne(id);
    }

    public <S extends T> List<S> findAll(Example<S> example) {
        return this.getDao().findAll(example);
    }

    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return this.getDao().findAll(example, sort);
    }//

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        return this.getDao().findOne(example);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return this.getDao().findAll(pageable);
    }

    @Override
    public <S extends T> S save(S s) {
        return this.getDao().save(s);
    }

    @Override
    public Optional<T> findById(ID id) {
        return this.getDao().findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return this.getDao().existsById(id);
    }

    @Override
    public long count() {
        return this.getDao().count();
    }

    @Override
    public void deleteById(ID id) {
        this.getDao().deleteById(id);
    }

    @Override
    public void delete(T t) {
        this.getDao().delete(t);
    }

    @Override
    public void deleteAll(Iterable<? extends T> iterable) {
        this.getDao().deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        this.getDao().deleteAll();
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return this.getDao().findAll(example, pageable);
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return this.getDao().count(example);
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return this.getDao().exists(example);
    }
}
