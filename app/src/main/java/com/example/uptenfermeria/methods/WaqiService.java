package com.example.uptenfermeria.methods;

import com.example.uptenfermeria.models.Waqi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WaqiService {

    @GET("feed/{place}/?token=8f4c696cfe2d72e362852e6eb87591a534156ff8")
    Call<Waqi> getClima(@Path("place")String place);

}
