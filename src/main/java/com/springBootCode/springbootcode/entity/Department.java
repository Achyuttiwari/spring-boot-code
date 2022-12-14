package com.springBootCode.springbootcode.entity;

public class Department {
    private long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentEmployeeCode;

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentEmployeeCode() {
        return departmentEmployeeCode;
    }

    public void setDepartmentEmployeeCode(String departmentEmployeeCode) {
        this.departmentEmployeeCode = departmentEmployeeCode;
    }
}
