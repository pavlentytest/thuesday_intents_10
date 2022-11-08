package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    private Button btn3;
    public static final String KEY2 = "key2";
    public static final int CODE2 = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String value = bundle.getString(MainActivity.KEY1);
            Snackbar.make(findViewById(R.id.root2),value,Snackbar.LENGTH_LONG).show();
        }
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(KEY2, "Data from MainActivity2!");
            setResult(CODE2, intent);
            finish(); // завершение работы Activity2
        });

    }
}