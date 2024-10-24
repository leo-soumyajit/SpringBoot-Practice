package com.Soumyajit.PracticeSpringboot.Service;


import com.Soumyajit.PracticeSpringboot.DepartmentDTO.DepartmentDTO;
import com.Soumyajit.PracticeSpringboot.DepartmentEntity.DepartmentEntities;
import com.Soumyajit.PracticeSpringboot.Repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceClass {
    @Autowired
    private ModelMapper mp;

    @Autowired
    private DepartmentRepository repository;


    public Optional<DepartmentDTO> getById(Long departmentId) {
        Optional<DepartmentEntities> entities = repository.findById(departmentId);
        return entities.map(eme ->mp.map(eme , DepartmentDTO.class));
    }
}
