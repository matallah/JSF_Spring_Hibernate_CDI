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
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mohamed.attalah on 3/26/2018.
 */
@Entity
@Table(name = "EMP")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Emp.findAll", query = "SELECT e FROM Emp e")
        , @NamedQuery(name = "Emp.findByEmpno", query = "SELECT e FROM Emp e WHERE e.empno = :empno")
        , @NamedQuery(name = "Emp.findByEname", query = "SELECT e FROM Emp e WHERE e.ename = :ename")
        , @NamedQuery(name = "Emp.findByJob", query = "SELECT e FROM Emp e WHERE e.job = :job")
        , @NamedQuery(name = "Emp.findByMgr", query = "SELECT e FROM Emp e WHERE e.mgr = :mgr")
        , @NamedQuery(name = "Emp.findByHiredate", query = "SELECT e FROM Emp e WHERE e.hiredate = :hiredate")
        , @NamedQuery(name = "Emp.findBySal", query = "SELECT e FROM Emp e WHERE e.sal = :sal")
        , @NamedQuery(name = "Emp.findByComm", query = "SELECT e FROM Emp e WHERE e.comm = :comm")})
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPNO")
    @SequenceGenerator(name = "EMP_SEQ", sequenceName = "EMP_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empno;
    @Size(max = 10)
    @Column(name = "ENAME")
    private String ename;
    @Size(max = 9)
    @Column(name = "JOB")
    private String job;
    @Column(name = "MGR")
    private Short mgr;
    @Column(name = "HIREDATE")
    @Temporal(TemporalType.DATE)
    private Date hiredate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SAL")
    private BigDecimal sal;
    @Column(name = "COMM")
    private BigDecimal comm;
    @JoinColumn(name = "DEPTNO", referencedColumnName = "DEPTNO")
    @ManyToOne
    private Dept deptno;

    public Emp(String ename, String job) {
        this.ename = ename;
        this.job = job;
    }

    public Emp() {
    }

    public Emp(Integer empno) {
        this.empno = empno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Short getMgr() {
        return mgr;
    }

    public void setMgr(Short mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public Dept getDeptno() {
        return deptno;
    }

    public void setDeptno(Dept deptno) {
        this.deptno = deptno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empno != null ? empno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emp)) {
            return false;
        }
        Emp other = (Emp) object;
        if ((this.empno == null && other.empno != null) || (this.empno != null && !this.empno.equals(other.empno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
