/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbs.backend.main.service;

import com.sbs.backend.main.entity.Dept;

import java.util.List;

/**
 * Created by mohamed.attalah on 3/26/2018.
 */
public interface IDeptService {

    public void insert(Dept dept);

    public void update(Dept dept);

    public void delete(Dept dept);

    public Dept findDept(int deptId);

    public List<Dept> findAllDepts();

    public void testTransaction();

}
