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
 * Class that groups String url, String bytes, and String type by creating a Pair object.
 */
public class Pair {
  private String url;
  private String bytes;
  private String type;

  /**
   * Constructor that creates a new Pair object.
   */
  public Pair(String url, String bytes, String type) {
    this.url = url;
    this.bytes = bytes;
    this.type = type;
  }

  /**
   * Getter method for url.
   * 
   * @return String representing url within Pair object
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * Getter method for bytes.
   * 
   * @return String representing bytes within Pair object
   */
  public String getBytes() {
    return this.bytes;
  }

  /**
   * Getter method for type.
   * 
   * @return String representing type associated with Pair object
   */
  public String getType() {
    return this.type;
  }

  /**
   * Setter method for url.
   * 
   * @param url - String representing url within Pair object
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Setter method for bytes.
   * 
   * @param bytes - String representing bytes within Pair object
   */
  public void setBytes(String bytes) {
    this.bytes = bytes;
  }

  /**
   * Setter method for type.
   * 
   * @param bytes - String representing type associated with Pair object
   */
  public void setType(String type) {
    this.type = type;
  }
}

