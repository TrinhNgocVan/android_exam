package com.aptech.android_exam;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;

import com.aptech.android_exam.config.AppDatabase;
import com.aptech.android_exam.entity.Song;
import com.aptech.android_exam.repository.SongRepo;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.aptech.android_exam.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private AppDatabase appDatabase ;
    private SongRepo songRepo ;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        appDatabase  = AppDatabase.buildDatabaseInstance(this , "android_exam" , false);
        Toast.makeText(this,  appDatabase.doesDatabaseExist(this ,"android_exam"), Toast.LENGTH_SHORT).show();
//        addTable("song");
        insertSong();
        getallsong();
    }
    private void insertSong(){
        Song s = new Song("Demo" , "Demo2" , "Demo2" , "Demo2");
        songRepo = appDatabase.songRepo() ;
        songRepo.add(s);
        Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getallsong(){
        songRepo = appDatabase.songRepo() ;
        List<Song> songs = songRepo.getlAll();
//        if(songs != null) {
//            Toast.makeText(this, "list song not empty", Toast.LENGTH_SHORT).show();
//        }
        songs.stream().forEach(s -> {
            Toast.makeText(this, s.getAuthor(), Toast.LENGTH_SHORT).show();
                }
        );
    }
//    private void insertCredential(){
//        Credential c = new Credential("Demo", "Demo","Demo","Demo","Demo",1);
//        db.credentialRepo().insertCredential(c);
//        Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}