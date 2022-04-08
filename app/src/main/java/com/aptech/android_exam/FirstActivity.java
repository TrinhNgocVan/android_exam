package com.aptech.android_exam;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.android_exam.adapter.ListElementAdapter;
//import com.aptech.android_exam.databinding.FragmentFirstBinding;
import com.aptech.android_exam.entity.Song;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity  {
//    private SongService songService;
    private RecyclerView recyclerViewListSong;
//    private ResponseSong responseSong;
    private List<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // set permission lại cho internet
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);
        initView();
//        initData();
    }

    private void initView() {
        songs = new ArrayList<>();
        recyclerViewListSong = findViewById(R.id.recycler_view_list_song);
        recyclerViewListSong.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewListSong.setAdapter(new ListElementAdapter(this, songs));
    }

//    private void initData() {
//        if (songService == null) {
//            songService = RetrofitGenerator.createService(SongService.class); // thêm token nếu cần
//        }
//        try {
//            Response<ResponseSong> responseSongResponse = songService.getSong().execute();
//            if (responseSongResponse.isSuccessful()) {
//                songs.clear();
//                songs.addAll(responseSongResponse.body().getData());
//                ((RecyclerView.Adapter) recyclerViewListSong.getAdapter()).notifyDataSetChanged();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}