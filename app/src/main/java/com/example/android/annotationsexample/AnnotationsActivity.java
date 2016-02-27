package com.example.android.annotationsexample;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by android on 2/18/2016.
 */
@EActivity(R.layout.activity_annotations)
public class AnnotationsActivity extends AppCompatActivity {


    @ViewById
    TextView textView;

    @StringRes
    String hello;

    @Click(R.id.textView)
    void  handleTextViewClick(){
        Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show();
    }


    @AfterViews
    void displayText(){

       new MyBackgroundTask().execute();


    }

    private class MyBackgroundTask extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... params) {


            try
            {
               // List<Employee> employeeList=myRestClient.getEmployees();

               // return employeeList.toString();

                //final String url = "http://10.0.0.15/PEPSIWCFSERVICE/AndroidService.svc/GetEmployeeJSON";
                final String url = "http://10.0.0.4/PEPSIWCFSERVICE/AndroidService.svc/SaveEmployee/new";
                RestTemplate restTemplate = new RestTemplate();

                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                //String employeeList = restTemplate.getForObject(url, String.class);
                Employee employee=new Employee(1,"Test","abc","123","test");

                String result=restTemplate.postForObject( url, employee, String.class);

                return result.toString();

            }catch (Exception ex){
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {

            textView.setText(aVoid);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Life Cycle : ", "onCreate");
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Life Cycle : ","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Life Cycle : ", "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Life Cycle : ", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Life Cycle : ", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Life Cycle : ", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("Life Cycle : ", "onRestart");
    }

}
