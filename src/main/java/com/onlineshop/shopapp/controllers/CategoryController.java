package com.onlineshop.shopapp.controllers;

import com.onlineshop.shopapp.dto.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
//@Validated
public class CategoryController {
    @GetMapping("") //http://localhost:8080/api/v1/categories?page=1&limit=10
    public ResponseEntity<String> getCategoryAll(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        return ResponseEntity.ok(String.format("All Categories, page = %d, limit = %d", page, limit));
    }

    @PostMapping("")
    //neu tham so truyen vao la 1 object thi sao? => Data Transfer Objecy = Request Object
    public ResponseEntity<?> addCategory(@Valid @ModelAttribute CategoryDTO categoryDTO, BindingResult result) {
        if(result.hasErrors()){

          List<String> errorMessage = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
          return ResponseEntity.badRequest().body(errorMessage);
        }
        return ResponseEntity.ok("insert Categories" + categoryDTO.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id) {
        return ResponseEntity.ok("update Categories with id " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok("delete Categories");
    }
}
