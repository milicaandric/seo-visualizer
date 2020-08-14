package application;

public interface DataStructureADT<K extends Comparable<K>, V> {

  void insert(String key, String value);

  boolean remove(String key);

  String get(String key);

  boolean contains(String key);

  int size();

}
