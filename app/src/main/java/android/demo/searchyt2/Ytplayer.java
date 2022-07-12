package android.demo.searchyt2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.demo.searchyt2.models.LiveResponseModel;
import android.demo.searchyt2.models.items;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;
import java.util.List;

public class Ytplayer extends YouTubeBaseActivity {

    RecyclerView recyclerView;
    TextView titlevp, descriptionvp;
    YouTubePlayerView youTubePlayerView;
    YouTubeThumbnailView youTubeThumbnailView;
    YouTubePlayer youTubePlayer;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    LiveAdapter adapter;
    LiveResponseModel liveResponseModel;

    ArrayList<items> itemList;

    String videoid = "";
    String title = "";
    String desc = "";
    String url = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ytplayer);

        youTubePlayerView = findViewById(R.id.videoplayer);
        titlevp = findViewById(R.id.titlevp);
        descriptionvp = findViewById(R.id.descriptionvp);
        recyclerView = findViewById(R.id.recyclerviewyt);

        LiveResponseModel liveResponseModel = new LiveResponseModel();


        Intent intent = getIntent();
        if (intent != null) {
            videoid = intent.getStringExtra("videoid");
            title = intent.getStringExtra("title");
            desc = intent.getStringExtra("description");
            url = intent.getStringExtra("thumbnailurl");
        }


        titlevp.setText(title);
        descriptionvp.setText(desc);


        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo(videoid);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(Ytplayer.this, "Failed to Load", Toast.LENGTH_SHORT).show();
            }
        };

        youTubePlayerView.initialize("AIzaSyBnxWsDSRfXEf2ZOrnn_k9zS68o2j2TC9Y", onInitializedListener);


        if (itemList != null && itemList.size() > 0) {
            adapter = new LiveAdapter(Ytplayer.this, itemList);
            recyclerView.setLayoutManager(new LinearLayoutManager(Ytplayer.this, LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(adapter);

        }

//        ArrayList<String> list = new ArrayList<>();
//        list.add("FAexs1jVJAQ");
//        list.add("FAexs1jVJAQ");
//        list.add("FAexs1jVJAQ");




        

    }

}