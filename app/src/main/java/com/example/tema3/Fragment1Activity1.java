package com.example.tema3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Fragment1Activity1 extends Fragment implements UserAdapter.OnItemClickListener {

    private String TAG = this.getClass().getSimpleName();
    private RecyclerView recyclerView;

    private UserAdapter userAdapter;
    private ArrayList<User> userList;
    private RequestQueue requestQueue;

    //
    public static final String EXTRA_NAME="NAME";
    public static final  String EXTRA_USERNAME="USERNAME";
    public static final String EXTRA_EMAIL="EMAIL";

    public Fragment1Activity1() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_activity1, container, false);
        Log.i(TAG, "Aici");

        // recyclerView=findViewById(R.id.recycler_view);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        Log.i(TAG, "Aicirecycleridentify");
        //UserAdapter = new UserAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.i(TAG, "Aici1");
        userList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(getContext());
        Log.i(TAG, "Aiciparse2");
        parseJSON();
        //extractUsers();


        //Pentru itemClick


        return view;
    }


        private void parseJSON(){
            Log.i(TAG,"AiciparseJSON");
            String url="https://my-json-server.typicode.com/GrecuCristina/GrecuCristina/db";
            Log.i(TAG,"Aiciafterurl");
            JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {


                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.i(TAG,"Aicibeforeresponse");
                                JSONArray jsonArray=response.getJSONArray("user");
                                Log.i(TAG,"Aicitrubeforefor");
                                for(int i=0;i<jsonArray.length();i++)
                                { Log.i(TAG,"Aiciainfor");
                                    JSONObject user=jsonArray.getJSONObject(i);
                                    int id=user.getInt("id");
                                    String name=user.getString("name");
                                    String username=user.getString("username");
                                    String email=user.getString("email");

                                    Log.i(TAG,"Aiciafteradd");
                                    userList.add(new User(id,name,username,email));
                                }

                                userAdapter=new UserAdapter(Fragment1Activity1.this,userList);
                                recyclerView.setAdapter(userAdapter);


                                userAdapter.setOnItemClickListener(Fragment1Activity1.this);
                                // Log.i(TAG,"Aicicatch");

                            } catch (JSONException e) {
                                Log.i(TAG,"Aicicatch");
                                e.printStackTrace();
                            }
                        }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            requestQueue.add(request);
        }

    @Override
    public void onItemClick(int position) {
        Log.i(TAG,"AiciONItemClick");




        Log.i(TAG,"AicidetailIntent");
        User clickedUser=userList.get(position);

        Log.i(TAG,"AiciAfterclickedUser ");
        Intent detailIntent=new Intent(getContext(),Activity2.class);
        Log.i(TAG,"AiciAfterclickedUser2 "+detailIntent);
        detailIntent.putExtra(EXTRA_NAME,clickedUser.getName());
        detailIntent.putExtra(EXTRA_USERNAME,clickedUser.getUsername());
        detailIntent.putExtra(EXTRA_EMAIL,clickedUser.getEmail());
        startActivity(detailIntent);


        ///partea pt fragment
        /*
        Bundle bundle=new Bundle();
        bundle.putString("name",clickedUser.getName());
        Log.i(TAG,"AiciAfterName "+clickedUser.getName());
        bundle.putString("username",clickedUser.getUsername());
        bundle.putString("email",clickedUser.getEmail());

        Fragment2Activity1 fragment2Activity1=new Fragment2Activity1();
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();

        fragment2Activity1.setArguments(bundle);
        Log.i(TAG,"AiciAfterclickedUsersetArguments ");

        fragmentTransaction.add(R.id.fragment2Activity1Id,fragment2Activity1);

        fragmentTransaction.commit();
        Log.i(TAG,"AiciAfterclickedUsersetArgumentsCommit ");

*/

    }


  /*  private void showUser(){
        Log.i(TAG,"AiciparseJSON");
        String url="https://my-json-server.typicode.com/GrecuCristina/GrecuCristina/db";
        Log.i(TAG,"Aiciafterurl");
        StringRequest request=new StringRequest(Request.Method.GET, url, null,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i(TAG,"Aicibeforeresponse");
                            JSONArray jsonArray=new JSONArray(response);
                            Log.i(TAG,"Aicitrubeforefor");
                            for(int i=0;i<jsonArray.length();i++)
                            { Log.i(TAG,"Aiciainfor");
                                JSONObject user=jsonArray.getJSONObject(i);
                                int id=user.getInt("id");
                                String name=user.getString("name");
                                String username=user.getString("username");
                                String email=user.getString("email");

                                Log.i(TAG,"Aiciafteradd");
                                userList.add(new User(id,name,username,email));
                            }

                            userAdapter=new UserAdapter(Fragment1Activity1.this,userList);
                            recyclerView.setAdapter(userAdapter);
                            // Log.i(TAG,"Aicicatch");

                        } catch (JSONException e) {
                            Log.i(TAG,"Aicicatch");
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);
    }

*/

}
