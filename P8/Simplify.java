package P8;

import java.util.Scanner;

public class Simplify {

    private int a;
    private int b;
    private int c;

    private int fpb(int m, int n) {
        while (n != 0) {
            int t = m % n;
            m = n;
            n = t;
        }
        return m;
    }

    private void simplify() {
        a = a + b;
        b = b % c;
        int t = fpb(b, c);
        b = b / t;
        c = c / t;
    }

    public Simplify() {
        a = b = 0;
        c = 1;
    }

    public void set(int pa, int pb, int pc) {
        a = pa;
        b = pb;
        c = pc;
        simplify();
    }

    public void show() {
        if (b == 0) {
            System.out.println(a);
        } else {
            System.out.printf("%d %d/%d\n", a, b, c);
        }
    }

    public static void main(String[] args) {
        Simplify obj = new Simplify();
        String op;
        Scanner inp = new Scanner(System.in);
        op = inp.next();
        int pa, pb, pc;
        while (!op.equals("end")) {
            if (op.equals("set")) {
                pa = inp.nextInt();
                pb = inp.nextInt();
                pc = inp.nextInt();
                obj.set(pa, pb, pc);
            } else if (op.equals("p")) {
                obj.show();
            }else if(op.equals("add")){
                

            }
            
        }
    }

}

