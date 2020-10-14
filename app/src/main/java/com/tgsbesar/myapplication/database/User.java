package com.tgsbesar.myapplication.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "noRM")
    public String noRM;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "full_name")
    public String fullname;

    @ColumnInfo(name = "umur")
    public String umur;

    @ColumnInfo(name = "jeniskelamin")
    public String jeniskelamin;

    @ColumnInfo(name = "nohp")
    public String nohp;

    @ColumnInfo(name = "alamat")
    public String alamat;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNoRM() {return noRM;}

    public void setNoRM(String noRM) {this.noRM=noRM;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password=password;}

    public String getFullname() { return fullname; }

    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getUmur() { return umur; }

    public void setUmur(String umur){ this.umur = this.umur; }

    public String getJeniskelamin() { return jeniskelamin; }

    public void setJeniskelamin(String jeniskelamin) {this.jeniskelamin = jeniskelamin;}

    public String getNohp() { return nohp; }

    public void setNohp(String nohp) {this.nohp = nohp;}

    public String getAlamat() { return alamat; }

    public void setAlamat(String alamat) {this.alamat=alamat;}
}