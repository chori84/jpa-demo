package com.chori.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dept")
@Access(AccessType.FIELD)
public class Dept {
    @Id
    @GeneratedValue
    private Long deptno;
    private String dname;
    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    private Set<Emp> emps = new HashSet<>();

    protected Dept() {}

    public Long getDeptno() {
        return deptno;
    }

    public String getDname() {
        return dname;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void addEmp(Emp emp) {
        emps.add(emp);
    }

    public void addEmps(Set<Emp> emps) {
        emps.addAll(emps);
    }

    public String toString() {
        String s = String.format("DEPT[deptno = %d, dname = '%s']%n", deptno, dname);
        if (emps != null) {
            for (Emp e : emps) {
                s += String.format("EMP[empno = %d, ename = '%s', deptno = '%s']%n",

                        e.getEmpno(), e.getEname(),
                        e.getDept() == null ? "" : e.getDept().deptno);
            }
        }

        return s;
    }
}
