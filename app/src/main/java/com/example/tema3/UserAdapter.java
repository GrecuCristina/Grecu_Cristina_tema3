package com.example.tema3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private String TAG=this.getClass().getSimpleName();
    private Context context;
    private ArrayList<User> UserList;
    //private final LayoutInflater layoutInflater;

    public UserAdapter(Fragment1Activity1 fragment1Activity1, ArrayList<User> userList) {
        this.context=context;
        this.UserList=UserList;

    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG,"Aicioncreate");
        View view= LayoutInflater.from(context).inflate(R.layout.user, parent, false);
        UserViewHolder viewHolder=new UserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User currentUser=UserList.get(position);

        int id=currentUser.getId();
        String name=currentUser.getName();
        String username=currentUser.getUsername();
        String email=currentUser.getEmail();

        holder.id.setText(id);
        holder.name.setText(name);
        holder.username.setText(username);
        holder.email.setText(email);


    }

    @Override
    public int getItemCount() {
        return UserList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        public TextView id;
        public TextView name;
        public TextView username;
        public TextView email;


        public UserViewHolder(@NonNull View UserView) {
            super(UserView);
            name=UserView.findViewById(R.id.id_id);
            name=UserView.findViewById(R.id.id_name);
            username=UserView.findViewById(R.id.id_username);
            email=UserView.findViewById(R.id.id_email);
        }
    }
}
