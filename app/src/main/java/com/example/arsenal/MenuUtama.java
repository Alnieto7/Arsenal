package com.example.arsenal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuUtama extends AppCompatActivity {

    Button btnPremier;
    Button btnLaliga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_utama);
        btnPremier = (Button) findViewById(R.id.btnPremier);
        btnLaliga = (Button) findViewById(R.id.btnLaliga);

        btnPremier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, MainActivity.class);
                intent.putExtra("LEAGUE", "EPL");
                startActivity(intent);
            }
        });
    btnLaliga.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MenuUtama.this, MainActivity.class);
            intent.putExtra("LEAGUE", "LALIGA");
            startActivity(intent);

    }
});

    }
}