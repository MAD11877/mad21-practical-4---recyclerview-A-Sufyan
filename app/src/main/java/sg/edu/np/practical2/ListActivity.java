package sg.edu.np.practical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "ListActivity";
    private UserAdapter.RecyclerViewClickListener listener;
    ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for (int i = 0; i < 20; i++) {
            int nameRand = randomNum();
            String name = "Name " + String.valueOf(randomNum());
            String desc = "Description " + String.valueOf(randomNum());
            if (i % 2 == 0) {
                User user = new User(name, desc, i + 1, false, nameRand);
                userList.add(user);
            }
            else {
                User user = new User(name, desc, i + 1, true, nameRand);
                userList.add(user);
            }

        }
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        setOnClickListener();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        UserAdapter uAdapter = new UserAdapter(userList, listener);
        LinearLayoutManager uLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(uLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(uAdapter);
    }

    private void setOnClickListener() {
        listener = new UserAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                alertDialogBox(position);
            }
        };
    }

    public int randomNum(){
        Random num = new Random();
        int value = num.nextInt(10000000);
        return value;
    }


    private void alertDialogBox(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage(userList.get(position).getName());
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                finish();
            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name", userList.get(position).getName());
                intent.putExtra("desc", userList.get(position).getDescription());
                startActivity(intent);
            }
        });
        //builder.show();
        AlertDialog alert = builder.create();
        alert.show();
    }


}