package com.example.controller;

import com.example.model.StorageDTO;
import com.example.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Api(tags = "Product Management")
public class StorageController {

    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @ApiOperation(value = "Add a new product")
    @PostMapping("/add")
    public void addProduct(@RequestBody StorageDTO storageDTO) {
        storageService.addProduct(storageDTO);
    }

    @ApiOperation(value = "Search products by category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved products"),
            @ApiResponse(code = 404, message = "No products found for the specified category")
    })
    @GetMapping("/get")
    public List<StorageDTO> getProductsByCategory(@RequestParam String category) {
        return storageService.getProductsByCategory(category);
    }
}
