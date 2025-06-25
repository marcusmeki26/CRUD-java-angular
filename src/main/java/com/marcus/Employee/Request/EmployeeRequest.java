package com.marcus.Employee.Request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class EmployeeRequest{
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Phone Number is required")
    @Pattern.List({
            @Pattern(regexp = "^\\d+$", message = "Should only be a number"),
            @Pattern(regexp = "^09[0-9]{9}$", message = "Should be 11 numbers & starts with 09")
    })
    private String phoneNumber;
    @Min(value = 25000, message = "25000 is the minimum value")
    private Integer salary;
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^([a-zA-Z0-9])+@(gmail|email|icloud)\\.com$", message = "only gmail, email, or icloud SLD is required")
    private String email;
    private Integer department;
    private Integer manager;
    private Integer address;
}
