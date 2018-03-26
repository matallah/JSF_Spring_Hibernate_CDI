/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbs.backend.main.dao;

import com.sbs.backend.main.dao.base.baseDAOImp;
import com.sbs.backend.main.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mohamed.attalah on 3/26/2018.
 */
@Repository
public class EmpDAOImp extends baseDAOImp<Emp> implements IEmpDAO {

    @Override
    public Emp find(int id) {
        Emp emp = (Emp) getCurrentSession().createQuery("SELECT e FROM Emp e WHERE e.empno = :empno")
                .setParameter("empno", id).list().get(0);
        return emp;
    }

    @Override
    public List<Emp> findAll() {
        List list = getCurrentSession().createQuery("from Emp").list();
        return list;
    }

}
