import khs.Khs;
import khs.KhsDetail;
import khs.Mahasiswa;
import khs.Matakuliah;
import khs.Term;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int getIndexFromMataKuliah(ArrayList<Matakuliah> array, String kodeMatKul) {
        int index = 0;
        for (Matakuliah matakuliah : array) {
            if (matakuliah.getKodeMataKuliah().equals(kodeMatKul)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int getIndexFromMahasiswa(ArrayList<Mahasiswa> array, String studentID) {
        int index = 0;
        for (Mahasiswa mhs : array) {
            if (mhs.getStudentID().equals(studentID)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int getIndexFromTerm(ArrayList<Term> array, String kodeTerm) {
        int index = 0;
        for (Term term : array) {
            if (term.getKodeTerm().equals(kodeTerm)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static ArrayList<Mahasiswa> initMahasiswa(ArrayList<Mahasiswa> mahasiswa){
        Mahasiswa mhs1 = new Mahasiswa("01_SI", "Marcello Stevin Halim", "Sistem Informasi", 2020);
        mahasiswa.add(mhs1);
        Mahasiswa mhs2 = new Mahasiswa("02_SI", "Brian", "Sistem Informasi", 2020);
        mahasiswa.add(mhs2);
        Mahasiswa mhs3 = new Mahasiswa("01_H", "Angelo", "Hukum", 2020);
        mahasiswa.add(mhs3);
        return mahasiswa;
    }

    public static ArrayList<Term> initTerm(ArrayList<Term> term){
        Term term1 = new Term("01_term", 2021, "1", "Periode 2021/2022", "Semester Ganjil");
        term.add(term1);
        Term term2 = new Term("02_term", 2022, "2", "Periode 2021/2022", "Semester Genap");
        term.add(term2);
        Term term3 = new Term("03_term", 2022, "3", "Periode 2021/2022", "Semester Akselerasi");
        // System.out.printf("%-10s %-25s %-20s %4s\n", "03_term", "2021", "3", "Periode ****/****", "Semester Pendek");
        term.add(term3);
        return term;
    }

    public static ArrayList<Matakuliah> initMataKuliah(ArrayList<Matakuliah> matKul) {
        Matakuliah matKul1 = new Matakuliah("01_SD", "Struktur Data", 4);
        matKul.add(matKul1);
        Matakuliah matKul2 = new Matakuliah("02_AD", "Agama Dunia", 3);
        matKul.add(matKul2);
        Matakuliah matKul3 = new Matakuliah("03_BI", "Bahasa Indonesia", 2);
        matKul.add(matKul3);
        return matKul;
    }

/*      public static ArrayList<Khs> initKhs(ArrayList<Khs> khs, ArrayList<Mahasiswa> mahasiswas, ArrayList<Term> terms) {
        Khs khs1 = new Khs("002", "Sangat Baik", "Juara umum", mahasiswas.get(0), terms.get(0));
        khs.add(khs1);
        return khs;
    } 

    public static ArrayList<KhsDetail> initKhsDetail(ArrayList<KhsDetail> khsDetails, ArrayList<Matakuliah> matKul) {
        KhsDetail KhsDetails = new KhsDetail("005", "002", matKul.get(0), 90);
        khsDetails.add(KhsDetails);
        return khsDetails;
    } */

    public static void main(String[] args) throws Exception {
        ArrayList<Term> term = new ArrayList<Term>();
        ArrayList<Matakuliah> mataKuliah = new ArrayList<Matakuliah>();
        ArrayList<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
//        ArrayList<KhsDetail> khsDetails = new ArrayList<KhsDetail>();
//        ArrayList<Khs> KHS = new ArrayList<Khs>();
        
        initMahasiswa(mahasiswa);
        initTerm(term);
        initMataKuliah(mataKuliah);
//        initKhs(KHS, mahasiswa, term);
//        initKhsDetail(khsDetails, mataKuliah);

        Scanner keyboard = new Scanner(System.in);
        String yn = "y";
        while(yn.equalsIgnoreCase("y")){
            clearScreen();
            System.out.println("Selamat datang! Kami akan melayani Anda, Para Dosen");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Input/Cetak Mata Kuliah");
            System.out.println("2. Input/Cetak Data Mahasiswa");
            System.out.println("3. Input/Cetak Data Term/Semester");
            System.out.println("4. Input/Cetak Data KHS (Overall)");
            System.out.println("5. Input/Cetak Data Detail KHS (MatKul)");
            System.out.println("6. Cetak IPK (sementara) Mahasiswa");
            System.out.println("7. Cetak Transkrip (sementara) Mahasiswa");
            System.out.println("8. Keluar");
            System.out.print("Pilihan Anda [1/2/3/4/5/6/7/8] ? ");
            String pilihan = keyboard.next();
            
            clearScreen();
            if (pilihan.equals("1")) {
                System.out.println("Data Mata Kuliah");
                System.out.println("----------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak Mata Kuliah (Kode MatKul)");
                System.out.println("3. Cetak Semua Mata Kuliah");
                System.out.print("Pilihan Anda [1/2/3] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    System.out.println("Input Mata Kuliah Baru");
                    System.out.println("----------------------");
                    System.out.print("Masukkan kode mata kuliah : ");
                    String kodeMatKul = keyboard.nextLine();
                    kodeMatKul+=keyboard.nextLine();
                    System.out.print("Masukkan nama mata kuliah : ");
                    String namaMatKul = keyboard.nextLine();
                    System.out.print("Masukkan jumlah sks       : ");
                    int sksMatKul = keyboard.nextInt();
                    mataKuliah.add(new Matakuliah(kodeMatKul, namaMatKul, sksMatKul));
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Mata Kuliah");
                    System.out.println("-----------------");
                    System.out.print("Masukkan kode mata kuliah : ");
                    String kode = keyboard.next();
                    if (mataKuliah.size() > 0) {
                        int idx = getIndexFromMataKuliah(mataKuliah, kode);
                        if (idx == -1) {
                            System.out.println("Kode yang Anda masukkan invalid..");
                        }
                        else {
                            clearScreen();
                            System.out.println("Data Mata Kuliah");
                            System.out.println("----------------");
                            System.out.println("Kode  : " + mataKuliah.get(idx).getKodeMataKuliah());
                            System.out.println("Nama  : " + mataKuliah.get(idx).getNamaMataKuliah());
                            System.out.println("Sks   : " + mataKuliah.get(idx).getSks());
                        }
                    }
                    else {
                        System.out.println("Tidak ada data mata kuliah yang ditemukan..");
                    }
                }
                else if (opsi.equals("3")) {
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("\t\t\tData Mata Kuliah");
                    System.out.println("----------------------------------------------------------------");
                    System.out.printf("%-20s %-25s %-4s\n", "Kode MatKul", "Nama MatKul", "Sks");
                    System.out.println("----------------------------------------------------------------");
                    for (Matakuliah matKul : mataKuliah) {
                        matKul.tampilkanDataMataKuliah();
                    }
                    System.out.println("----------------------------------------------------------------");
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            }

            else if(pilihan.equals("2")) {
                System.out.println("Data Mahasiswa");
                System.out.println("--------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak Mahasiswa (studentID)");
                System.out.println("3. Cetak Semua Data Mahasiswa");
                System.out.print("Pilihan Anda [1/2/3] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    System.out.println("Input Mahasiswa Baru");
                    System.out.println("--------------------");
                    System.out.print("Masukkan studentID      : ");
                    String studentID = keyboard.next();
                    System.out.print("Masukkan nama mahasiswa : ");
                    String namaMhsString = keyboard.nextLine();
                    namaMhsString += keyboard.nextLine();
                    System.out.print("Masukkan jurusan        : ");
                    String jurusanMhs = keyboard.nextLine();
                    System.out.print("Masukkan tahun masuk    : ");
                    int tahunMasuk = keyboard.nextInt();
                    mahasiswa.add(new Mahasiswa(studentID, namaMhsString, jurusanMhs, tahunMasuk));
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Data Mahasiswa");
                    System.out.println("--------------------");
                    System.out.print("Masukkan studentID : ");
                    String studentID = keyboard.next();
                    if (mahasiswa.size()>0) {
                        int idx = getIndexFromMahasiswa(mahasiswa, studentID);
                        if (idx == -1) {
                            System.out.println("Kode yang Anda masukkan invalid..");
                        }
                        else {
                            clearScreen();
                            System.out.println("Data Mahasiswa");
                            System.out.println("--------------");
                            System.out.println("Student ID    : " + mahasiswa.get(idx).getStudentID());
                            System.out.println("Nama          : " + mahasiswa.get(idx).getNama());
                            System.out.println("Jurusan       : " + mahasiswa.get(idx).getJurusan());
                            System.out.println("Tahun masuk   : " + mahasiswa.get(idx).getTahunMasuk());
                        }
                    }
                    else {
                        System.out.println("Tidak ada data yang ditemukan..");
                    }
                }
                else if (opsi.equals("3")) {
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("\t\t\tData Mahasiswa");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.printf("%-10s %-25s %-20s %4s\n", "StudentID", "Nama","Jurusan", "Tahun Masuk");
                    System.out.println("------------------------------------------------------------------------");  
                    for (Mahasiswa mhs : mahasiswa) {
                        mhs.tampilDataMahasiswa();
                    } 
                    System.out.println("------------------------------------------------------------------------");        
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            }

            else if (pilihan.equals("3")) {
                System.out.println("Data Term/Semester");
                System.out.println("------------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak Term (kode term)");
                System.out.println("3. Cetak Semua Term");
                System.out.print("Pilihan Anda [1/2/3] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    System.out.println("Input Data Term/Semester Baru");
                    System.out.println("-----------------------------");
                    System.out.print("Masukkan kode term          : ");
                    String kodeTerm = keyboard.next();
                    System.out.print("Masukkan tahun ajaran       : ");
                    int tahunAjaran = keyboard.nextInt();
                    System.out.print("Masukkan semester           : ");
                    String semester = keyboard.next();
                    System.out.print("Masukkan keterangan         : ");
                    String keterangan = keyboard.nextLine();
                    keterangan += keyboard.nextLine();
                    System.out.print("Masukkan keterangan singkat : ");
                    String keteranganSingkat = keyboard.nextLine();
                    term.add(new Term(kodeTerm, tahunAjaran, semester, keterangan, keteranganSingkat));
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Data Term/Semester");
                    System.out.println("--------------------");
                    System.out.print("Masukkan kode term : ");
                    String kodeTerm = keyboard.nextLine();
                    kodeTerm += keyboard.nextLine();
                    if (mahasiswa.size()>0) {
                        int idx = getIndexFromTerm(term, kodeTerm);
                        if (idx == -1) {
                            System.out.println("Kode yang Anda masukkan invalid..");
                        }
                        else {
                            term.get(idx).tampilTerm();
                        }
                    }
                    else {
                        System.out.println("Tidak ada data yang ditemukan..");
                    }
                }
                else if (opsi.equals("3")) {
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("\t\t\t\tData Term");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.printf("%-10s %-15s %-10s %-20s %-10s\n", "Kode", "Tahun Ajaran","Semester", "Keterangan", "Keterangan Singkat");
                    System.out.println("-------------------------------------------------------------------------------");                     
                    for (Term trm : term) {
                        trm.tampilTerm();
                    }
                    System.out.println("-------------------------------------------------------------------------------");
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            }

            else if (pilihan.equals("4")) {
                System.out.println("Data Kartu hasil studi (KHS)");
                System.out.println("---------------------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak");
                System.out.print("Pilihan Anda [1/2] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    System.out.println("Input Data KHS Baru");
                    System.out.println("-------------------");
                    System.out.print("Masukkan kode KHS            : ");
                    String kodeKHS = keyboard.next();
                    System.out.print("Masukkan studentID           : ");
                    String studentID = keyboard.next();
                    int index = getIndexFromMahasiswa(mahasiswa, studentID);
                    if (index == -1) {
                        System.out.println("studentID yang Anda masukkan invalid..");
                    }
                    else {
                        System.out.print("Masukkan kode term           : ");
                        String kodeTerm = keyboard.next();
                        int idx = getIndexFromTerm(term, kodeTerm);
                        if (idx == -1) {
                            System.out.println("Kode term yang Anda masukkan invalid..");
                        }
                        else {
                            System.out.print("Masukkan keterangan          : ");
                            String keterangan = keyboard.next();
                            System.out.print("Masukkan keterangan singkat  : ");
                            String keteranganSingkat = keyboard.next();
                            mahasiswa.get(index).khs.add(new Khs(kodeKHS, keterangan, keteranganSingkat, mahasiswa.get(index), term.get(idx)));
                        }
                    }
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Data KHS");
                    System.out.println("--------------");
                    System.out.print("Masukkan kode KHS : ");
                    String kodeKHS = keyboard.next();
                    boolean temu = false;
                    int idx = 0;
                    int index = 0;
                    for (Mahasiswa mahasiswa1 : mahasiswa) {
                        for (Khs khs1 : mahasiswa1.getKHS()) {
                            if (khs1.getKodeKHS().equalsIgnoreCase(kodeKHS)) {
                                temu = true;
                                if (mahasiswa.get(index).khs.get(idx).getKhsDetails().size() == 0) {
                                    System.out.println("\nTidak ada Detail KHS yang ditemukan..");
                                }
                                else {
                                    clearScreen();
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("\t\t\tKartu Hasil Studi");
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Nama        : " +  mahasiswa.get(index).getNama());
                                    System.out.println("Student ID  : " +  mahasiswa.get(index).getStudentID());
                                    System.out.println("Jurusan     : " +  mahasiswa.get(index).getJurusan());
                                    System.out.println("Term        : " +  mahasiswa.get(index).khs.get(idx).getTerm().getSemester());
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.printf("%-20s %-25s %-5s\n", "Kode Detail Khs", "Nama MatKul","Nilai");
                                    System.out.println("----------------------------------------------------------------------");
                                    for (Khs khs : mahasiswa.get(index).khs) {
                                        for (KhsDetail khsDetail : khs.getKhsDetails()) {
                                            khsDetail.tampilkanDetailKHS();
                                        }
                                    }
                                }
                                break;
                            }
                            idx++;
                        }
                        idx = 0;
                        index++;
                    }
                    if(temu == false){
                        System.out.println("Kode KHS yang Anda masukkan invalid..");
                    }
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            }

            else if (pilihan.equals("5")) {
                System.out.println("Data Detail KHS (MatKul)");
                System.out.println("------------------------");
                System.out.println("1. Input");
                System.out.println("2. Cetak");
                System.out.print("Pilihan Anda [1/2] ? ");
                String opsi = keyboard.next();

                clearScreen();
                if (opsi.equals("1")) {
                    System.out.println("Input Data Detail KHS Baru");
                    System.out.println("-----------------------------");
                    System.out.print("Masukkan kode detail KHS  : ");
                    String kodeDetailKHS = keyboard.nextLine();
                    kodeDetailKHS += keyboard.nextLine();
                    System.out.print("Masukkan kode KHS         : ");
                    String kodeKHS = keyboard.nextLine();

                    int idx = 0; // cari index array mahasiswa
                    int index = 0; // cari index array khs dalam mahasiswa
                    boolean temu = false;
                    for (Mahasiswa mahasiswa2 : mahasiswa) {
                        for (Khs khs : mahasiswa2.getKHS()) {
                            if (khs.getKodeKHS().equals(kodeKHS)) {
                                temu = true;
                                System.out.print("Masukkan kode mata kuliah : ");
                                String matKul = keyboard.nextLine();
                                int IDX = getIndexFromMataKuliah(mataKuliah, matKul);
                                if (IDX != -1) {
                                    System.out.print("Masukkan nilai            : ");
                                    int nilai = keyboard.nextInt();
                                    Mahasiswa mhs = mahasiswa.get(idx);
                                    mhs.khs.get(index).khsDetails.add(new KhsDetail(kodeDetailKHS, kodeKHS, mataKuliah.get(IDX), nilai));
                                }
                        else {
                            System.out.println("Kode mata kuliah yang Anda masukkan invalid..");
                        }
                                break;
                            }
                            index++;
                        }
                        index = 0;
                        idx++;
                    }
                    if(temu == false) {
                        System.out.println("Kode KHS yang Anda masukkan invalid..");
                    }
                }
                else if (opsi.equals("2")) {
                    System.out.println("Cetak Data Detail KHS");
                    System.out.println("---------------------");
                    System.out.print("Masukkan kode KHS : ");
                    String kodeKHS = keyboard.next();
                    boolean temu = false;
                    int idx = 0;
                    int index = 0;
                    for (Mahasiswa mahasiswa2 : mahasiswa) {
                        for (Khs khs : mahasiswa2.getKHS()) {
                            if (khs.getKodeKHS().equals(kodeKHS)) {
                                temu = true;
                                System.out.print("Masukkan kode detail KHS : ");
                                String kodeDetailKHS = keyboard.nextLine();
                                kodeDetailKHS += keyboard.nextLine();
                                boolean ketemu = false;
                                int Index = 0;
                                for (KhsDetail khsDetail : mahasiswa.get(index).khs.get(idx).khsDetails) {
                                    if (khsDetail.kodeKHSDetail.equals(kodeDetailKHS)) {
                                        ketemu = true;
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.printf("%-20s %-25s %-5s\n", "Kode Detail Khs", "Nama MatKul","Nilai");
                                        System.out.println("----------------------------------------------------------------------");
                                        mahasiswa.get(index).khs.get(idx).khsDetails.get(Index).tampilkanDetailKHS();
                                    }
                                    Index++;
                                }
                                if(ketemu == false) {
                                    System.out.println("\nKode detail KHS yang Anda masukkan invalid..");
                                }
                                break;
                            }
                            idx++;
                        }
                        idx = 0;
                        index++;
                    }
                    if(temu == false) {
                        System.out.println("Kode KHS yang Anda masukkan invalid..");
                    }
                }
                else {
                    System.out.println("Pilihan tidak tersedia..");
                }
            }
            
            else if (pilihan.equals("6")) {
                System.out.println("IPK Sementara Mahasiswa");
                System.out.println("-----------------------");
                System.out.print("Masukkan studentID : ");
                String studentID = keyboard.next();
                int idx = getIndexFromMahasiswa(mahasiswa, studentID);
                if (idx == -1) {
                    System.out.println("\nStudentID yang Anda masukkan invalid..");
                }
                else {
                    clearScreen();
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("\t\t  IPK Sementara Mahasiswa");
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Nama          : " +  mahasiswa.get(idx).getNama());
                    System.out.println("Student ID    : " +  mahasiswa.get(idx).getStudentID());
                    System.out.println("Jurusan       : " +  mahasiswa.get(idx).getJurusan()); 
                    System.out.println("IPK sementara : " +  String.format("%.2f",mahasiswa.get(idx).getIPK()));
                    System.out.println("----------------------------------------------------------------");
                }
            }

            else if (pilihan.equals("7")) {
                System.out.println("Transkrip Nilai Mahasiswa");
                System.out.println("-------------------------");
                System.out.print("Masukkan studentID : ");
                String studentID = keyboard.next();
                int idx = getIndexFromMahasiswa(mahasiswa, studentID);
                if (idx == -1) {
                    System.out.println("\nstudentID yang Anda masukkan invalid..");
                }
                else {
                    clearScreen();
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("\t\t\tTranskrip Nilai Mahasiswa");
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Nama        : " +  mahasiswa.get(idx).getNama());
                    System.out.println("Student ID  : " +  mahasiswa.get(idx).getStudentID());
                    System.out.println("Jurusan     : " +  mahasiswa.get(idx).getJurusan());
                    System.out.println("----------------------------------------------------------------------");
                    
                    if (mahasiswa.get(idx).khs.size() == 0) {
                        System.out.println("\nData tidak ditemukan..");
                    }
                    else {
                        System.out.printf("%-13s %-20s %-6s %-7s %-7s\n", "Kode MatKul", "Nama MatKul","Sks","Nilai","Angka Kualitas");
                        System.out.println("----------------------------------------------------------------------");
                        for (Khs khs : mahasiswa.get(idx).khs) {
                            for (KhsDetail khsDetail : khs.getKhsDetails()) {
                                String kode = khsDetail.getDetailMatakuliah().getKodeMataKuliah();
                                String nama = khsDetail.getDetailMatakuliah().getNamaMataKuliah();
                                int sks = khsDetail.getDetailMatakuliah().getSks();
                                String huruf = khsDetail.konversiNilaiHuruf();
                                float angka = khsDetail.getDetailMatakuliah().getSks() *khsDetail.konversiNilai();
                                System.out.printf("%-13s %-20s %-6d %-7s %-7.2f\n", kode, nama, sks, huruf, angka);
                            }
                        }
                        System.out.println("----------------------------------------------------------------------\n");
                    }
                }
            }

            else if (pilihan.equals("8")) {
                break;
            }

            else {
                System.out.println("Pilihan tidak tersedia..");
            }

            System.out.print("\nKembali ke halaman utama [y/n] ? ");
            yn = keyboard.next();
        }

            clearScreen();
            System.out.println("\nTerima Kasih!\n");
            keyboard.close();
        }
}   
