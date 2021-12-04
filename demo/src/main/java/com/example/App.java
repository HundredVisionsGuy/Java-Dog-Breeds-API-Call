package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.json.JSONArray;

public final class App {
  /**
   * Makes an API call to dog.ceo (https://dog.ceo/) API
   * as a way of demonstrating how to work with a JSON REST API
   * in Java.
   * @param args The arguments of the program.
   */
  public static void main(String[] args) throws Exception {
    try {
      // Host URL, endpoint, and query
      String host = "https://dog.ceo/";
      String endpoint = "/api/breeds/list/all";
      String query = "";

      // put it all together into the api call
      String url = host + endpoint + query;

      // Let's make the call & store result as a string
      JSONObject result = Unirest.get(url)
          .asJson()
          .getBody()
          .getObject();
      
      JSONObject breeds = result.getJSONObject("message");

      String breedsString = breeds.keySet().toString();
      
      // convert breeds into Array of strings to loop through
      int start = 1, stop;
      stop = breedsString.length()-1;
      breedsString = breedsString.subSequence(start, stop).toString();
      ArrayList<String> myList = new ArrayList<String>(
        Arrays.asList(
          breedsString.split(", ")
          )
        );
      for (String b : myList) {
        System.out.println(b);
      }

      // JSONArray sb = object.getJSONArray("bulldog");
      // String subBreeds = sb.toString();
      // System.out.println(subBreeds);

      /* TODO
          * User must hit enter to get a display of at least 3 subbreeds of a breed
          * I will get subbreeds of bulldogs
          * Students will get a different set a subbreeds
            - Choose one of:  poodles, retrievers, terriers, mastiffs, spaniels, 
                              setters, and more
      */

      // System.out.println(myList);
    }

    catch (Exception e) {
      e.printStackTrace();
    }
  }

}

