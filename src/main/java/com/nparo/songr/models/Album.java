package com.nparo.songr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  private String title;
  
  @ManyToOne
  private Artist artist;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "album")
  private List<Song> songs;
  
  
  private int songCount;
  private int length;
  private String imageUrl;
  
  public Album() {}
  
  public Album(String title, Artist artist, int songCount, int length, String imageUrl) {
    this.title = title;
    this.artist = artist;
    this.songCount = songCount;
    this.length = length * 60;
    this.imageUrl = imageUrl;
  }
  
  public String getTitle () {
    return title;
  }
  
  public Artist getArtist () {
    return artist;
  }
  
  public int getSongCount () {
    return songCount;
  }
  
  public int getLength () {
    return length;
  }
  
  public String getImageUrl () {
    return imageUrl;
  }
  
  public List<Song> getSongs () {
    return songs;
  }
}
