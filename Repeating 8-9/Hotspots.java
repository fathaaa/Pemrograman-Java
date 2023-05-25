import java.util.*;

public class Hotspots {
    public static class Pairs implements Comparable<Pairs> {
        public int bil1;
        public int bil2;
        public Pairs(int bil1, int bil2) 
        {this.bil1 = bil1;
            this.bil2 = bil2;}

        @Override
        public int compareTo(Pairs temp) {
            if (this.bil1 < temp.bil1) 
            {return 1;} 
            else if (this.bil1 > temp.bil1)
            {return -1;} 
            else {
        if (this.bil2 < temp.bil2) 
                {return 1;
            } else if (this.bil2 > temp.bil2)
                 {return -1;
            } else {
                    return 0;}
            } }
         }

    Set<Pairs> titikkoor = new TreeSet<>();
    public Hotspots() {
        this.titikkoor.clear();}
    public void print() {
            for (Pairs p : titikkoor)
             {
            if (p.bil2 > 0) {
                System.out.printf("(%d,%d)", p.bil1, p.bil2);}
            }
        }
    public void add(Pairs temp1) {
        titikkoor.add(temp1);}
    public void read() {
            Scanner sc = new Scanner(System.in);
            int var1, var2, var3;
            var1 = sc.nextInt();
            for (int i = 0; i < var1; i++) {
                var2 = sc.nextInt();var3 = sc.nextInt();
                Pairs temp1 = new Pairs(var2, var3);
                titikkoor.add(temp1);
            }
        }
    public int getsize() {
        return titikkoor.size();}
    
    public static void main(String[] args) {
        Hotspots hotspots = new Hotspots();
        hotspots.read();
        System.out.println(hotspots.getsize());
        hotspots.print();
    }
}
