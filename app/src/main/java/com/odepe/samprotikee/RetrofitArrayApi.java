package com.odepe.samprotikee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitArrayApi {

    @GET("wp-json/wp/v2/posts?per_page=20")
    Call<List<WPImage>> getPostInfo();
    /// to make call to dynamic URL
    @GET("wp-json/wp/v2/posts?categories=7&per_page=20")
     Call<List<WPImage>> getPostInfotab2();
    @GET("wp-json/wp/v2/posts?categories=2&per_page=20")
    Call<List<WPImage>> getPostInfotab3();
    @GET("wp-json/wp/v2/posts?categories=14&per_page=20")
    Call<List<WPImage>> gallery();
    //

}
