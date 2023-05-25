import java.util.Scanner;
import java.text.DecimalFormat;

interface Shape2D 
{void print();
    void set(double[] x, double[] y, int banyaksisi);
    double kelilingeuclidean();
}

class Poligon implements Shape2D {
    private int banyaksisi;
    private double[] titikx;
    private double[] titiky;

    public void set(double[] x, double[] y, int banyaksisi) 
    {this.banyaksisi = banyaksisi;
        this.titikx = x;this.titiky = y;}

    public double kelilingeuclidean() {
        double keliling = 0.0;
        for (int i = 0; i < banyaksisi - 1; i++) 
        {double datax = titikx[i+1] - titikx[i];
            double datay = titiky[i+1] - titiky[i];
            keliling += Math.sqrt(datax*datax + datay*datay);}
        double datax = titikx[0] - titikx[banyaksisi-1];
        double datay = titiky[0] - titiky[banyaksisi-1];
        keliling += Math.sqrt(datax*datax + datay*datay);
        return keliling;
    }

    public void print() {
        System.out.printf("[%1$.2f,%2$.2f]-[%3$.2f,%4$.2f]\n", titikx[0], titiky[0], titikx[banyaksisi-1], titiky[banyaksisi-1]);
    }
}

public class Poligonmain {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Poligon poly = new Poligon();
        int banyaksisi = read.nextInt();
        double[] titikx = new double[banyaksisi];
        double[] titiky = new double[banyaksisi];

        for (int i = 0; i < banyaksisi; i++) {
            titikx[i] = read.nextDouble();
            titiky[i] = read.nextDouble();
        }poly.set(titikx, titiky, banyaksisi);

        poly.print();
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(poly.kelilingeuclidean()));
        read.close();
    }
}
