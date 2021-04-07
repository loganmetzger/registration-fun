package com.logan.registration2.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.logan.registration2.R;
import com.logan.registration2.ui.main.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List<User> mUserList;

    public UserAdapter(ArrayList<User> users) {
        mUserList = users;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        User user = getItem(position);

        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        holder.username.setText(user.getUsername());
        holder.password.setText(user.getPassword());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public User getItem(int position) {
        return mUserList.get(position);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView email;
        private TextView username;
        private TextView password;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_item_name);
            email = itemView.findViewById(R.id.user_item_email);
            username = itemView.findViewById(R.id.user_item_username);
            password = itemView.findViewById(R.id.user_item_password);
        }
    }
}
