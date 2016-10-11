package myapplication.audioplayer;

import android.media.MediaPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Song> songList=new ArrayList<>();
    private RecyclerView recyclerView;
    private SongAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        */recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        sAdapter=new SongAdapter(songList);
        RecyclerView.LayoutManager sLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);

        prepareSongData();

        Button rewind=(Button)findViewById(R.id.rewind);
        Button pause=(Button)findViewById(R.id.pause);
        Button play=(Button)findViewById(R.id.play);
        Button fastfwd=(Button)findViewById(R.id.fastfwd);


        final MediaPlayer mp = null;

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                a=mp.getCurrentPosition();
                a=a-10000;
                mp.seekTo(a);
            }
        });

        fastfwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b;
                b=mp.getCurrentPosition();
                b=b+10000;
                mp.seekTo(b);
            }
        });

    }
    private void prepareSongData(){
        Song song=new Song("abc","def");
        songList.add(song);



        sAdapter.notifyDataSetChanged();
    }

}

