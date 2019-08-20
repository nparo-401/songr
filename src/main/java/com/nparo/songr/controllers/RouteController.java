package com.nparo.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
//  Route getters:
  @GetMapping("/")
  public String getRoot() {
    return "index";
  }

  @GetMapping("/hello")
  public String getHello() {
    return "hello";
  }

  @GetMapping("/capitalize/{words}")
  public String getCapitalize(@PathVariable String words, Model m) {
    m.addAttribute("words", setCapitalize(words));
    return "capitalize";
  }

  @GetMapping("/reverse")
  public String getReverse(@RequestParam(required = false, defaultValue = "Reversed Sentence Goes Here") String sentence,
                           Model m) {
    String reverse = setReverse(sentence);
    m.addAttribute("sentence", reverse);
    return "reverse";
  }

//  Helper Methods:
  public static String setCapitalize(String words) {
    return words.toUpperCase();
  }

  public static String setReverse(String sentence) {
    StringBuilder reversedString = new StringBuilder();
    String[] splitSentence = sentence.split(" ");
    for (int i = splitSentence.length - 1; i >= 0 ; i--) {
      reversedString.append(splitSentence[i]);
      if (i > 0) {
        reversedString.append(" ");
      }
    }
    return reversedString.toString();
  }
}
