import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {

    private List<Integer> arr1;
    private List<Integer> arr2;
    private int numbr1;
    private int numbr2;
    private double mean1;
    private double mean2;

    public Data() {
        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();
        numbr1 = 0;numbr2 = 0;
        mean1 = 0;mean2 = 0;
    }

    public void plus1(int x) {
        arr1.add(x);
    }

    public void plus2(int x) {
        arr2.add(x);
    }
    public void set2() {
        numbr2 = arr1.size();
        mean2 = arr1.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public void dlte() {
        for (int i = arr2.size() - 1; i >= 0; i--) {
            arr1.remove(arr2.get(i) - 1);
        }
    }

    public void set1() {
        numbr1 = arr1.size();
        mean1 = arr1.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    

    public void print() {
        System.out.printf("%d %d\n", numbr1, numbr2);
        if (arr1.isEmpty()) {
            System.out.println("-9.99 -9.99");
        } else {
            System.out.printf("%.2f %.2f\n", mean1, mean2);
        }
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Data d = new Data();
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            if (x == -9) 
            {break;}
            d.plus1(x);
        }
        while (scanner.hasNextInt()) 
        {
            int x = scanner.nextInt();
            if (x == -9) {break;}
            d.plus2(x);
        }
        d.set1();
        d.dlte();
        d.set2();
        d.print();
    }
}
