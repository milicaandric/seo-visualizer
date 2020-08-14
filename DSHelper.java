///////////////////////////////////////////////////////////////////////////////
//
// Title: SEO Visualizer
// Author: Milica Andric
// Description: Program that implements and tests an abstract data structure from selected file and
// creates relevant GUI. Program helps users (ex: SEO specialists) visualize unused code bytes of
// website and provides better understanding as to which issues should take priority. Users can
// then clean up and update their website accordingly.
//
///////////////////////////////////////////////////////////////////////////////
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * This class contains several helper methods that extends DS.
 */
public class DSHelper extends DS {
  private static Pair[] mainArray;
  private static int css = 0;
  private static int js = 0;
  private static int html = 0;
  private static int py = 0;


  /**
   * Getter method for css.
   * 
   * @return int representing total number of css files
   */
  public static Pair[] getArray() {
    return mainArray;
  }

  /**
   * Setter method for Pair[] mainArray.
   */
  public static void setArray(Pair[] mainArray) {
    DSHelper.mainArray = mainArray;
  }

  /**
   * Getter method for css.
   * 
   * @return int representing total number of css files
   */
  public static int getCss() {
    return css;
  }

  /**
   * Setter method for css.
   */
  public static void setCss(int css) {
    DSHelper.css = css;
  }

  /**
   * Getter method for js.
   * 
   * @return int representing total number of js files
   */
  public static int getJs() {
    return js;
  }

  /**
   * Setter method for js.
   */
  public static void setJs(int js) {
    DSHelper.js = js;
  }

  /**
   * Getter method for html.
   * 
   * @return int representing total number of html files
   */
  public static int getHtml() {
    return html;
  }

  /**
   * Setter method for html.
   */
  public static void setHtml(int html) {
    DSHelper.html = html;
  }

  /**
   * Getter method for py.
   * 
   * @return int representing total number of py files
   */
  public static int getPy() {
    return py;
  }

  /**
   * Setter method for py.
   */
  public static void setPy(int py) {
    DSHelper.py = py;
  }

  /**
   * Method that reads and parses user uploaded file to list.
   * 
   * @param file - File object uploaded by user at start of program
   * @return list - ArrayList<String> containing file contents
   */
  public static ArrayList<String> fileToList(File file) {
    ArrayList<String> result = new ArrayList<String>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      // adds each line to array list
      while ((line = reader.readLine()) != null) {
        if (!line.isEmpty()) {
          result.add(line);
        }
      }
      reader.close();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Method that converts list to array.
   * 
   * @param list - ArrayList<String> containing file contents
   * @return array - String[] containing file contents
   */
  public static String[] listToArray(ArrayList<String> list) {
    String[] array = new String[list.size()]; // creates new array with size of list as capacity
    // transfers data from list to array
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != null) {
        array[i] = list.get(i);
      }
    }
    return array;
  }

  /**
   * Method that converts list of Pair objects to array of Pair objects.
   * 
   * @param list - ArrayList<Pair> containing file contents in Pair objects
   * @return array - Pair[] containing Pair objects
   */
  public static Pair[] listToPairArray(ArrayList<Pair> list) {
    Pair[] pairArray = new Pair[list.size()]; // creates new array with size of list as capacity
    // transfers data from list to array
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != null) {
        pairArray[i] = list.get(i);
      }
    }
    return pairArray;
  }

  /**
   * Method that creates Pair objects from each element in an array.
   * 
   * @param array - String[] containing file contents
   * @return pairArray - Pair[] containing Pair elements
   */
  public static Pair[] arraySplitter(String[] array) {
    Pair[] pairArray = new Pair[array.length];
    for (int i = 0; i < array.length; i++) {
      String[] a = array[i].split(" ");
      Pair pair = new Pair(a[0], a[1], null);
      pairArray[i] = pair; // adds Pair object to pairArray
    }
    mainArray = pairArray;
    return pairArray;
  }

  /**
   * Method that keeps track of number of elements.
   * 
   * @param pairArray - Pair[] containing Pair objects
   */
  public static void elements(Pair[] pairArray) {
    for (int i = 0; i < pairArray.length; i++) { // traverses pairArray
      // distinguish type of code/file
      if (pairArray[i].getUrl().contains("css")) {
        pairArray[i].setType("css");
        css++;
      } else if (pairArray[i].getUrl().contains("js")) {
        pairArray[i].setType("js");
        js++;
      } else if (pairArray[i].getUrl().contains("html") || pairArray[i].getUrl().contains("htm")) {
        pairArray[i].setType("html");
        html++;
      } else if (pairArray[i].getUrl().contains("py")) {
        pairArray[i].setType("py");
        py++;
      }
    }
  }
}
