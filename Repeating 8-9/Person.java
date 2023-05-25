import java.util.*;
import java.io.*;

class orang
{private String name;
    private int umur, height;
    private double weight;
    public orang()
    {
        name = " ";umur = 0;height = 0;weight = 0;}
    public orang(String name, int umur,int height, double weight)
    {
        this.name = name;this.umur = umur;
        this.height = height;this.weight = weight;}
    public String getname()
    {return name;}
    public int getumur()
    {return umur;}
    public int getheight()
    {return height;}
}

public class Person 
{
    public static void main(String[] args) 
    {
        int n, counter = 0; 
        int sum = 0;double rata=0;
        orang people[] = new orang[100];
        Scanner inp = new Scanner(System.in);
        n = inp.nextInt();
        for(int i=0; i<n; i++)
        {String name;
            int umur;
            int height;
            double weight;
            name = inp.next();umur = inp.nextInt();height = inp.nextInt();weight = inp.nextDouble();
            people[i] = new orang(name,umur,height,weight);
            sum = sum + people[i].getheight();}
        rata = (double) sum/n;
        for(int i=0; i<n; i++)
        {if(people[i].getheight()>rata)
            {counter++;}}
        for (int i=0; i<n; i++)
        {System.out.println(people[i].getname()+" "+people[i].getumur());}
        System.out.printf("%.2f\n", rata);
        System.out.println(counter);
    }
}
