/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbs.backend.main.dao;

import com.sbs.backend.main.dao.base.baseDAOImp;
import com.sbs.backend.main.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mohamed.attalah on 3/26/2018.
 */
@Repository
public class DeptDAOImp extends baseDAOImp<Dept> implements IDeptDAO {

    @Override
    public Dept find(int id) {
        Dept emp = (Dept) getCurrentSession().createQuery("SELECT e FROM Dept e WHERE e.deptno = :deptno")
                .setParameter("deptno", id).list().get(0);
        return emp;
    }

    @Override
    public List<Dept> findAll() {
        List list = getCurrentSession().createQuery("from Dept").list();
        return list;
    }

}
