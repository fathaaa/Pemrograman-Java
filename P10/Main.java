import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.InputMap;
import java.util.Iterator;


class Pegawai{
    protected String id;
    protected int usia;
    protected int tipe;
    protected int income;
    public Pegawai()
    {
        id ="";
        usia=0;
        income =0;
        tipe =1;
    }

    public void set(String pid, int u, int t){
        id = pid;
        usia = u;
        tipe =  t;

    }

    public String getID(){
        return id;
    }

    public void show(){
        System.out.printf("%s %d %d", id, tipe, income);
    }


    
}

class Tetap extends Pegawai{
    public void setIncome(int income)
    {
    super.income = income;
    }
    public void addIncome(int income){
        super.income += income;
    }

    public int getTipe(){
        return super.tipe;
    }

    public int getIncome(){
        return super.income;
    }
}

class Harian extends Pegawai{
    public void setIncome(int income){
        super.income = income ;
    }

    public int getTipe(){
        return super.tipe;
    }

    public int getIncome(){
        return super.income;
    }
}

class Solve{
    private ArrayList<Tetap> listTetap = new ArrayList<Tetap>();
    private ArrayList<Harian> listHarian = new ArrayList<Harian>();

    public Solve(){
        listTetap.clear();
        listHarian.clear();
    }

    public void input(){
        Scanner input =  new Scanner(System.in);
        int n = input.nextInt();
        String id; int usia, tipe, income;

        for (int i = 0; i< n; i++){
            Tetap t = new Tetap();
            Harian h = new Harian();

            id = input.next();
            usia = input.nextInt();
            tipe = input.nextInt();

            if(tipe == 1){
                income = input.nextInt();
                t.set(id, usia, tipe);
                t.setIncome(income);
                listTetap.add(t);
            }else {
                h.set(id, usia, tipe);
                listHarian.add(h);
            }
        }

        while(input.hasNext()){
            String next = input.next();
            if(!next.equals("END")){
                break;
            } else {
                income = input.nextInt();
            }

            checkTetap(id, income);
            checkHarian(id, income);
        }

        input.close();
        

    }

    private void checkHarian(String id, int income){
        Iterator<Harian> it = listHarian.iterator();
        while(it.hasNext()){
            Harian h = it.next();
            if(h.getID().equals(id)){
                h.setIncome(income);
                break;
            }
        }
    }

    private void checkTetap(String id, int income){
        Iterator<Tetap> it = listTetap.iterator();
        while(it.hasNext()){
            Tetap t = it.next();
            if (t.getID().equals(id)){
                t.addIncome(income);
                break;
            }
        }
    }

    public void solved(){
        
    }
}


