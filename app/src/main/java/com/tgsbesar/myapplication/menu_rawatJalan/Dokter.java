package com.tgsbesar.myapplication.menu_rawatJalan;

import java.io.Serializable;

public class Dokter implements Serializable {
    public String nama;
    public String jabatan;

    public Dokter(String nama, String jabatan) {
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) { this.nama = nama; }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String namaspes) { this.jabatan = jabatan; }
}
