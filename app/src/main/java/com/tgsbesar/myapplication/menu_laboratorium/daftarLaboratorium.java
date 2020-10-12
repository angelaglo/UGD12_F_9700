package com.tgsbesar.myapplication.menu_laboratorium;

import com.tgsbesar.myapplication.model.Laboratorium;

import java.util.ArrayList;

public class daftarLaboratorium {

    public ArrayList<Laboratorium> LABORATORIUM= new ArrayList<>();

    public daftarLaboratorium(){
        LABORATORIUM = new ArrayList<>();
        LABORATORIUM.add(GENERAL_CHECKUP);
        LABORATORIUM.add(BASIC_CHECKUP);
        LABORATORIUM.add(GENERAL_ROGNTEN);
        LABORATORIUM.add(MATERNITY_CHECKUP);
        LABORATORIUM.add(KESEHATAN_JANTUNG);
        LABORATORIUM.add(RAPID_TEST);
        LABORATORIUM.add(SWAP_TEST);
    }

    public static Laboratorium GENERAL_CHECKUP = new Laboratorium("General Check Up", "Foto Thorax, EKG, Hematologi Rutin, Glukosa Puasa, Uric Acid, Cholesterol Total",2500000);
    public static Laboratorium BASIC_CHECKUP = new Laboratorium("Basic Check Up","Hematoilogi rutin, Glukosa Puasa, Uric Acid, Cholesterol Total, Urine Rutin",2000000);
    public static Laboratorium GENERAL_ROGNTEN = new Laboratorium("General Rognten","Rognten seluruh badan",1500000);
    public static Laboratorium MATERNITY_CHECKUP = new Laboratorium("Maternity Check Up", "Darah rutin, USG 4D, Golongan Darah, Urine Rutin",1250000);
    public static Laboratorium KESEHATAN_JANTUNG = new Laboratorium("Jantung Check Up","EKG, Hematologi Lengkap, Darah Rutin, Pemeriksaan Fisik, Treadmill ", 1760000);
    public static Laboratorium RAPID_TEST = new Laboratorium("Rapid Test","Rapid test hasil 2 jam setelah pengambilan darah",149000);
    public static Laboratorium SWAP_TEST = new Laboratorium("Swap Test","Swap test hasil 1 x 24 jam",500000);
}
