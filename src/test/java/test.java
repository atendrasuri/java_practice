import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 27/11/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class test {
  public static void main(String[] args) {
    Map<Integer,String> map = new HashMap<>();
   map.put(1,"value1");
    map.put(2,"value2");
    map.put(null,"value3");
    map.put(1,"value4");

//    for(int i:map.keySet()){
//      System.out.println(map.get(i));

    m1(10);


  }

  public static void m1(Number m1){
    System.out.println(m1);
  }
  public static void m1(Object m1){
    System.out.println(m1);
  }
}