package com.example.biblio_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);

        pb.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { new Task().execute();//Ejecuto mi tarea asincrona
            }
        });

    }


    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... strings) {
            for(int i = 1; 1 <=10; i++)
            {
                try{
                    Thread.sleep(1000);
                    return null;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(),home_act.class);
            startActivity(i);
        }


    }


}