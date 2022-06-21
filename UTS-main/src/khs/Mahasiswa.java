package khs;

import java.util.ArrayList;

public class Mahasiswa {
    private String studentID, nama, jurusan;
    private int tahunMasuk;
    public ArrayList<Khs> khs = new ArrayList<Khs>();

    public Mahasiswa(String studentID, String nama, String jurusan, int tahunMasuk) {
        this.studentID = studentID;
        this.nama = nama;
        this.jurusan = jurusan;
        this.tahunMasuk = tahunMasuk;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return this.jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public int getTahunMasuk() {
        return this.tahunMasuk;
    }

    public void setTahunMasuk(int tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public ArrayList<Khs> getKHS() {
        return this.khs;
    }

    public Khs getKhs(Term term){
        int idx=0;
        for (Khs i : khs) {
            if(i.getDetailTerm().getKodeTerm().equalsIgnoreCase(term.getKodeTerm())){
                return khs.get(idx);
            }
            idx += 1;
        }
        return null;
    }
    
    public double getIPKTerm(Term term) {
        for (Khs i : khs) {
            if(i.getDetailTerm().getKodeTerm().equalsIgnoreCase(term.getKodeTerm())){
                return getKhs(term).getIPSemester();
            }
        }
        return 0.0;
    }

    public double getIPK(){
        double total = 0;
        for (Khs khs2 : khs) {
            total+=khs2.getIPSemester();
        }
        return total/khs.size();
    }

    public void tampilDataMahasiswa() {
        System.out.printf("%-10s %-25s %-20s %4d\n", studentID, nama, jurusan, tahunMasuk);
    }
}