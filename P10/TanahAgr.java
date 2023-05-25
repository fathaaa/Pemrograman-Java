import java.util.Scanner;

abstract class TanahPakAgr {
    protected double keliling;
    public TanahPakAgr() {}
    public abstract void kelilingtanah();
    public double getKel() {return keliling;}
}

class PersPanjangTnh extends TanahPakAgr {
    private double panjangtnh;private double lebartnh;
    public PersPanjangTnh(double panjangtnh, double lebartnh) {
        this.panjangtnh = panjangtnh;
        this.lebartnh = lebartnh;}
    public void kelilingtanah() {keliling = 2 * (panjangtnh + lebartnh);}
}

class Lingkaran extends TanahPakAgr {
    private double radius;
    public Lingkaran(double radius) {this.radius = radius;}
    public void kelilingtanah() {keliling = 2 * Math.PI * radius;}
}

public class TanahAgr {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        TanahPakAgr[] tanah = new TanahPakAgr[count];

        for (int i = 0; i < count; i++) {
            int shapetnh = input.nextInt();
            if (shapetnh == 0) {
                double panjangtnh = input.nextDouble(); double lebartnh = input.nextDouble();
                tanah[i] = new PersPanjangTnh(panjangtnh, lebartnh);
            } else {double radius = input.nextDouble();tanah[i] = new Lingkaran(radius);}
            tanah[i].kelilingtanah();
        }

        double meankeliling = 0;
        for (int i = 0; i < count; i++) {meankeliling += tanah[i].getKel();}
        meankeliling /= count; double longpagar = 0;
        for (int i = 0; i < count; i++) {
            if (tanah[i].getKel() > meankeliling) {longpagar += tanah[i].getKel();}
        }System.out.printf("%.2f\n", longpagar);
    }
}