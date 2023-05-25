import java.io.*;
import java.util.*;

public class Pecahan {
    private int bil1,bil2,bil3;
    public Pecahan()
    {bil1=0;bil2=0;bil3=1;}
    public void set(int x, int y, int z)
    {bil1=x;bil2=y;bil3=z;bagi();}
    public void add (int pa, int pb, int pc)
    {this.bil1= this.bil1+pa;
        this.bil2= this.bil2*pc+this.bil3*pb;
        this.bil3=this.bil3*pc;
        bagi();}
    public int fpb(int pemb, int peny)
    { while(peny!=0)
        {int temporary =pemb%peny;
        pemb=peny;peny=temporary;}
        return pemb;}
    public void mul (int pa, int pb, int pc)
    {this.bil2= (this.bil1*this.bil3+this.bil2)*(pa*pc+pb);
        this.bil3=this.bil3*pc;this.bil1=0;
        bagi();}
    public void bagi()
    {bil1= bil1+bil2/bil3;
        bil2=bil2%bil3;
        int temporary=fpb(bil2,bil3);
        bil2=bil2/temporary;
        bil3=bil3/temporary;
    }
    public void prnt()
    {if(bil2==0)
        {System.out.println(bil1);}
        else
        {System.out.printf("%d %d/%d\n", bil1,bil2,bil3);}}
   
    public void inc ()
    {this.bil1++;}
    public void dec ()
    {this.bil1--;}
    public static void main(String[] args)
    {
        Pecahan pechn = new Pecahan();
        Scanner inp = new Scanner(System.in);
        String x;
        x = inp.next();
        while(!x.equals("end"))
        { if(x.equals("inc"))
            {pechn.inc();}

        if(x.equals("p"))
            {pechn.prnt();}

        if(x.equals("set"))
            {
                int a= inp.nextInt();int b= inp.nextInt();int c= inp.nextInt();
                pechn.set(a,b,c);}
            if(x.equals("add"))
            {
                int a= inp.nextInt();int b= inp.nextInt();int c= inp.nextInt();
                pechn.add(a,b,c);}
            if(x.equals("mul"))
            {
                int a= inp.nextInt();int b= inp.nextInt();int c= inp.nextInt();
                pechn.mul(a,b,c);}
           
    if(x.equals("dec"))
            {pechn.dec();}
           
            x = inp.next();
        }
    }
};

