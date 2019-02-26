package com.example.dell.task.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.task.R;
import com.example.dell.task.model.Users;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsersViewHolder> {


    private List<Users> users;
    private int rowLayout;
    private Context context;

    public UserAdapter(List<Users> users, int rowLayout, Context context) {
        this.users = users;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    public class UsersViewHolder  extends RecyclerView.ViewHolder {
        TextView members,description,name;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            members =  itemView.findViewById(R.id.members);
            description =  itemView.findViewById(R.id.description);
            name =  itemView.findViewById(R.id.name);
        }
    }
    @NonNull
    @Override
    public UserAdapter.UsersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new UsersViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UsersViewHolder usersViewHolder, int i) {
        usersViewHolder.members.setText(users.get(i).getMembers());
        usersViewHolder.description.setText(users.get(i).getDescription());
        usersViewHolder.name.setText(users.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

