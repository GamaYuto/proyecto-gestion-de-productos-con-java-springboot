package com.example.gestionproductos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    @NotBlank(message = "The name is mandatory")
    private String name;

    private String description;

    @Positive(message = "The price must be positive")
    private Double price;

    @Min(value = 0, message = "The stock cannot be negative")
    private Integer stock;

    @NotBlank(message = "The category is mandatory")
    private String category;

    private LocalDateTime createdAt;
}
