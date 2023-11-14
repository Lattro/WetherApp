package com.example.wetherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import org.json.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label welcome;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=54.83333000&lon=27.91667000&appid=b81fb9e1e634c5b4d4b838db4b2a6c4d");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String str= bufferedReader.readLine();
        
        String main, cityName ;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        double tempC = 0;
        welcomeText.setText(str);
        JSONObject jsonObject = new JSONObject(str);
        main = jsonObject.get("main").toString();
        JSONObject jsonObject1 = new JSONObject(main);
        tempC = (Double.valueOf(jsonObject1.get("temp").toString())/33.8);
        welcomeText.setText( decimalFormat.format(tempC)+" Celsius");
        JSONObject jsonObjectCity = new JSONObject(str);
        cityName = jsonObjectCity.getString("name").toString();
        welcome.setText("Temperature in "+cityName+" is:");
    }
}