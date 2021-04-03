package com.example.cobaspeech;

public class ContactListModel {
    private String nama;
    private String notelp;
    public ContactListModel(String nama, String notelp) {
        this.nama = nama;
        this.notelp = notelp;
    }
    public String getNama() {
        return nama;
    }
    public String getNotelp() {
        return notelp;
    }
}
