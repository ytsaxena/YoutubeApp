package android.demo.searchyt2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.demo.searchyt2.models.LiveResponseModel;
import android.demo.searchyt2.models.items;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
 EditText searchtxt;
 ImageButton searchbtn;
 LiveAdapter adapter;
 Context context;
    String search = "news";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        searchbtn = findViewById(R.id.searchbtn);
        searchtxt = findViewById(R.id.searchtxt);


        LiveResponseModel liveResponseModel = new LiveResponseModel();


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               search = searchtxt.getText().toString().trim();
                getyoutubedata(search);
            }
        });

        getyoutubedata(search);
    }

    private void getyoutubedata(String search) {

      /*  ApiInterface apiService = ApiInstance.getRetrofit().create(ApiInterface.class);
        Call<LiveResponseModel> call = apiService.getyoutubelivedata(search);*/

        ApiInstance.getRetrofit().getyoutubelivedata(search).enqueue(new Callback<LiveResponseModel>() {

            @Override
            public void onResponse(Call<LiveResponseModel> call, Response<LiveResponseModel> response) {
                   if(response.isSuccessful())
                   {
                        LiveResponseModel liveResponseModel = response.body();

                        if(liveResponseModel!=null)
                        {
                            List<items> itemsList  = liveResponseModel.getItems();


//                            ArrayList<items> itemsArrayList = new ArrayList<items>(itemsList);
//
//                            Intent i = new Intent();
//                            i.putExtra("list",(Serializable) itemsArrayList);


                            if(itemsList != null && itemsList.size()>0)
                            {
                                adapter = new LiveAdapter(MainActivity.this,itemsList);
                                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
                                recyclerView.setAdapter(adapter);

                            }



                        }
                   }
            }

            @Override
            public void onFailure(Call<LiveResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });


    }
}