package com.tgsbesar.myapplication.model;

import java.io.Serializable;

public class Laboratorium implements Serializable {


    public String kategori;
    public String deskripsi;
    public double harga_test;


    public Laboratorium(String kategori, String deskripsi, double harga_test){
        this.kategori=kategori;
        this.deskripsi=deskripsi;
        this.harga_test=harga_test;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getHarga_test() {
        return harga_test;
    }

    public void setHarga_test(double harga_test) {
        this.harga_test = harga_test;
    }
}
