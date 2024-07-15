package com.onlineshop.shopapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CategoryDTO {
    @NotEmpty(message = "Category's name cannot be empty ")
    String name;
}
