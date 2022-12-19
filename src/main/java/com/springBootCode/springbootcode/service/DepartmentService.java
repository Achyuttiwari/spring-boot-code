package com.springBootCode.springbootcode.service;

import com.springBootCode.springbootcode.entity.Department;
import com.springBootCode.springbootcode.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
     public Department saveDepartment(Department department);

     public List<Department> fetchDepartmentList();

     public Department fetchingDepartmentById(Long departmentId) throws DepartmentNotFoundException;

     public void deleteDepartmentById(Long departmentId);

     public Department updateDepartment(Long departmentId, Department department);

     public  Department fetchDepartmentByName(String departmentName);
}
