package com.nparo.songr.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
  public Song findSongByTitleAndAlbum(String title, Album album);
}
