<a name="top"><a/>
## Songr
### Table of Contents
* [How to Run](#run)
* [Resources](#resources)
* [Files](#files)
* [Methods](#methods)

<a name="run"></a>
### How To Run
1. open a command line interface
2. cd into the songr directory
3. on first run:
  * `cd src/main/resources/`
  * `open application.properties`
  * uncomment line 2 and 3 (remove the '#'):
    * line 2 enter your PostgreSQL username after '='
    * line 3 enter your PostgreSQL password after '='
  * uncomment line 4 (remove the '#') change from `update` to `create`, save and exit
  * `cd ../../..`
4. run: `./gradlew bootRun`
5. open a browser and type `localhost:8080` as the URL
6. after first run:
  * `cd src/main/resources/`
  * `open application.properties`
  * comment line 4 (add the '#')

<a name="resources"></a>
### Resources
* [ThymeLeaf Error Page](https://www.logicbig.com/tutorials/spring-framework/spring-boot/custom-thymeleaf-error-page.html)
* [Bootstrap Grid Layout](https://getbootstrap.com/docs/4.3/layout/grid/)
* [Bootstrap Form](https://getbootstrap.com/docs/4.3/components/forms/#horizontal-form)
* [Bootstrap NavBar](https://getbootstrap.com/docs/4.3/components/navbar/#nav)
* Matt Stuhring
* Renee Messick
* Travis Cox
* Melfi Perez

<a name="files"></a>
### Files
* src/main
  * /java
    * [SongrApplication.java](./src/main/java/com/nparo/songr/SongrApplication.java)
  * /java/controllers
    * [AlbumController.java](./src/main/java/com/nparo/songr/controllers/AlbumController.java)
    * [ArtistController.java](./src/main/java/com/nparo/songr/controllers/ArtistController.java)
    * [RouteController.java](./src/main/java/com/nparo/songr/controllers/RouteController.java)
    * [SongController.java](./src/main/java/com/nparo/songr/controllers/SongController.java)
  * /java/models
    * [Album.java](./src/main/java/com/nparo/songr/models/Album.java)
    * [AlbumRepository.java](./src/main/java/com/nparo/songr/models/AlbumRepository.java)
    * [Artist.java](./src/main/java/com/nparo/songr/models/Artist.java)
    * [ArtistRepository.java](./src/main/java/com/nparo/songr/models/ArtistRepository.java)
    * [Song.java](./src/main/java/com/nparo/songr/models/Song.java)
    * [SongRepository.java](./src/main/java/com/nparo/songr/models/SongRepository.java)
  * /resources/templates
    * [addSongs.html](./src/main/resources/templates/addSongs.html)
    * [albums.html](./src/main/resources/templates/albums.html)
    * [allSongs.html](./src/main/resources/templates/allSongs.html)
    * [capitalize.html](./src/main/resources/templates/capitalize.html)
    * [error.html](./src/main/resources/templates/error.html)
    * [hello.html](./src/main/resources/templates/hello.html)
    * [index.html](./src/main/resources/templates/index.html)
    * [reverse.html](./src/main/resources/templates/reverse.html)
    * [songs.html](./src/main/resources/templates/songs.html)
* src/test
  * [RouteControllerTest.java](./src/test/java/com/nparo/songr/RouteControllerTest.java)

<a name="methods"></a>
### Methods
**SongrApplication**
* `public static void main(String[] args)`

**RouteController**
* Routers:
  * `@GetMapping("/") public String getRoot()`
  * `@GetMapping("/hello") public String getHello()`
  * `@GetMapping("/capitalize/{words}") public String getCapitalize()`
  * `@GetMapping("/reverse") public String getReverse(@RequestParam(required = false, defaultValue = "Reversed Sentence Goes Here") String sentence, Model m)`
* Helper Methods:
  * `public static String setCapitalize(String words)`
  * `public static String setReverse(String sentence)`

**AlbumController**
* Variables:
  * `@Autowired AlbumRepository albumRepository`
  * `@Autowired ArtistRepository artistRepository`
* Routers:
  * `@GetMapping("/albums") public String getAllAlbums(Model m)`
  * `@PostMapping("/albums") public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl)`

**ArtistController**
* TODO: create artist controller to be able to view all albums and songs associated with an individual artist/band

**SongController**
* Variables:
  * `@Autowired AlbumRepository albumRepository`
  * `@Autowired SongRepository songRepository`
* Routers:
  * `@GetMapping("/songs") public String getSong(Model m)`
  * `@GetMapping("/songs/{id}") public String getOneAlbum(@PathVariable long id, Model m)`
  * `@GetMapping("/allSongs") public String getAllSongs(Model m)`
  * `@PostMapping("/songs") public RedirectView addSong(String title, int length, int trackNumber, String album)`
  

**[Back to Top](#top)**
  