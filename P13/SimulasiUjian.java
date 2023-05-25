import java.util.Scanner;

interface Answerable {
    boolean cekjwb(String jawaban);
}

class Soal implements Answerable {
    private String soal;
    private String answerkey;

    public Soal(String soal, String answerkey) {
        this.soal = soal;
        this.answerkey = answerkey;
    }

    public String getsoal() {
        return soal;
    }

    public boolean cekjwb(String jwb) {
        return answerkey.equalsIgnoreCase(jwb);
    }

   
}

class SoalIsian extends Soal {
    public SoalIsian(String soal, String answerkey) {
        super(soal, answerkey);
    }
}

class Ujian {
    private Soal[] semuasoal;
    private int jmlpertanyaan;

    public Ujian(int jmlpertanyaan) {
        this.jmlpertanyaan = jmlpertanyaan;
        semuasoal = new Soal[jmlpertanyaan];
    }

    public double hitungNilai(String[] jwb, int jmljawab) {
        int jwbtrue = 0;

        for (int i = 0; i < jmljawab; i++) 
        {if (semuasoal[Integer.parseInt(jwb[i]) - 1].cekjwb(jwb[i + jmljawab])) 
            {jwbtrue++;}}

        double nilai = (double) jwbtrue / jmlpertanyaan * 100;
        return nilai;
    }

    public void setSoal(int no, Soal soal) {
        semuasoal[no - 1] = soal;
    }
}

public class SimulasiUjian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jmlpertanyaan = input.nextInt();
        input.nextLine();
        Ujian ujian = new Ujian(jmlpertanyaan);

        for (int i = 0; i < jmlpertanyaan; i++) 
        {String soal = input.nextLine();
            String answerkey = input.nextLine();
            ujian.setSoal(i + 1, new SoalIsian(soal, answerkey));
        }
        int jmljawab = input.nextInt();
        input.nextLine();

        String[] jwb = new String[jmljawab * 2];

        for (int i = 0; i < jmljawab; i++) 
        {jwb[i] = input.nextLine();
            jwb[i + jmljawab] = input.nextLine();
        }

        double nilai = ujian.hitungNilai(jwb, jmljawab);
        System.out.printf("%.2f\n", nilai);
    }
}
