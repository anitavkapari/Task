package com.example.dell.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.dell.task.adapter.UserAdapter;
import com.example.dell.task.model.Users;
import com.example.dell.task.rest.ApiClient;
import com.example.dell.task.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvusers;
    ProgressBar progress;
    List<Users> users;
    ApiInterface api; //declare
     UserAdapter userAdapter;
    //Constens
    public static final String DATA = "data";
    public static final int REQUEST_UPDATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvusers = findViewById(R.id.rvusers);
        progress = findViewById(R.id.progress);
        api = ApiClient.getClient().create(ApiInterface.class);
        fetchUser();
    }


    private void fetchUser() {
        Call<List<Users>> listCall = api.getUsers();
        progress.setVisibility(View.VISIBLE);

        listCall.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                users = response.body();
                progress.setVisibility(View.GONE);
                userAdapter = new UserAdapter(users, R.layout.users_list, MainActivity.this);
                rvusers.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                progress.setVisibility(View.GONE);

            }
        });
    }
}