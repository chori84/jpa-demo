package com.chori.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Access(AccessType.FIELD)
public class Addr {
    @Id
    @GeneratedValue
    private Long id;
    private String address;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "addr")
    private Emp emp;

    protected  Addr() {}

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String toString() {
        return String.format(
                "Addr[id=%d, address='%s', ename='%s']",
                id, address, emp.getEname());
    }
}
