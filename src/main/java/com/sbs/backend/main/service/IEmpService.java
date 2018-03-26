/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbs.backend.main.service;

import com.sbs.backend.main.entity.Emp;

import java.util.List;

/**
 * Created by mohamed.attalah on 3/26/2018.
 */
public interface IEmpService {

    public void insert(Emp emp);

    public void update(Emp emp);

    public void delete(Emp emp);

    public Emp findEmployee(int empId);

    public List<Emp> findAllEmployees();

}
