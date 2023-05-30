package com.example.TuneIn;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyPlaylist implements Playlist {

    private int count = 0;

    private List<Song> songsList = new ArrayList<Song>();

    @Override
    public void addSong(Song song) {
        this.count++;
        this.songsList.add(song);
    }

    @Override
    public List<Song> getPlaylistSongs() {
        return this.songsList;
    }

    @Override
    public Integer getCount() {
        return count;
    }
}