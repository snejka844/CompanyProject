package com;

import java.time.LocalDate;

public class Staff extends Employee {
    private String workAt;
    private LocalDate hiredAt;

    public Staff(String name, double salary, String workAt, LocalDate hiredAt) {
        super(name, salary);
        setWorkAt(workAt);
        setHiredAt(hiredAt);
    }

    public final String getWorkAt() {
        return workAt;
    }

    public final void setWorkAt(String workAt) {
        this.workAt=workAt==null?"Candidate":workAt;
    }

    public final LocalDate getHiredAt() {
        return hiredAt;
    }

    public final void setHiredAt(LocalDate hiredAt) {
        this.hiredAt = hiredAt==null? LocalDate.now():hiredAt;
    }

    @Override
    public String toString() {
        return String.format("%s, Work At: %s, Hired At: %s", super.toString(),getWorkAt(),getHiredAt());
    }
}
