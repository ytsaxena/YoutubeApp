package android.demo.searchyt2;

import android.demo.searchyt2.models.LiveResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

@GET("search?key=AIzaSyBnxWsDSRfXEf2ZOrnn_k9zS68o2j2TC9Y&eventType=live&part=snippet&maxResults=25&type=video&regionCode=IN")
Call<LiveResponseModel> getyoutubelivedata(@Query("q") String q);

}
