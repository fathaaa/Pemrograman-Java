import java.util.Scanner;

interface AritmatikaDasar {
    double tambah(double a, double b);

    double kurang(double a, double b);

    double kali(double a, double b);

    double bagi(double a, double b);

}

interface AritmatikaLanjut {
    double akarKuadrat(double a);

    double pangkat(double a, double b);

}

interface KalkulatorSaintifik extends AritmatikaDasar, AritmatikaLanjut {
    void clear();

}

class Kalkulator implements KalkulatorSaintifik {
    double currentValue;

    public Kalkulator() {
        currentValue = 0;
    }

    public double tambah(double a, double b) {
        return a + b;
    }

    public double kurang(double a, double b) {
        return a - b;
    }

    public double kali(double a, double b) {
        return a * b;
    }

    public double bagi(double a, double b) {
        return a / b;
    }

    public double akarKuadrat(double a) {
        return Math.sqrt(a);
    }

    public double pangkat(double a, double b) {
        return Math.pow(a, b);
    }

    public void clear() {
        currentValue = 0;
    }

    public void print() {
        System.out.printf("%.2f", currentValue);
        System.out.println();
    }

    public double set(double a) {
        currentValue = a;
        return currentValue;
    }

}

public class Kalku {
    public static void main(String[] args) {
        Kalkulator k = new Kalkulator();
        Scanner scanner = new Scanner(System.in);
        String tanda;
        double temp = 0;
        tanda = scanner.next();
        while (!tanda.equals("~")) {
            double angk;
            switch (tanda) {
                case "+":
                    angk = scanner.nextDouble();
                    temp = k.tambah(temp, angk);
                    k.set(temp);
                    break;

                case "-":
                    angk = scanner.nextDouble();
                    temp = k.kurang(temp, angk);
                    k.set(temp);
                    break;

                case "*":
                    angk = scanner.nextDouble();
                    temp = k.kali(temp, angk);
                    k.set(temp);
                    break;

                case "/":
                    angk = scanner.nextDouble();
                    temp = k.bagi(temp, angk);
                    k.set(temp);
                    break;

                case "^":
                    angk = scanner.nextDouble();
                    temp = k.pangkat(temp, angk);
                    k.set(temp);
                    break;

                case "#":
                    temp = k.akarKuadrat(temp);
                    k.set(temp);
                    break;

                case "C":
                    k.clear();
                    temp = k.currentValue;
                    break;

                default:
                    System.out.println("Tanda tidak valid");
                    break;
            }
            k.print();
            tanda = scanner.next();
        }

        scanner.close();
    }
}
