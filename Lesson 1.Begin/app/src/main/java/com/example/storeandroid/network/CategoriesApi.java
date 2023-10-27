package com.example.storeandroid.network;

import com.example.storeandroid.dto.category.CategoryCreateDTO;
import com.example.storeandroid.dto.category.CategoryItemDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CategoriesApi {
    @GET("/api/categories/list")
    public Call<List<CategoryItemDTO>> list();
    @POST("/api/categories/create")
    public Call<CategoryItemDTO> create(@Body CategoryCreateDTO model);
}
