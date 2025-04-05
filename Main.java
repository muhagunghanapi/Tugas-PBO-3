class Mahasiswa {
    String nama, nim, grade;
    int nilai;

    Mahasiswa(String nama, String nim, int nilai) {
        this.nama =  nama;
        this.nim = nim;
        this.nilai = nilai;
        this.grade = hitungGrade(nilai);
    }

    String hitungGrade(int nilai) {
        if (nilai >= 80) return "A";
        if (nilai >= 70) return "B";
        if (nilai >= 60) return "C";
        if (nilai >= 50) return "D";
        return "E";
    }
}

public class Main {
    public static void main(String[] args) {
        Mahasiswa[] mahasiswa = {
            new Mahasiswa("Afri", "2024001", 80),
            new Mahasiswa("Iqbal", "2024002", 90),
            new Mahasiswa("Halim", "2024003", 70),
            new Mahasiswa("Fadli", "2024004", 50)
        };

        int totalNilai = 0, lulus = 0, tidakLulus = 0;
        int countA = 0, countB = 0, countD = 0;
        StringBuilder lulusList = new StringBuilder();
        StringBuilder tidakLulusList = new StringBuilder();
        StringBuilder listA = new StringBuilder();
        StringBuilder listB = new StringBuilder();
        StringBuilder listD = new StringBuilder();

        for (Mahasiswa m : mahasiswa) {
            totalNilai += m.nilai;
            if (m.grade.equals("A") || m.grade.equals("B") || m.grade.equals("C")) {
                lulus++;
                lulusList.append(m.nama).append(", ");
            } else {
                tidakLulus++;
                tidakLulusList.append(m.nama).append(", ");
            }
            if (m.grade.equals("A")) {
                countA++;
                listA.append(m.nama).append(", ");
            }
            if (m.grade.equals("B")) {
                countB++;
                listB.append(m.nama).append(", ");
            }
            if (m.grade.equals("D")) {
                countD++;
                listD.append(m.nama).append(", ");
            }

        }

        for (Mahasiswa m : mahasiswa) {
            System.out.println("=========================");
            System.out.println("Nama : " + m.nama);
            System.out.println("Nim : " + m.nim);
            System.out.println("Nilai : " + m.nilai);
            System.out.println("Grade : " + m.grade);
        }
        System.out.println("=========================");
        System.out.println("Jumlah Mahasiswa : " + mahasiswa.length);
        System.out.println("Jumlah Mahasiswa yang Lulus : " + lulus + " yaitu " + lulusList.substring(0, lulusList.length() - 2));
        System.out.println("Jumlah Mahasiswa yang Tidak Lulus : " + tidakLulus + " yaitu " + tidakLulusList.substring(0, tidakLulusList.length() - 2));
        System.out.println("Jumlah Mahasiswa dengan Nilai A = " + countA + " yaitu " + listA.substring(0,listA.length() - 2));
        System.out.println("Jumlah Mahasiswa dengan Nilai B = " + countB + " yaitu " + listB.substring(0, listB.length() - 2));
        System.out.println("Jumlah Mahasiswa dengan Nilai D = " + countD + " yaitu " + listD.substring(0, listD.length() - 2));
        System.out.println("Rata-rata nilai mahasiswa adalah : " + (totalNilai / 4.0));
    }
}