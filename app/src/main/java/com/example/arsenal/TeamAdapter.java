package com.example.arsenal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private Context context;
    private List<Team> teamList;

    public TeamAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.teamName.setText(team.getStrTeam());
        holder.stadiumName.setText(team.getStrStadium());

        // Load image using Glide
        Glide.with(context)
                .load(team.getStrTeamBadge())
                .into(holder.teamBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView teamName, stadiumName;
        ImageView teamBadge;


        public TeamViewHolder(View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.teamName);
            stadiumName = itemView.findViewById(R.id.stadiumName);
            teamBadge = itemView.findViewById(R.id.teamBadge);
        }
    }
}

