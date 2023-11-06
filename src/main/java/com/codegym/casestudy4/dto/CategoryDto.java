package com.codegym.casestudy4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    @NotEmpty
    private long id;

    @NotEmpty
    private String name;

}
