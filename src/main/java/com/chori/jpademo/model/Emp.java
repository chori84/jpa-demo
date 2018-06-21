package com.chori.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "emp")
@Access(AccessType.FIELD)
public class Emp {
    @Id
    @GeneratedValue
    private Long empno;
    private String ename;
    @ManyToOne
    @JoinColumn(name = "deptno")
    private Dept dept;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addr_id")
    private Addr addr;

    protected Emp() {}

    public Long getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Addr getAddr() {
        return addr;
    }

    public void setAddr(Addr addr) {
        this.addr = addr;
    }

    public String toString() {
        String s = String.format("EMP[empno = %d, ename = '%s', deptno=%d, addr=%s]%n",
                empno, ename, dept == null ? 0 : dept.getDeptno(), addr == null ? "" : addr.getAddress());
        return s;
    }
}
