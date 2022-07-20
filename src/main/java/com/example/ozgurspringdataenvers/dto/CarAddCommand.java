package com.example.ozgurspringdataenvers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarAddCommand {
    @NotNull
    private String brandName;
    @NotNull
    private String modelName;
}
