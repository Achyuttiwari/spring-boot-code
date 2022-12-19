package com.springBootCode.springbootcode.repository;

import com.springBootCode.springbootcode.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
            //Here in JpaRepository first was the entity and second PrimaryKey Type
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);

    Department findByDepartmentNameIgnoreCase(String departmentName);

}
