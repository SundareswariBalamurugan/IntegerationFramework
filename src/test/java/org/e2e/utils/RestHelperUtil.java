package org.e2e.utils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.e2e.constant.QueryParamSetup;
import org.e2e.domains.DogDetails;
import org.e2e.enums.Excludeparams;
import org.e2e.modal.Minutely;
import org.e2e.modal.Root;
import org.e2e.modal.Weather;
import org.testng.Assert;

import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.e2e.steps.backEnd.WeatherForecastSteps.API_KEY;
import static org.testng.Assert.assertTrue;


@Slf4j
public class RestHelperUtil extends Restutil {





    public static void validateValueinList(List<DogDetails> dogDetailsAvailable, long id) {
        for (int i = 0; i < dogDetailsAvailable.size(); i++) {
            dogDetailsAvailable.get(i).getId();

            if (dogDetailsAvailable.get(i).getId() == id) {
                log.info("Value of dog detail id is" + dogDetailsAvailable.get(i).getId() + " compared with" + id);
                assertTrue(dogDetailsAvailable.get(i).getId() == id);
            }
        }
    }

    public static void validateValueinResponse(DogDetails dogDetailsAvailable, String name) {

        if (dogDetailsAvailable.getName() == name) {
            System.out.println("Value of dog detail id is" + dogDetailsAvailable.getName() + " compared with" + name);
            assertTrue(dogDetailsAvailable.getName() == name);
        }
    }

    public static String basicAuth(String userName, String password) {
        String key = userName + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(key.getBytes());
    }

    public static LocalDate getCurrentDate(){
        return LocalDate.now(Clock.systemDefaultZone());
    }

    public static Map<String,Object> getQueryparams(){

        Map<String,Object> queryParam = new HashMap<>();
        System.out.println(" lat and log are " + QueryParamSetup.getLatVal() +QueryParamSetup.getLongVal() );
        queryParam.put("lat", QueryParamSetup.getLatVal());
        queryParam.put("lon", QueryParamSetup.getLongVal());
        queryParam.put(("exclude"),excludeInQueryParam().stream().collect(Collectors.joining(",")));
        queryParam.put("appid",API_KEY);
        queryParam.forEach((k,v)->{

        });
        return queryParam;
    }

    public static List<String> excludeInQueryParam(){
        List<String> exclude = new ArrayList<>();
        exclude.add((Excludeparams.ALERTS).toString().toLowerCase());
        exclude.add((Excludeparams.DAILY).toString().toLowerCase());
        exclude.add((Excludeparams.HOURLY).toString().toLowerCase());
        //exclude.add((Excludeparams.MINUTELY).toString().toLowerCase());
        return exclude;
    }

    public static RequestSpecification Request(String baseUrl, Header header,Map<String,Object> queryParams){
         RequestSpecification request  = RestAssured.given().baseUri(baseUrl).header(header)
                .queryParams(queryParams);
         return request;
    }

    public static void validateValueinResponse(String expValue, String actValue) {
       if(actValue!=null){
           Assert.assertEquals(expValue,actValue);
       }else{
           Assert.fail(" Value from response is null");
       }
    }

    public static void validateValueinResponse(int expValue, int actValue) {
        if(actValue!=0){
            Assert.assertEquals(expValue,actValue);
        }else{
            Assert.fail(" Value from response is null");
        }
    }

    public int getSizeOfJsonArray(Root root, String jsonObjectName){

        try {
            int size = 0;
            if (jsonObjectName.equalsIgnoreCase("Weather")) {
                size = root.getCurrent().getWeather().size();
            } else if (jsonObjectName.equalsIgnoreCase("Minutely")) {
                size = root.getMinutely().size();
            }
            System.out.println("Size of " + jsonObjectName + " is " + size);
            return size;
        }catch (NullPointerException e){
            throw e;
        }

    }

    public void getAllRecordsOfJsonArray(Root root, String jsonObjectName){

        try {
            if (jsonObjectName.equalsIgnoreCase("Weather")){
            for (Weather weather: root.getCurrent().getWeather()
            ) {
                System.out.println(weather.getDescription());
            }
            } else if (jsonObjectName.equalsIgnoreCase("Minutely")) {
                for (Minutely minutely:root.getMinutely()
                ) {
                    System.out.println(minutely.getDt());
                }
            }

//            for(int i=0; i<root.getMinutely().size();i++){
//                System.out.println(" minutely in second for loop" + root.getMinutely().get(i).getDt());
//            }
        }catch (NullPointerException e){
            throw e;
        }

    }

    public Object getSpecificRecordOfJsonArray(Root root, int jsonObjectindex, String jsonObjectName){

        try {
            double value = 0;
            if (jsonObjectName.equalsIgnoreCase("Weather")) {
                value = root.getCurrent().getWeather().get(jsonObjectindex).getId();
                root.getCurrent().getWeather().get(jsonObjectindex).getDescription();
            } else if (jsonObjectName.equalsIgnoreCase("Minutely")) {
                value = root.getMinutely().get(jsonObjectindex).getDt();
            }
            System.out.println("Specific value of " + jsonObjectName + " is " + value);
            return value;
        }catch (NullPointerException e){
            throw e;
        }

    }



}
