package com.emrehmrc.retrofitdenemesi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("GetMember")
    Call<List<Member>> getMembers();
}
