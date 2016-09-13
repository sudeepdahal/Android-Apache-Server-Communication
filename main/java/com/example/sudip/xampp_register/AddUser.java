package com.example.sudip.xampp_register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddUser extends AppCompatActivity {
    Button btn;
    EditText ed1, ed2, ed3, ed4, ed5;
    String n1, n2, n3, n4, n5;
    String url="http://192.168.52.1:8081/student/insert.php";
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        queue= Volley.newRequestQueue(this);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        ed4 = (EditText) findViewById(R.id.ed4);
        ed5 = (EditText) findViewById(R.id.ed5);

        //db=new Database(AddAccount.this);
        //  ed2 = (EditText) findViewById(R.id.ed2);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=ed1.getText().toString();
                n2=ed2.getText().toString();
                n3=ed3.getText().toString();
                n4=ed4.getText().toString();
                n5=ed5.getText().toString();

                if(n1.length()>0 && n2.length()>0 && n3.length()>0 && n4.length()>0 && n5.length()>0)
                {
                    Toast.makeText(AddUser.this,"True",Toast.LENGTH_SHORT).show();
                    funAdduser();


                }
                else
                {
                    Toast.makeText(AddUser.this,"Empty Field not allowed!",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }



    public void funAdduser()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null)
                {
                    Toast.makeText(AddUser.this,"Added Sucessfully!",Toast.LENGTH_SHORT).show();
                    finish();
                    Log.d("Response",response+"a---check null---");
                }


            }}, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("name",n1);
                params.put("faculty",n2);
                params.put("address",n3);
                params.put("email",n4);
                params.put("phone",n5);
                // params.put("faculty",n2);
                return params;

            }
        };
        queue.add(stringRequest);
    }


}
