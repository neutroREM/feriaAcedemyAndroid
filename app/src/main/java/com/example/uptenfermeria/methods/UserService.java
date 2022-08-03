package com.example.uptenfermeria.methods;

import com.example.uptenfermeria.models.Message;
import com.example.uptenfermeria.models.User;


import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

     @FormUrlEncoded
     @POST("api/user/register")
     Call<User> createUser(@Field("name") String name,
                           @Field("secondName") String secondName,
                           @Field("email") String email,
                           @Field("password") String password);

     @FormUrlEncoded
     @POST("api/user/login")
     Call<User> loginUser(@Field("email") String email,
                          @Field("password") String password);

     @FormUrlEncoded
     @POST("api/user/message")
     Call<User.messages> sendMessage(@Field("title") String title,
                               @Field("message") String message);

}
