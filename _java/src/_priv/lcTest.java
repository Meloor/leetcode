package _priv;

import _priv.meloor.Hello;

class Solution{
    public void hello(){
        System.out.print(this.getClass().getName());
        System.out.println(":hello");
    }
}

public class lcTest {
    public static void main(String[] args) {
        // System.out.println("hello");
        new Hello().hello();
        new Solution().hello();
    }
}
