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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class DataStructureADTTest<T extends DataStructureADT<String, String>> {

  private T ds;

  protected abstract T createInstance();

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
    ds = createInstance();
  }

  @AfterEach
  void tearDown() throws Exception {
    ds = null;
  }


  @Test
  void test00_empty_ds_size() {
    if (ds.size() != 0)
      fail("data structure should be empty, with size=0, but size=" + ds.size());
  }

  @Test
  // insert one key value pair into the data structure and then confirm that size() is 1
  void test01_insert_one() {
    String url = ".css";
    String percentage = "98";
    ds.insert(url, percentage);
    assert (ds.size() == 1);
  }

  @Test
  // insert one key, value pair and remove it, then confirm size is 0
  void test02_insert_remove_one_size_0() {
    String url = ".css";
    String percentage = "98";
    ds.insert(url, percentage);
    assert (ds.remove(url)); // remove the key
    if (ds.size() != 0)
      fail("data structure should be empty, with size=0, but size=" + ds.size());
  }

  @Test
  // insert a few key, value pairs such that one of them has the same key as an earlier one
  void test03_duplicate_exception_thrown() {
    String url = ".css";
    String percentage = "98";
    ds.insert(url, percentage);
    ds.insert(".js", "87");
    try {
      ds.insert(url, "87");
      fail("duplicate exception not thrown");
    } catch (RuntimeException re) {
    }
    assert (ds.size() == 2);
  }

  @Test
  // insert some key, value pairs, then try removing a key that was not inserted
  // confirm that the return value is false
  void test04_remove_returns_false_when_key_not_present() {
    String url = ".css";
    String percentage = "99";
    ds.insert(url, percentage);
    assert (!ds.remove(".js")); // remove non-existent url is false
    assert (ds.remove(url)); // remove existing url is true
    if (ds.get(url) != null)
      fail("get(" + url + ") returned " + ds.get(url) + " which should have been removed");
  }

  @Test
  // inserts one item and fails if unable to remove it
  void test05_insert_remove_one() {
    String url = ".css";
    String percentage = "98";
    ds.insert(url, percentage);
    assert (ds.remove(url)); // fails if not true
  }

  @Test
  // inserts many items and fails if size is not correct
  void test06_insert_many_size() {
    String url = ".css";
    String percentage = "98";
    String url2 = ".js";
    String percentage2 = "85";
    ds.insert(url, percentage);
    ds.insert(url2, percentage2);
    if (ds.size() != 2)
      fail("data structure should have size of 2, but size=" + ds.size());
  }

  @Test
  // inserts two pairs with different keys, but same values; fails if second doesn't insert
  void test07_duplicate_values() {
    String url = ".css";
    String percentage = "98";
    ds.insert(url, percentage);
    ds.insert(".js", "98"); // inserts different url with same percentage as previous
    if (ds.size() != 2)
      fail("data structure should have inserted key with same value as previous");
  }

  @Test
  // tries to remove url that was never inserted
  void test08_remove_non_inserted() {
    String url = ".css";
    String percentage = "98";
    ds.insert(url, percentage);
    assert (ds.remove(url)); // fails if not true
  }


  @Test
  // tries to retrieve a value associated with a given key
  void test09_get_value() {
    String url = "1";
    String percentage = "98";
    ds.insert(url, percentage);
    assert (ds.get(url) == percentage); // fails if not true
  }

  @Test
  // makes sure that specific key value is located within data structure after inserted
  void test10_contains() {
    String url = ".java";
    String percentage = "76";
    // inserts values 0-4
    ds.insert(url, percentage);
    ds.insert(".css", "98");
    ds.insert(".js", "85");
    ds.insert(".py", "83");
    ds.insert(".json", "66");
    assert (ds.contains(url)); // fails if not true
    assert (ds.contains(".css")); // fails if not true
    assert (ds.contains(".js")); // fails if not true
    assert (ds.contains(".py")); // fails if not true
    assert (ds.contains(".json")); // fails if not true
    ds.remove(url);
    ds.remove(".css");
    ds.remove(".js");
    ds.remove(".py");
    ds.remove(".json");
    assert (ds.size() == 0); // fails if not true
  }

  @Test
  // inserts key, removes key, then re-inserts same key properly because it is not a duplicate
  void test11_add_remove_key() {
    String url = ".css";
    String percentage = "98";
    ds.insert(url, percentage);
    ds.remove(url);
    ds.insert(url, percentage);
    assert (ds.size() == 1); // fails if not true
  }

  @Test
  // inserts key, removes key, re-inserts same key, re-removes same key
  void test12_add_remove_key_boolean() {
    String url = ".css";
    String percentage = "98";
    ds.insert(url, percentage);
    ds.remove(url);
    ds.insert(url, percentage);
    assert (ds.remove(url)); // fails if not true
  }
}
