package com.springBootCode.springbootcode.repository;

import com.springBootCode.springbootcode.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {    //Here in JpaRepository first was the entity and second PrimaryKey Type


}
