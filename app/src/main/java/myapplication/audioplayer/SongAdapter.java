package myapplication.audioplayer;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder>{

    private List<Song> songList;

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title,artist;

        public MyViewHolder(View view){
            super(view);
            title=(TextView) view.findViewById(R.id.title);
            artist=(TextView) view.findViewById(R.id.artist);
        }
    }

    public SongAdapter(List<Song> songList){
        this.songList=songList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_row,parent,false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,int position){
        Song song=songList.get(position);
        holder.title.setText(song.getTitle());
        holder.artist.setText(song.getArtist());
    }

    @Override
    public int getItemCount(){
        return songList.size();
    }


}
