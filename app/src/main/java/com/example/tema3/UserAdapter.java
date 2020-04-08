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
    
    private OnItemClickListener myListener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        myListener=listener;
    }
    
    public UserAdapter(Fragment1Activity1 fragment1Activity1, ArrayList<User> userList) {
        this.context=fragment1Activity1.getContext();
        this.UserList=userList;

    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG,"Aicioncreate");
        View view= LayoutInflater.from(context).inflate(R.layout.user, parent, false);
        UserViewHolder viewHolder=new UserViewHolder(view);
        Log.i(TAG,"AicioncreateAdapterviewHolder");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Log.i(TAG,"AicionBindViewHolder1");
        User currentUser=UserList.get(position);
        Log.i(TAG,"AicionBindViewHolder2");
        int id=currentUser.getId();
        Log.i(TAG,"Aici id "+id);
        String name=currentUser.getName();
        String username=currentUser.getUsername();
        String email=currentUser.getEmail();
        Log.i(TAG,"AicionBindViewHolder3");

        holder.name.setText(name);
        Log.i(TAG,"AicionBindViewHolderName");
       
        holder.username.setText(username);
        Log.i(TAG,"AicionBindViewHolderUsername");
        holder.email.setText(email);
        Log.i(TAG,"AicionBindViewHolderEmail");
        Log.i(TAG,"AicionBindViewHolder");

        
        holder.id.setText(""+id);
        Log.i(TAG,"AicionBindViewHolderId");


    }

    @Override
    public int getItemCount() {
        return UserList.size();
    }

    public void clearList() {
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        public TextView id;
        public TextView name;
        public TextView username;
        public TextView email;


        public UserViewHolder(@NonNull View UserView) {
            super(UserView);
            id=UserView.findViewById(R.id.id_id);
            name=UserView.findViewById(R.id.id_name);
            username=UserView.findViewById(R.id.id_username);
            email=UserView.findViewById(R.id.id_email);
            
            //
           UserView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(myListener!=null){
                       int position=getAdapterPosition();
                       if(position!=RecyclerView.NO_POSITION){
                           myListener.onItemClick(position);
                       }
                   }
               }
           });
        }
    }
}
