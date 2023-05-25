import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Bilangan {
    abstract double hitung();

    static Bilangan createBilangan(double a, double b) {
        if (a % 1 == 0 && b % 1 == 0) {
            return new PecahanRasional((int) a, (int) b);
        } else {
            return new PecahanDesimal(a, b);
        }
    }
}

class PecahanRasional extends Bilangan {
    private int p;
    private int q;

    public PecahanRasional(int p, int q) {
        this.p = p;
        this.q = q;
    }

    @Override
    double hitung() {
        return (double) p / q;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}


class PecahanDesimal extends Bilangan {
    private double a;
    private double b;

    public PecahanDesimal(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double hitung() {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        List<Bilangan> bilanganList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int jenis = input.nextInt();
            double a, b;
            if (jenis == 1) {
                a = input.nextDouble();
                b = input.nextDouble();
            } else {
                int p = input.nextInt();
                int q = input.nextInt();
                int r = input.nextInt();
                int s = input.nextInt();
                a = (double) p / q;
                b = (double) r / s;
            }

            Bilangan bilangan = Bilangan.createBilangan(a, b);
            bilanganList.add(bilangan);
        }

        int start = input.nextInt();
        int end = input.nextInt();

        for (int i = start - 1; i < end; i++) {
            Bilangan bilangan = bilanganList.get(i);
            double hasil = bilangan.hitung();

            if (bilangan instanceof PecahanRasional) {
                PecahanRasional pecahanRasional = (PecahanRasional) bilangan;
                System.out.println(pecahanRasional.getP() + " " + pecahanRasional.getQ());

            } else {
                System.out.printf("%.2f%n", hasil);
            }
        }
    }
}
