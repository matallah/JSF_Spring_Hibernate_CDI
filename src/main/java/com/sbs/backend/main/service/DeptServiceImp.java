/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbs.backend.main.service;

import com.sbs.backend.main.dao.IDeptDAO;
import com.sbs.backend.main.dao.IEmpDAO;
import com.sbs.backend.main.entity.Dept;
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
public class DeptServiceImp implements IDeptService {

    @Autowired
    IDeptDAO deptDAO;

    @Autowired
    IEmpDAO empDAO;

    @Override
    public void insert(Dept dept) {
        deptDAO.insert(dept);
    }

    @Override
    public void update(Dept dept) {
        deptDAO.update(dept);
    }

    @Override
    public void delete(Dept dept) {
        deptDAO.delete(dept);
    }

    @Override
    public Dept findDept(int deptId) {
        return deptDAO.find(deptId);
    }

    @Override
    public List<Dept> findAllDepts() {
        return deptDAO.findAll();
    }

    //To Test Transaction
    @Transactional // Let Spring Handles Transactions. / U can put this annotation on method or on service class.
    @Override
    public void testTransaction() {

        //Dept table has no sequence , so u cannot insert.
        Dept dept = new Dept();
        dept.setDname("Dept_1");

        Emp emp = new Emp();
        emp.setEname("Emp_1");

        empDAO.insert(emp);
        deptDAO.insert(dept);

    }

}
