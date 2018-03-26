/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbs.backend.main.dao.base;

/**
 * Created by mohamed.attalah on 3/26/2018.
 */
public interface IBaseDAO<T> {

    public void insert(T entity);

    public void update(T entity);

    public void delete(T entity);

}
