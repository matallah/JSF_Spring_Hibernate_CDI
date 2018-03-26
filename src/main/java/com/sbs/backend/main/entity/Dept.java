/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbs.backend.main.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mohamed.attalah on 3/26/2018.
 */
@Entity
@Table(name = "DEPT")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d")
        , @NamedQuery(name = "Dept.findByDeptno", query = "SELECT d FROM Dept d WHERE d.deptno = :deptno")
        , @NamedQuery(name = "Dept.findByDname", query = "SELECT d FROM Dept d WHERE d.dname = :dname")
        , @NamedQuery(name = "Dept.findByLoc", query = "SELECT d FROM Dept d WHERE d.loc = :loc")})
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPTNO")
    private Integer deptno;
    @Size(max = 14)
    @Column(name = "DNAME")
    private String dname;
    @Size(max = 13)
    @Column(name = "LOC")
    private String loc;
    @OneToMany(mappedBy = "deptno")
    private List<Emp> empList;

    public Dept() {
    }

    public Dept(Integer deptno) {
        this.deptno = deptno;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @XmlTransient
    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptno != null ? deptno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dept)) {
            return false;
        }
        Dept other = (Dept) object;
        if ((this.deptno == null && other.deptno != null) || (this.deptno != null && !this.deptno.equals(other.deptno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dept[ deptno=" + deptno + " ]";
    }

}
