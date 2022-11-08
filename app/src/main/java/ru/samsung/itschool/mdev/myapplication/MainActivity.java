package ru.samsung.itschool.mdev.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn, btn2;
    public static final String KEY1 = "key1";

    private ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if(result.getResultCode() == MainActivity2.CODE2) {
                            Toast.makeText(getApplicationContext(),
                                    result.getData().getStringExtra(MainActivity2.KEY2),
                                    Toast.LENGTH_LONG).show();
                        }
                    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button) {
            // неявное намерение
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String url = "https://mirea.ru";
            intent.setData(Uri.parse(url));
            startActivity(intent);

        } else {
            // явное намерение
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra(KEY1,"Hello from MainActivity!");
           // startActivity(intent);
            activityResultLauncher.launch(intent);
        }

    }


}