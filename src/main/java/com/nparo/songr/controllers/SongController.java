package com.nparo.songr.controllers;

import com.nparo.songr.models.Album;
import com.nparo.songr.models.AlbumRepository;
import com.nparo.songr.models.Song;
import com.nparo.songr.models.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
  @Autowired
  AlbumRepository albumRepository;
  @Autowired
  SongRepository songRepository;
  
  @GetMapping("/songs")
  public String getSong(Model m) {
    List<Album> albums = albumRepository.findAll();
    m.addAttribute("albums", albums);
    return "addSongs";
  }
  
  @GetMapping("/songs/{id}")
  public String getOneAlbum(@PathVariable long id, Model m) {
    Album album = albumRepository.findById(id).get();
    m.addAttribute("album", album);
    return "songs";
  }
  
  @GetMapping("/allSongs")
  public String getAllSongs(Model m) {
    List<Song> songs = songRepository.findAll();
    m.addAttribute("songs", songs);
    return "allSongs";
  }
  
  @PostMapping("/songs")
  public RedirectView addSong(String title, int length, int trackNumber, String album) {
    Album album1 = albumRepository.findByTitle(album);
    Song song = songRepository.findSongByTitleAndAlbum(title, album1);
    if (song == null) {
      song = new Song(title, length, trackNumber, album1);
      songRepository.save(song);
    }
    return new RedirectView("/songs");
  }
}
