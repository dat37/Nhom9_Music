package vn.name.dat.nhom9_music.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.name.dat.nhom9_music.Activity.DanhsachbaihatActivity;
import vn.name.dat.nhom9_music.Model.PlaylistModel;
import vn.name.dat.nhom9_music.R;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<PlaylistModel> mangplaylist;
    View view;

    public PlaylistAdapter(Context context, ArrayList<PlaylistModel> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_playlist,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        PlaylistModel playlist = mangplaylist.get(position);
        holder.txttenplaylist.setText(playlist.getTen());
        Picasso.get().load(playlist.getHinhPlaylist()).into(holder.imgplaylist);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                intent.putExtra("intentplaylist", mangplaylist.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mangplaylist != null ? mangplaylist.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgplaylist;
        TextView txttenplaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgplaylist = itemView.findViewById(R.id.imageviewplaylist);
            txttenplaylist = itemView.findViewById(R.id.textviewplaylist);
        }
    }
}
