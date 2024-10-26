package com.Soumyajit.PracticeSpringboot.Controller;


import com.Soumyajit.PracticeSpringboot.DepartmentDTO.DepartmentDTO;
import com.Soumyajit.PracticeSpringboot.Service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Component
@RequestMapping("/department")
public class ControllerClass {

   // @Autowired
    private final ServiceClass service;
    public ControllerClass(ServiceClass service) {
        this.service = service;
    }


    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getByid(@PathVariable Long departmentId){
         Optional<DepartmentDTO> departmentDTO = service.getById(departmentId);
         return departmentDTO.map(dto->ResponseEntity.ok(dto))
                 .orElse(ResponseEntity.notFound()
                         .build());
    }

    @GetMapping()
    public List<DepartmentDTO> getAll(){
        return service.Getall();
    }


    @PostMapping()
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO inputId){
        return service.createDepartment(inputId);
    }

    @DeleteMapping("/{departmentId}")
    public String deleteById(@PathVariable Long departmentId){
        return service.deleteById(departmentId);
    }

    @PutMapping("/{departmentId}")
    public DepartmentDTO update(@PathVariable Long departmentId , @RequestBody DepartmentDTO departmentDTO ) {
        return service.update(departmentId , departmentDTO);
    }

}
