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
 * This class will test DataStructureADT.
 */
@SuppressWarnings("rawtypes")
public class TestDS extends DataStructureADTTest {

  /**
   * Returns JUnit test results for the data structure class being tested.
   * 
   * @return test results for name of the data structure class being tested
   */
  @Override
  protected DataStructureADT createInstance() {
    return new DS();
  }
}
