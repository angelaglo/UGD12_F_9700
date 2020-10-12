package com.tgsbesar.myapplication.menu_rawatJalan;

import java.util.ArrayList;

public class DaftarDokter {
    public ArrayList<Dokter> DOKTER = new ArrayList<>();

    public DaftarDokter(){
        DOKTER = new ArrayList<>();
        DOKTER.add(JANTUNG1);
        DOKTER.add(JANTUNG2);
        DOKTER.add(JANTUNG3);
        DOKTER.add(NEUROLOGI1);
        DOKTER.add(NEUROLOGI2);
        DOKTER.add(NEUROLOGI3);
        DOKTER.add(ONKOLOGI1);
        DOKTER.add(ONKOLOGI2);
        DOKTER.add(ONKOLOGI3);
        DOKTER.add(PEDIATRIS1);
        DOKTER.add(PEDIATRIS2);
        DOKTER.add(PEDIATRIS3);
        DOKTER.add(KULIT1);
        DOKTER.add(KULIT2);
        DOKTER.add(KULIT3);
        DOKTER.add(UMUM1);
        DOKTER.add(UMUM2);
        DOKTER.add(UMUM3);

    }

    public static final Dokter JANTUNG1 = new Dokter("Dr Erick Caesarrani","Spesialis Jantung");
    public static final Dokter JANTUNG2 = new Dokter("Dr Abadi Aman","Spesialis Jantung");
    public static final Dokter JANTUNG3 = new Dokter("Dr Abdul Muchit","Spesialis Jantung");

    public static final Dokter NEUROLOGI1 = new Dokter("Dr Indrawarman","Spesialis Neurologi");
    public static final Dokter NEUROLOGI2 = new Dokter("Dr Adi Syahputra","Spesialis Neurologi");
    public static final Dokter NEUROLOGI3 = new Dokter("Dr Ida Puspitasari","Spesialis Neurologi");

    public static final Dokter ONKOLOGI1 = new Dokter("Dr Agus Supriyadi","Spesialis Onkologi");
    public static final Dokter ONKOLOGI2 = new Dokter("Dr Adi Kristanto","Spesialis Onkologi");
    public static final Dokter ONKOLOGI3 = new Dokter("Dr Alberta Anindya","Spesialis Onkologi");

    public static final Dokter PEDIATRIS1 = new Dokter("Dr Amelia Puspita","Spesialis Pediatris");
    public static final Dokter PEDIATRIS2 = new Dokter("Dr Andreas Prasadja","Spesialis Pediatris");
    public static final Dokter PEDIATRIS3 = new Dokter("Dr Anastasia Melinda","Spesialis Pediatris");

    public static final Dokter KULIT1 = new Dokter("Dr Annisa Oktantiani","Spesialis Kulit");
    public static final Dokter KULIT2 = new Dokter("Dr Maulana Agies","Spesialis Kulit");
    public static final Dokter KULIT3 = new Dokter("Dr Yuda Pratama","Spesialis Kulit");

    public static final Dokter UMUM1 = new Dokter("Dr Bona Adhista","Umum");
    public static final Dokter UMUM2 = new Dokter("Dr Catherine Meryani","Umum");
    public static final Dokter UMUM3 = new Dokter("Dr Devi Rahmawati","Umum");
}
