package com.nparo.songr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  private String artistName;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "artist")
  private List<Album> albums;
  
  public Artist(){}
  
  public Artist(String artistName) {
    this.artistName = artistName;
  }
  
  public String getArtistName () {
    return artistName;
  }
  
  public List<Album> getAlbums () {
    return albums;
  }
  
  public String toString() {
    return this.artistName;
  }
}
