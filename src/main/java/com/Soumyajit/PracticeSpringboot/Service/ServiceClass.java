package com.Soumyajit.PracticeSpringboot.Service;


import com.Soumyajit.PracticeSpringboot.DepartmentDTO.DepartmentDTO;
import com.Soumyajit.PracticeSpringboot.DepartmentEntity.DepartmentEntities;
import com.Soumyajit.PracticeSpringboot.Exceptions.ResourceNotFound;
import com.Soumyajit.PracticeSpringboot.Repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public DepartmentDTO createDepartment(DepartmentDTO inputId) {
        DepartmentEntities departmentEntities = mp.map(inputId , DepartmentEntities.class);
        DepartmentEntities entities = repository.save(departmentEntities);
        return mp.map(entities , DepartmentDTO.class);
    }

    public List<DepartmentDTO> Getall() {
        List<DepartmentEntities> entities = repository.findAll();
        return entities
                .stream()
                .map(e ->mp.map(e, DepartmentDTO.class)).collect(Collectors.toList());
    }


    public String deleteById(Long departmentId) {
        boolean isExist = repository.existsById(departmentId);
        if(!isExist){
            return "Resource not found";
        }
        repository.deleteById(departmentId);
        return "Deleted Success"+departmentId;
    }


    public DepartmentDTO update(Long departmentId, DepartmentDTO departmentDTO) {
        DepartmentEntities departmentEntities = mp.map(departmentDTO , DepartmentEntities.class);
            if(!isExist(departmentId)){
                throw new ResourceNotFound("resource not found");
            }
        departmentEntities.setId(departmentId);
        DepartmentEntities update = repository.save(departmentEntities);
        return mp.map(update , DepartmentDTO.class);

    }


    private boolean isExist(Long departmentId){
        return repository.existsById(departmentId);
    }
}
