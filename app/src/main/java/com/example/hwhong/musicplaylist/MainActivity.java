package com.example.hwhong.musicplaylist;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MediaPlayer mediaPlayer;
    private ArrayList<String> songNameList;
    private ArrayList<Integer> songList;

    private Button pause, stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_player);

        listView = (ListView) findViewById(R.id.listView);

        songNameList = new ArrayList<>();
        songList = new ArrayList<>();

        songNameList.add("iKON - My Type");
        songNameList.add("LEE HI - Because");
        songNameList.add("DJ Snake - Let me love you");
        songNameList.add("Desiinger - Panda");

        songList.add(R.raw.mytype);
        songList.add(R.raw.because);
        songList.add(R.raw.dj);
        songList.add(R.raw.panda);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, songNameList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), songList.get(i));
                mediaPlayer.start();
            }
        });

        pause = (Button) findViewById(R.id.pauseBut);
        stop = (Button) findViewById(R.id.stopBut);

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                MainActivity.this.finish();
            }
        });
    }
}
