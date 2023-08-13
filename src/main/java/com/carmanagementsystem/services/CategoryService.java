package com.carmanagementsystem.services;

import com.carmanagementsystem.dtos.CategoryDto;
import com.carmanagementsystem.dtos.PageableResponse;

public interface CategoryService {
    //create
    CategoryDto createcategory(CategoryDto categoryDto);

    //update
    CategoryDto updatecategory(CategoryDto categoryDto, String categoryId);

    //delete
    void deleteCategory(String categoryId);

    //get all
    PageableResponse<CategoryDto> getAllCategory(int pageNumber, int pageSize, String sortBy, String sortDir);

    //get single category
    CategoryDto getCategoryById(String categoryId);
}
