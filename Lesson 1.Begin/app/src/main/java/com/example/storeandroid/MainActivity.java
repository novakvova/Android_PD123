package com.example.storeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    private EditText txtInfo;
    private ImageView ivMyImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInfo=findViewById(R.id.txtInfo);

        ivMyImage=findViewById(R.id.ivMyImage);
//        String url = "https://pipi.itstep.click/images/monika.jpg";
        String url = "http://10.0.2.2:5236/images/1.jpg";
        Glide
                .with(this)
                .load(url)
                .apply(new RequestOptions().override(600))
                .into(ivMyImage);
    }

    public void onClickHandler(View view) {
        String text = txtInfo.getText().toString();
        Log.d("my-tag","-----Нажали кнопку------"+ text);
    }
}