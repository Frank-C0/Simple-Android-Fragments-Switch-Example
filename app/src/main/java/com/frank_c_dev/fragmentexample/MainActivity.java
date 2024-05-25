package com.frank_c_dev.fragmentexample;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = null;
    FragmentTransaction fragmentTransaction = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // get buttons
        Button redButton = findViewById(R.id.redButton);
        Button orangeButton = findViewById(R.id.orangeButton);

        fragmentManager = getSupportFragmentManager();



        redButton.setOnClickListener(v -> {
            fragmentTransaction = fragmentManager.beginTransaction();
            RedFragment redFragment = RedFragment.newInstance();
            fragmentTransaction.replace(R.id.fragmentContainer, redFragment).commit();
        });

        orangeButton.setOnClickListener(v -> {
            fragmentTransaction = fragmentManager.beginTransaction();
            OrangeFragment orangeFragment = OrangeFragment.newInstance();
            fragmentTransaction.replace(R.id.fragmentContainer, orangeFragment).commit();
        });


    }
}