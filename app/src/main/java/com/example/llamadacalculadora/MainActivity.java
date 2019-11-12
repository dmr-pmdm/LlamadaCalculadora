package com.example.llamadacalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnCalc, btnAjustes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = findViewById(R.id.btnCalc);
        btnAjustes = findViewById(R.id.btnAjustes);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
                PackageManager pm = getPackageManager();
                List actividadesPosibles = pm.queryIntentActivities(i, PackageManager.MATCH_DEFAULT_ONLY);
                if (actividadesPosibles.size()>0) {
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Ninguna actividad puede realizar esta acción", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.android.settings", "com.android.settings.Settings");
                PackageManager pm = getPackageManager();
                List actividadesPosibles = pm.queryIntentActivities(i, PackageManager.MATCH_DEFAULT_ONLY);
                if (actividadesPosibles.size()>0) {
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Ninguna actividad puede realizar esta acción", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
