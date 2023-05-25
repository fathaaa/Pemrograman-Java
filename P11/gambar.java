import java.util.Scanner;


class SegiEmpat {
    int lebarsegi;
    int tinggisegi;
    SegiEmpat(int wid, int heig) 
    {this.lebarsegi = wid;
        this.tinggisegi = heig;}
    double luas() 
    { double luas2 = lebarsegi * tinggisegi;
        return luas2;}
    }

class Circle {
    int dmeter2;
    Circle(int dmeter) 
    {this.dmeter2 = dmeter;}

    double luas() 
    {double jari = dmeter2 / 2.0;
        return Math.PI * jari * jari;}
}



class Silinder {
    SegiEmpat segiEmpat;
    Circle Circle;
    

    Silinder(int dmeter, int lebarsilinder, int tinggisilinder) 
    {Circle = new Circle(dmeter);
        segiEmpat = new SegiEmpat(lebarsilinder, tinggisilinder);}

    double volume() {
        return Circle.luas() * segiEmpat.tinggisegi;}
}

public class gambar {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int banyakcylin = read.nextInt();

        double totalVolume = 0;
        Silinder[] totalcylinder = new Silinder[banyakcylin];

        for (int i = 0; i < banyakcylin; i++) {
            int diametercircle = read.nextInt();
            int lebarsegiempat = read.nextInt();
            int tinggisegiempat = read.nextInt();

            totalcylinder[i] = new Silinder(diametercircle, lebarsegiempat, tinggisegiempat);
            totalVolume += totalcylinder[i].volume();}

        int upratarata = 0;
        
        double rataRata = totalVolume / banyakcylin;

        for (int i = 0; i < banyakcylin; i++) {
            if (totalcylinder[i].volume() > rataRata) {
                upratarata++;
            }
        }

        System.out.printf("%.2f %d", rataRata, upratarata);
    }
}