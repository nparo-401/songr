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
  * uncomment line 4 (remove the '#'), save and exit
  * `cd ../../..`
4. run: `./gradlew bootRun`
5. open a browser and type `localhost:8080` as the URL
6. after first run:
  * `cd src/main/resources/`
  * `open application.properties`
  * comment line 4 (add the '#')

<a name="resources"></a>
### Resources
* [HTML Forms](https://www.w3schools.com/html/html_forms.asp)
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
    * [RouteController.java](./src/main/java/com/nparo/songr/controllers/RouteController.java)
    * [AlbumController.java](./src/main/java/com/nparo/songr/controllers/AlbumController.java)
  * /java/models
    * [Album.java](./src/main/java/com/nparo/songr/models/Album.java)
    * [AlbumRepository.java](./src/main/java/com/nparo/songr/models/AlbumRepository.java)
  * /resources/templates
    * [albums.html](./src/main/resources/templates/albums.html)
    * [capitalize.html](./src/main/resources/templates/capitalize.html)
    * [hello.html](./src/main/resources/templates/hello.html)
    * [index.html](./src/main/resources/templates/index.html)
    * [reverse.html](./src/main/resources/templates/reverse.html)
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
* Routers:
  * `@GetMapping("/albums") public String getAllAlbums(Model m)`
  * `@PostMapping("/albums") public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl)`
  

**[Back to Top](#top)**
  