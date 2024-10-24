package com.Soumyajit.PracticeSpringboot.DepartmentDTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;
    private String title;
    @JsonProperty("isActive")
    private boolean isActive;

}
