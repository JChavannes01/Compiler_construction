package pp.block2.cp.annotation;

public class RandomPoint {
    public static void main(String[] args) {
        Point p = new Point();
        RandomDrift r1 = new RandomDrift(p);
        RandomDrift r2 = new RandomDrift(p);
        r1.start();
        r2.start();
    }
}
