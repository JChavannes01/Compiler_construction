package pp.block2.cp.annotation;

public class Point {
  /*@ spec_public */ private int x;
  /*@ spec_public */ private int y;

  //@ ensures \result >= 0;
  /*@ pure */public int getX() {
      return x;
  }

  //@ ensures \result >= 0;
  /*@ pure */public int getY() {
      return y;
  }

  /*@
    requires n >= 0; 
    ensures getX() == \old(getX()) + n;
   */
  public void moveX(int n) {
      x = x + n;
  }

  /*@
    requires n >= 0; 
    ensures getY() == \old(getY()) + n;
   */
  public void moveY(int n) {
      y = y + n;
  }
}
