package com.example.victoria.students;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    Button buttonRequestMessage;
    TextView textViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRequestMessage = (Button)findViewById(R.id.buttonRequestMessage);
        buttonRequestMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestMessage();
            }
        });
    }

    private void requestMessage() {
        String url = "http://192.168.201.87:4000/api/hello-world";
        RequestQueue requestQueue;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        textViewMessage.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textViewMessage.setText("Error:" + error.toString());

                    }
                });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

}

