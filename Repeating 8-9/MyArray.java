import java.util.*;

class Vektor {
    private ArrayList<Integer> bil = new ArrayList<Integer>();
    private int ukuran; private int temp;

    public Vektor() {
        bil.clear();
        ukuran = 0;temp = 1;}

    public double getMean() {
        if (ukuran == 0)
            {return -9.99;}
        int sum = 0;
        for (int i = 0; i < bil.size(); i++) 
        {sum += bil.get(i);}
        double rataan = 1.0 * sum / (double) ukuran;
        return rataan;}

    public void hapus(int x) {
        bil.remove(x - temp);
        ukuran--;temp++;}

    public void tambah(int x) {
        bil.add(x);ukuran++;}

    public int getukuran() 
    {return ukuran;}
  
};

public class MyArray {
    public static void main(String args[]) {
        int n;
        Scanner input = new Scanner(System.in);
        Vektor input2 = new Vektor();
        n = input.nextInt();
        while (n != -9) 
        {input2.tambah(n);n = input.nextInt();}
        double rataanAwal = input2.getMean();
       
       
        int ukuranAwal = input2.getukuran();
        n = input.nextInt();
        while (n != -9) {
        input2.hapus(n);
            n = input.nextInt();}
        System.out.printf("%d %d\n", ukuranAwal, input2.getukuran());
        System.out.printf("%.2f %.2f\n", rataanAwal, input2.getMean());
    }
}
