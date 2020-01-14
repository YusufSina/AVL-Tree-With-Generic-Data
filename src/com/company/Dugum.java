package com.company;

public class Dugum<T> {
    T veri; // String, Double, Integer Float vb. değerleri tutmak için
    int girilisSirasi; // hangi sırada giriş yapıldığını saklamak için
    Dugum<T> sol;
    Dugum <T> sag;
    int yukseklik;

    public Dugum(T veri, int girilisSirasi)
    {
        this.veri = veri;
        this.girilisSirasi = girilisSirasi;
        yukseklik = 0;
    }
}
