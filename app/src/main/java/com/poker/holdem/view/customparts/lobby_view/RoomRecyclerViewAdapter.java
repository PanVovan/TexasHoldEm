package com.poker.holdem.view.customparts.lobby_view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.poker.holdem.R;
import com.poker.holdem.server.deserialization.getlobbies.RespRoom;
import com.poker.holdem.view.activity.GameActivity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoomRecyclerViewAdapter extends RecyclerView.Adapter<RoomRecyclerViewAdapter.ViewHolder> {

    SharedPreferences prefs;

    private ArrayList<RespRoom> rooms;
    private Context context;

    public RoomRecyclerViewAdapter(ArrayList<RespRoom> rooms, Context context) {
        this.context = context;
        this.rooms = rooms;
    }

    public void setRooms(ArrayList<RespRoom> rooms) {
        this.rooms = rooms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lobby_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RespRoom room = rooms.get(position);
        holder.playersActive.setText(String.format(Locale.ENGLISH, "%d", room.getLength()));
        holder.minRate.setText(String.format(Locale.ENGLISH, "%d", room.getRate()));
        holder.lobbyName.setText(room.getName());

    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.players_active) TextView playersActive;
        @BindView(R.id.min_rate) TextView minRate;
        @BindView(R.id.lobby_name) TextView lobbyName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick
        public void onClick() {
            if(Integer.parseInt(playersActive.getText().toString().trim()) < 5) {
                context.startActivity(
                        new Intent(
                                context
                                , GameActivity.class
                        ).putExtra(
                                "room"
                                , lobbyName.getText().toString()
                        )
                );
            }else {
                Toast.makeText(context, "The lobby is full!", Toast.LENGTH_SHORT).show();
                Logger.getAnonymousLogger().info("<--Player attempts to enter a full lobby.");
            }
        }

    }
}
