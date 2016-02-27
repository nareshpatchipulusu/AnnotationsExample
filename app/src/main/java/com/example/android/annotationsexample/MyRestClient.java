package com.example.android.annotationsexample;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.List;

/**
 * Created by android on 2/19/2016.
 */
@Rest(rootUrl = "http://10.0.0.15/PEPSIWCFSERVICE/AndroidService.svc",converters = {GsonHttpMessageConverter.class})
public interface MyRestClient {

    @Get("/GetEmployeeJSON")
    @Accept(MediaType.APPLICATION_JSON)
    List<Employee> getEmployees();

    @Get("/GetEmployeeJSON")
    @Accept(MediaType.APPLICATION_JSON)
    List<Employee> getOutEmployees();


}
