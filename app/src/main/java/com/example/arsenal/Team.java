package com.example.arsenal;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("idTeam")
    private String idTeam;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("strBadge")
    private String strTeamBadge;

    public String getIdTeam() {
        return idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }
}
