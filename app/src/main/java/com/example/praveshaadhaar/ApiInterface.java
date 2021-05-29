package com.example.praveshaadhaar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("/rating")
    Call<List<RatingModel>> getratingJson();

    @POST("/rating")
    Call<String> sendRating(@Body AddRating addRating,@Header("Content-type") String header);
}
