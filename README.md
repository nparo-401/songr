<a name="top"><a/>
## Songr
### Table of Contents
* [Files](#files)
* [Methods](#methods)

### How To Run
1. open a command line interface
2. cd into the songr directory
3. run: `./gradlew bootRun`
4. open a browser and type `localhost:8080` as the URL

<a name="files"></a>
### Files
* src/main
  * /java
    * [SongrApplication.java](./src/main/java/com/nparo/songr/SongrApplication.java)
  * /java/controllers
    * [RouteController.java](./src/main/java/com/nparo/songr/controllers/RouteController.java)
  * /resources/templates
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
  
  **[Back to Top](#top)**
  