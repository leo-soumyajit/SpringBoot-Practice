package com.Soumyajit.PracticeSpringboot.Controller;


import com.Soumyajit.PracticeSpringboot.DepartmentDTO.DepartmentDTO;
import com.Soumyajit.PracticeSpringboot.Service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Component
@RequestMapping(path = "/department")
public class ControllerClass {

    @Autowired
    ServiceClass service;



    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getByid(@PathVariable Long departmentId){
         Optional<DepartmentDTO> departmentDTO = service.getById(departmentId);
         return departmentDTO.map(dto->ResponseEntity.ok(dto))
                 .orElse(ResponseEntity.notFound()
                         .build());
    }

}
