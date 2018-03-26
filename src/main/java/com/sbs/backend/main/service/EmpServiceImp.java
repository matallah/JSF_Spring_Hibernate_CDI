/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbs.backend.main.service;

import com.sbs.backend.main.dao.IEmpDAO;
import com.sbs.backend.main.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mohamed.attalah on 3/26/2018.
 */
@Service
@Transactional
public class EmpServiceImp implements IEmpService {

    @Autowired
    private IEmpDAO empDAO;

    @Override
    public void insert(Emp emp) {
        empDAO.insert(emp);
    }

    @Override
    public void update(Emp emp) {
        empDAO.update(emp);
    }

    @Override
    public void delete(Emp emp) {
        empDAO.delete(emp);
    }

    @Override
    public Emp findEmployee(int empId) {
        return empDAO.find(empId);
    }

    @Override
    public List<Emp> findAllEmployees() {
        return empDAO.findAll();
    }

}
