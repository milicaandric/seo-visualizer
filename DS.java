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

/**
 * This class will implement DataStructureADT.
 */
public class DS implements DataStructureADT<String, String> {
  private static int size;
  private static Pair[] mainArray;

  /**
   * Constructor that creates a new DS instance.
   */
  public DS() {
    DS.size = 0;
    DS.mainArray = new Pair[1000];
  }

  /**
   * Setter method for Pair[] mainArray.
   */
  public static void setArray(Pair[] mainArray) {
    DS.mainArray = mainArray;
  }

  /**
   * Getter method for Pair[] mainArray.
   * 
   * @return Pair[] representing data in files
   */
  public static Pair[] getArray() {
    return mainArray;
  }

  /**
   * Adds the url, bytes pair to the data structure and increases size. If url is null, throws
   * IllegalArgumentException("null url"). If url is already in data structure, throws
   * RuntimeException("duplicate url"). This method can accept and insert null values.
   * 
   * @throws IllegalArgumentException - if url is null
   * @throws RuntimeException         - if url is already in data structure
   * @param url   - String representing url
   * @param bytes - String representing associated value to url
   */
  @Override
  public void insert(String url, String bytes) {
    if (url == null) {
      throw new IllegalArgumentException("null url");
    }
    Pair pair = new Pair(url, bytes, null);
    // if the array is empty
    if (mainArray[0] == null) {
      mainArray[0] = pair;
      size++;
    }
    // if array is not empty
    else {
      Pair[] newarray = new Pair[size + 1]; // create a new array with capacity of size + 1
      for (int i = 0; i < size; i++) { // inserts elements from old array into new array
        newarray[i] = mainArray[i];
      }
      mainArray = newarray;
      for (int j = 0; j < size; j++) {
        if (newarray[j].getUrl() == url) {
          throw new RuntimeException("duplicate url");
        }
      }
      mainArray[size] = pair; // inserts new key into data structure
      size++;
    }
  }

  /**
   * Method that searches for url already in data structure. If url is found, removes the url from
   * the data structure and decreases size. If url is null, throws IllegalArgumentException("null
   * url") without decreasing size. If url is not found, returns false.
   * 
   * @throws IllegalArgumentException - if url is null
   * @param url - String representing url
   * @return false if url is found and successfully removed and false otherwise
   */
  @Override
  public boolean remove(String url) {
    if (url == null) {
      throw new IllegalArgumentException("null url");
    }
    for (int i = 0; i < size; i++) {
      if (mainArray[i].getUrl() == url) {
        mainArray[i] = null;
        for (int j = i; j < size - 1; j++) {
          if (mainArray[j] == null) {
            mainArray[j] = mainArray[j + 1];
            mainArray[j + 1] = null;
          }
        }
        size--;
        return true;
      }
    }
    return false;
  }

  /**
   * Method that returns the bytes associated with the specified url. Does not remove url or
   * decrease size. Returns null if url is not null and is not found in data structure. If url is
   * null, throws IllegalArgumentException("null url").
   * 
   * @throws IllegalArgumentException - if url is null
   * @param url - String representing url
   * @return String representing bytes associated with url if found and null otherwise
   */
  @Override
  public String get(String url) {
    if (url == null) {
      throw new IllegalArgumentException("null url");
    }
    for (int i = 0; i < size; i++) {
      if (mainArray[i].getUrl() == url) {
        return mainArray[i].getBytes();
      }
    }
    return null;
  }

  /**
   * Returns true if the url is in the data structure. Returns false if url is null or not present.
   * 
   * @param url - String representing url
   * @return true if url is in the data structure and false otherwise
   */
  @Override
  public boolean contains(String url) {
    for (int i = 0; i < size; i++) {
      if (mainArray[i].getUrl() == url) {
        return true; // returns true if url is in data structure
      }
    }
    return false; // returns false if url is null or not present
  }

  /**
   * Returns the number of elements in the data structure.
   * 
   * @return size of the data structure.
   */
  @Override
  public int size() {
    return DS.size;
  }
}

