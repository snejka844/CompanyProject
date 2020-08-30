package com;

import java.security.InvalidParameterException;
import java.util.function.BiConsumer;

public class Manager extends Employee {
    private BiConsumer<Staff, Double> appointRule;

    public Manager(String name, double salary, BiConsumer<Staff, Double> appointRule) {
        super(name, salary);
        setAppointRule(appointRule);
    }


    public final void  setAppointRule(BiConsumer<Staff, Double> appointRule) {
        this.appointRule = appointRule;
    }

    public void appointStaffAppointment(Staff member, Double newStaffMemberSalary) {
        appointRule.accept(member, newStaffMemberSalary);
    }

    @Override
    public String toString() {
        return String.format("%s,%s",super.toString(),appointRule);
    }
}
