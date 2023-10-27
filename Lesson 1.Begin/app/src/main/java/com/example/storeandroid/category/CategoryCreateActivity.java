package com.example.storeandroid.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.storeandroid.MainActivity;
import com.example.storeandroid.R;
import com.example.storeandroid.dto.category.CategoryCreateDTO;
import com.example.storeandroid.dto.category.CategoryItemDTO;
import com.example.storeandroid.service.ApplicationNetwork;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryCreateActivity extends AppCompatActivity {

    TextInputLayout tlCategoryName;
    TextInputLayout tlCategoryImage;
    TextInputLayout tlCategoryDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_create);

        tlCategoryName = findViewById(R.id.tlCategoryName);
        tlCategoryImage = findViewById(R.id.tlCategoryImage);
        tlCategoryDescription = findViewById(R.id.tlCategoryDescription);
    }

    public void onClickCreateCategory(View view) {
        String name = tlCategoryName.getEditText().getText().toString().trim();
        String image = tlCategoryImage.getEditText().getText().toString().trim();
        String description = tlCategoryDescription.getEditText().getText().toString().trim();

//        Log.d("salo", "---Name---"+name);
//        Log.d("salo", "---Image---"+image);
//        Log.d("salo", "---Description---"+description);
        CategoryCreateDTO dto = new CategoryCreateDTO();
        dto.setName(name);
        dto.setImage(image);
        dto.setDescription(description);
        ApplicationNetwork.getInstance()
                .getCategoriesApi()
                .create(dto)
                .enqueue(new Callback<CategoryItemDTO>() {
                    @Override
                    public void onResponse(Call<CategoryItemDTO> call, Response<CategoryItemDTO> response) {
                        if(response.isSuccessful()) {
                            Intent intent = new Intent(CategoryCreateActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<CategoryItemDTO> call, Throwable t) {

                    }
                });

    }

}