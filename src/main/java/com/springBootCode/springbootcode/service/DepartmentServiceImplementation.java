package com.springBootCode.springbootcode.service;

import com.springBootCode.springbootcode.entity.Department;
import com.springBootCode.springbootcode.error.DepartmentNotFoundException;
import com.springBootCode.springbootcode.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService{

    @Autowired
    public DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchingDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);
        if(!department.isPresent())
            throw new DepartmentNotFoundException("Department Not Found");
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDatabase = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentDatabase.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDatabase.setDepartmentAddress(department.getDepartmentAddress());
        }


        if(Objects.nonNull(department.getDepartmentEmployeeCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentEmployeeCode())){
            departmentDatabase.setDepartmentEmployeeCode(department.getDepartmentEmployeeCode());
        }

        return departmentRepository.save(departmentDatabase);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
