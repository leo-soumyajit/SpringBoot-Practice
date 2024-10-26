package com.Soumyajit.PracticeSpringboot.Advices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
}
