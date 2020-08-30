package com;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.BiConsumer;

public class Department {
    private Manager manager;
    private String deptNAme;
    private ArrayList<Staff> staff;

    public BiConsumer<Staff, Double> appointmentHandler = (worker, workerSalary) ->{
        worker.setWorkAt(deptNAme);
        worker.setHiredAt(LocalDate.now());
        worker.setSalary(workerSalary);
        staff.add(worker);
    };

    public final void setManager(Manager manager) {
        if(manager==null){
            throw  new InvalidParameterException("manager was null");
        }
        this.manager=manager;
    }

    public final void setDeptNAme(String deptNAme) {
        if(deptNAme==null){
            throw  new InvalidParameterException("deptNAme was null");
        }
        this.deptNAme=deptNAme;
    }

    public final ArrayList<Staff> getStaff() {
        return staff;
    }

    public Department(Manager manager, String deptNAme) {
        setManager(manager);
        setDeptNAme(deptNAme);
        staff=new ArrayList<>();




    }

    @Override
    public String toString() {
        return String.format("Manager: %s, DeptName: %s, Staff: %s",manager,deptNAme,getStaff());
    }
}
