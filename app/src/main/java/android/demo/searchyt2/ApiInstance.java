package android.demo.searchyt2;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiInstance {

    public static Retrofit retrofit;

    public static final String BASE_URL = "https://www.googleapis.com/youtube/v3/";

    public static ApiInterface getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        return apiInterface;


    }

}
