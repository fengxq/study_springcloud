package fz.fxq.finance.dao.impl;

import fz.fxq.finance.dao.UserBalanceDAO;
import fz.fxq.finance.po.UserBalance;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class UserBalanceDAOImpl implements UserBalanceDAO {
    @Override
    public List<UserBalance> findAll() {
        return null;
    }

    @Override
    public List<UserBalance> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserBalance> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserBalance> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(UserBalance userBalance) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserBalance> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends UserBalance> S save(S s) {
        return null;
    }

    @Override
    public <S extends UserBalance> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<UserBalance> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends UserBalance> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<UserBalance> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UserBalance getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends UserBalance> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserBalance> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserBalance> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserBalance> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserBalance> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserBalance> boolean exists(Example<S> example) {
        return false;
    }
}
