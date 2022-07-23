import java.util.ArrayList;
import java.util.List;

// package test;
// public class Demo {
//   public static void main(String[] args)
//       ｛
//             System.out.println("Hello Java");
//        ｝ 
// }

public class test {
  public static void main(String[] args) throws Exception {
      List<List<Integer>> arr = new ArrayList<List<Integer>>();;
      List<Integer> ls = new ArrayList<>();
      List<Integer> ls2 = new ArrayList<>();
      List<Integer> ls3 = new ArrayList<>();
      ls.add(1);
      ls.add(2);
      ls.add(3);
      arr.add(ls);
      arr.add(ls2);
      arr.add(ls3);
      System.out.println(arr);
      System.out.println("Hello, World!");
  }
}