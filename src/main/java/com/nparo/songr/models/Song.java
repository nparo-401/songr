package com.nparo.songr.models;

import javax.persistence.*;

@Entity
public class Song {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  private String title;
  private int length;
  private int trackNumber;
  @ManyToOne
  private Album album;
  
  
  public Song(){}
  
  public Song(String title, int length, int trackNumber, Album album) {
    this.title = title;
    this.length = length * 60;
    this.trackNumber = trackNumber;
    this.album = album;
  }
  
  public String getTitle () {
    return title;
  }
  
  public int getLength () {
    return length;
  }
  
  public int getTrackNumber () {
    return trackNumber;
  }
  
  public Album getAlbum () {
    return album;
  }
  
  public String toString() {
    return this.title;
  }
}
