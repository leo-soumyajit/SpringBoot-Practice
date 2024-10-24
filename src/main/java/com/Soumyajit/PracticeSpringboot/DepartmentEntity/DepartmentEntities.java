package com.Soumyajit.PracticeSpringboot.DepartmentEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntities {
    private Long id;
    private String title;
    @JsonProperty("isActive")
    private boolean isActive;
}
