import java.util.*;

abstract class Num {
    public void hasil(int num1, int num2, int num3, int num4){};
    public void print(){};
    public void hasil(double angk1, double angk2){};
}

class Num2 extends Num {
    double sum;
    public void hasil(double angk1, double angk2)
    {sum = angk1 + angk2;}
    public void print()
    {System.out.printf("%.2f%n", sum);}
}

class Num4 extends Num {
    public int peny;public int pemb;
    int gcd(int n, int m)
    
    {if (m == 0)
    {return n;}else{
        return gcd(m,n%m);}}
    public void hasil(int num1,int num2, int num3, int num4)
    {pemb = num2*num4;
        peny = num1*num4 + num3*num2;
        
        int fpb = gcd(peny, pemb);
        peny /= fpb;pemb /= fpb;}
    public void print()
    {System.out.println(peny + " " + pemb);}
}

public class Abstrak {
    public static void main(String[] args) {
        ArrayList<Num> fullnum = new  ArrayList<>();
        
        int awal, akhir,selector,banyakbil;
        double bil1, bil2;
        int angk1, angk2, angk3, angk4;
       
        try(Scanner sc = new Scanner(System.in)){
            banyakbil = sc.nextInt();
            for(int i = 0; i < banyakbil; i++){
                selector = sc.nextInt();
                if(selector == 1)
                {bil1 = sc.nextDouble();bil2 = sc.nextDouble();
                    Num bil3 = new Num2();
                    bil3.hasil(bil1, bil2);
                    fullnum.add(bil3);
                }else
                {angk1 = sc.nextInt();angk2 = sc.nextInt();angk3 = sc.nextInt();angk4 = sc.nextInt();
                    Num bil4 = new Num4();
                bil4.hasil(angk1, angk2, angk3, angk4);
                    fullnum.add(bil4);}
            }
            awal = sc.nextInt();akhir = sc.nextInt();
            for(int i = awal - 1; i < akhir; i++){
                fullnum.get(i).print();
            }
        }

    }
}