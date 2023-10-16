package com.example.storeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInfo=findViewById(R.id.txtInfo);
    }

    public void onClickHandler(View view) {
        String text = txtInfo.getText().toString();
        Log.d("my-tag","-----Нажали кнопку------"+ text);
    }
}