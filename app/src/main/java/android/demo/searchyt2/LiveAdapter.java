package android.demo.searchyt2;

import android.content.Context;
import android.content.Intent;
import android.demo.searchyt2.models.items;
import android.demo.searchyt2.models.thumbnails;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder> {
    private Context context;
    private List<items> itemsList;


    public LiveAdapter(Context context, List<items> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public LiveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewlayout,parent,false);
  ViewHolder viewHolder = new ViewHolder(view);
  return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LiveAdapter.ViewHolder holder, int position) {
        items itempos =itemsList.get(position);
        thumbnails thumbnails = itempos.getSnippet().getThumbnails();
        Picasso.get().load(thumbnails.getMedium().getUrl()).into(holder.imgThumb);

        holder.txtTitle.setText(itempos.getSnippet().getTitle());

        holder.txtDesc.setText(itempos.getSnippet().getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Ytplayer.class);
                intent.putExtra("videoid",itempos.getId().getVideoId());
                intent.putExtra("title",itempos.getSnippet().getTitle());
                intent.putExtra("description",itempos.getSnippet().getDescription());
                intent.putExtra("thumbnailurl",itempos.getSnippet().getThumbnails().getMedium().getUrl());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgThumb;
        TextView txtTitle,txtDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgThumb = itemView.findViewById(R.id.videothumbnail);
            txtTitle = itemView.findViewById(R.id.titletextview);
            txtDesc = itemView.findViewById(R.id.desctextview);

        }
    }
}
