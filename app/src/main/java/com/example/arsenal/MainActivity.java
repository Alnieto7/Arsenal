package com.example.arsenal;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TeamAdapter adapter;
    private ProgressBar pbLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        pbLoading = findViewById(R.id.pbLoading);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchTeams();
    }

    private void fetchTeams() {
        pbLoading.setVisibility(VISIBLE);
        recyclerView.setVisibility(GONE);

        String league = getIntent().getStringExtra("LEAGUE");

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<TeamResponse> call;

        if ("EPL".equals(league)) {
            call = apiService.getTeams(); // API untuk Premier League
        } else if ("LALIGA".equals(league)) {
            call = apiService.getLaliga(); // API untuk La Liga
        } else {
            Toast.makeText(this, "Liga tidak dikenali", Toast.LENGTH_SHORT).show();
            return;
        }

        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    recyclerView.setVisibility(VISIBLE);
                    pbLoading.setVisibility(GONE);
                    List<Team> teamList = response.body().getTeams();
                    adapter = new TeamAdapter(MainActivity.this, teamList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                pbLoading.setVisibility(GONE);
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("API_ERROR", t.getMessage());
            }
        });
    }
}
