package com.nparo.songr.controllers;

import com.nparo.songr.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
  @Autowired
  AlbumRepository albumRepository;
  @Autowired
  ArtistRepository artistRepository;
  
  @GetMapping("/albums")
  public String getAllAlbums(Model m) {
    List<Album> albums = albumRepository.findAll();
    m.addAttribute("albums", albums);
    return "albums";
  }
  
  @PostMapping("/albums")
  public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl) {
    if (songCount < 0) {
      throw new AlbumsMustNotHaveNegativeSongCountException("Negative number for song count is not allowed");
    } else if (length < 0) {
      throw new AlbumsMustNotHaveNegativeLengthException("Negative number for album length is not allowed");
    }
    Artist newArtist = artistRepository.findByArtistName(artist);
    if (newArtist == null) {
      newArtist = new Artist(artist);
      artistRepository.save(newArtist);
    }
    Album a = new Album(title, newArtist, songCount, length, imageUrl);
    albumRepository.save(a);
    return new RedirectView("/albums");
  }
}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class AlbumsMustNotHaveNegativeSongCountException extends RuntimeException {
  public AlbumsMustNotHaveNegativeSongCountException(String s) {
    super(s);
  }
}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class AlbumsMustNotHaveNegativeLengthException extends RuntimeException {
  public AlbumsMustNotHaveNegativeLengthException(String s) {
    super(s);
  }
}
