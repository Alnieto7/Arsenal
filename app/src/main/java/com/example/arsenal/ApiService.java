package com.example.arsenal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getTeams();

    @GET("search_all_teams.php?l=Spanish%20La%20Liga")
    Call<TeamResponse> getLaliga();
}



