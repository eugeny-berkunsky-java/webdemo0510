package logic;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Calculator {
    private final static double a = -0.5;
    private final static double b = 2.0;

//    private final double start;
//    private final double finish;
//    private final double step;
//    private final int n;
//
//    public Calculator(double start, double finish, double step) {
//        this.start = start;
//        this.finish = finish;
//        this.step = step;
//        n = calculateSteps(start, finish, step);
//    }

    public int calculateSteps(double start, double finish, double step) {
        return (int) ((finish - start) / step + 1);
    }

    public double f(double x) {
        final double EPS = 1e-6;
        if (x<0.7+EPS) return 1;
        if (x>1.4+EPS) return Math.exp(a*x)*Math.cos(b*x);
        return a*x*x*Math.log(x);
    }

    public double[] fillArrayX(double start, double finish, double step) {
        return IntStream
                .range(0, calculateSteps(start, finish, step))
                .mapToDouble(i -> start + i * step)
                .toArray();
    }

    public double[] fillArrayY(double[] x) {
        return DoubleStream
                .of(x)
                .map(this::f)
                .toArray();
    }

    public double sumArray(double[] arr) {
        return DoubleStream.of(arr).sum();
    }

    public double avgArray(double[] arr) {
        return sumArray(arr)/arr.length;
    }
}
