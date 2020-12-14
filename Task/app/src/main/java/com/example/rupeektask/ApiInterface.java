package com.example.rupeektask;
/**
 * Author : Shankar
 * github : https://github.com/shankarsimu/
 * Reach out for this project is available on github
 */


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/v2/5d3a99ed2f0000bac16ec13a")
    Call<DataJSON> getDataModel();
}
