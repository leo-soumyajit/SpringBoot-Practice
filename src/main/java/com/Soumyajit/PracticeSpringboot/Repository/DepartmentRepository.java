package com.Soumyajit.PracticeSpringboot.Repository;

import com.Soumyajit.PracticeSpringboot.DepartmentDTO.DepartmentDTO;
import com.Soumyajit.PracticeSpringboot.DepartmentEntity.DepartmentEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntities, Long> {

}
