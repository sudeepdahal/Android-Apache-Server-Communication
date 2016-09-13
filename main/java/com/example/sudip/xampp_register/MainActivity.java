package com.example.sudip.xampp_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<StudentModel> studentList;
    StringRequest request;
    RequestQueue requestQueue;
    ListView listView;
    ProgressBar bar;
    AdapterClass adapter;
    static final String url="http://192.168.52.1:8081/student/students.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.mylv);


        studentList=new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);




        volleyget();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentModel studentModel=studentList.get(position);
//                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
//                intent.putExtra("name",student.getName());
//                intent.putExtra("address",student.getAddress());
//                intent.putExtra("faculty",student.getFaculty());
//                intent.putExtra("phone",student.getPhone());
//                intent.putExtra("email",student.getEmail());
//                startActivity(intent);
            }
        });








    }


    private void volleyget() {
        request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
                try {
                   // bar.setVisibility(View.GONE);
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("student_array");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject =array.getJSONObject(i);
                        StudentModel studentModel = new StudentModel();
                        studentModel.setName(jsonObject.getString("name"));
                        studentModel.setFaculty(jsonObject.getString("faculty"));
                        studentModel.setAddress(jsonObject.getString("address"));
                        studentModel.setEmail(jsonObject.getString("email"));
                        studentModel.setPhone(jsonObject.getInt("phone"));
                        studentList.add(studentModel);
                    }
                    adapter = new AdapterClass(MainActivity.this, R.layout.custom_layout,studentList);
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
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
    public boolean onCreateOptionsMenu(Menu menu) {
       // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if(id==R.id.exit){
            Toast.makeText(MainActivity.this,"Exiting",Toast.LENGTH_SHORT).show();
            System.exit(0);
        }
        if(id==R.id.add){
            Intent intent = new Intent(MainActivity.this,AddUser.class);
            startActivity(intent);
        }

        return true;
    }

}
