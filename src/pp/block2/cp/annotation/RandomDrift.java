package pp.block2.cp.annotation;

public class RandomDrift extends Thread {
    private Point p;

    public RandomDrift(Point p) {
        this.p = p;
    }

    @Override
	public void run() {
        while (true) {
            int n = (int) (Math.random() * 10);
            p.moveX(n);
            int m = (int) (Math.random() * 10);
            p.moveY(m);
        }
    }
}
