package com.emrehmrc.retrofitdenemesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult=findViewById(R.id.txtResult);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.kodhamuru.somee.com/webservices/Notification.asmx/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi=retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Member>> call=jsonPlaceHolderApi.getMembers();
        call.enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {

                List<Member> members=response.body();
                for(Member member:members){

                    String content="";
                    content+=member.getNAME()+"\n";
                    content+=member.getEMAIL()+"\n\n";
                    txtResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Member>> call, Throwable t) {
                txtResult.setText(t.getMessage());
            }
        });
    }
}
