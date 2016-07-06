package math;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.*;

public class Vektor2D {

    public double x, y;
    Random rand = ThreadLocalRandom.current();
    
    public Vektor2D() {
        this(0,0);
    }

    public Vektor2D(double x, double y) {
        setX(x);
        setY(y);
    }
    
    public Vektor2D(Vektor2D copy) {
        this(copy.x, copy.y);
    }

    public Vektor2D(double x, double y, double x2, double y2) {
        this(x2 - x, y2 - y);
    }

    public Vektor2D(Vektor2D a, Vektor2D b) {
        this(b.getX() - a.getX(), b.getY() - a.getY());
    }

    // get and set methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPosition(Vektor2D newPos) {
        setX(newPos.getX());
        setY(newPos.getY());
    }

    public boolean isNullVector() {
        return (x == 0 && y == 0);
    }

    private void onErrorSetZero(int err) {
        //System.err.println("Double overflow" + err);
        //System.out.println("x" + " " + this.x);
        //System.out.println("y" + " " + this.y);
        //setPosition(0.0, 0.0);
    }
    
    public void differenz(Vektor2D a , Vektor2D b) {
    	this.x = Math.abs(a.x - b.x);
    	this.y = Math.abs(a.y - b.y);
    }

    public void add(Vektor2D vec) {
        x += vec.x;
        y += vec.y;
    }

    public void sub(Vektor2D vec) {
        x -= vec.x;
        y -= vec.y;
    }

    public void mult(double s) {
        x *= s;
        y *= s;
    }

    public void div(double s) {
        x /= s;
        y /= s;
    }

    public boolean isEqual(Vektor2D v) {      
        return ((this.x == v.x) && (this.y == v.y));
    }

    public boolean isNotEqual(Vektor2D v) {
        return !isEqual(v);
    }

    public double length() {
        double l = (sqrt(pow(this.x, 2) + pow(this.y, 2)));
        if ((l == Double.MAX_VALUE) || (l == Double.NEGATIVE_INFINITY) || (l == Double.POSITIVE_INFINITY) || ((Double)l).isNaN()) {
            throw new ArithmeticException("Double overflow" + l);
        }
        return l;
    }

    public void normalize() {
        if (this.isNullVector()) {

            this.x = rand.nextDouble() * 2 -1;
            this.y = rand.nextDouble() * 2 -1;
        } else {
            double l = this.length();
            this.x = (1 / l) * this.x;
            this.y = (1 / l) * this.y;
        }
    }
    
    public void truncate(double max) {
    	this.normalize();
    	this.x *= max;
    	this.y *= max;
    }
    
    public Vektor2D Round() {
		this.x = LineareAlgebra.Round(this.x);
		this.y = LineareAlgebra.Round(this.y);
		return this;
	}
}
