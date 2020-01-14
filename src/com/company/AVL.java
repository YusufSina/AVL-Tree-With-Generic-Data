package com.company;


public class AVL<T extends Comparable<T>> {
    Dugum<T> root;
    private int size = 0;

    private Dugum<T> add(Dugum<T> altDugum, Dugum<T> yeni) {
        if (altDugum == null) {
            altDugum = yeni;
            setSize(1);
        } else if (yeni.veri.compareTo(altDugum.veri) < 0) { // yeni.veri < altDugum.veri
            altDugum.sol = add(altDugum.sol, yeni);

            if (yukseklik(altDugum.sol) - yukseklik(altDugum.sag) == 2) { // denge bozuldu mu?
                if (yeni.veri.compareTo(altDugum.sol.veri) < 0) { //sol-sol dengesizliği mi var?
                    altDugum = solCocukileDegistir(altDugum);
                } else { // sol-sağ dengesizliği var
                    altDugum.sol = sagCocukileDegistir(altDugum.sol);
                    altDugum = solCocukileDegistir(altDugum);
                }
            }
        } else if (yeni.veri.compareTo(altDugum.veri) > 0) { // yeni.veri > altDugum.veri
            altDugum.sag = add(altDugum.sag, yeni);

            if (yukseklik(altDugum.sag) - yukseklik(altDugum.sol) == 2) { // denge bozuldu mu ?
                if (yeni.veri.compareTo(altDugum.sag.veri) > 0) { // sağ-sağ dengesizliği mi var?
                    altDugum = sagCocukileDegistir(altDugum);
                } else { //sağ-sol dengesizliği mi var?
                    altDugum.sag = solCocukileDegistir(altDugum.sag);
                    altDugum = sagCocukileDegistir(altDugum);
                }
            }
        } else return altDugum;

        altDugum.yukseklik = yukseklik(altDugum);
        return altDugum;
    }

    private Dugum<T> solCocukileDegistir(Dugum<T> altDugum) {
        Dugum<T> tmp = altDugum.sol;
        altDugum.sol = tmp.sag;
        tmp.sag = altDugum;

        //Yükseklik
        altDugum.yukseklik = yukseklik(altDugum);
        tmp.yukseklik = 1 + Math.max(yukseklik(tmp.sol), yukseklik(tmp.sag));
        return tmp;
    }

    private Dugum<T> sagCocukileDegistir(Dugum<T> altDugum) {
        Dugum<T> tmp = altDugum.sag;
        altDugum.sag = tmp.sol;
        tmp.sol = altDugum;

        //Yükseklik
        altDugum.yukseklik = yukseklik(altDugum);
        tmp.yukseklik = 1 + Math.max(yukseklik(tmp.sol), yukseklik(tmp.sag));
        return tmp;
    }
    // yükseklik hesaplar
    private int yukseklik(Dugum<T> altDugum) {
        if (altDugum == null) return -1;
        return 1 + Math.max(yukseklik(altDugum.sol), yukseklik(altDugum.sag));
    }
    // levele göre yazdırır
    private void levelOrder(Dugum<T> altDugum, int level) {
        if (altDugum == null) return;
        if (level == 0) System.out.print(altDugum.veri + " ");
        levelOrder(altDugum.sol, level - 1);
        levelOrder(altDugum.sag, level - 1);
    }
    // küçükten büyüğe yazdırır.
    private void ascending(Dugum<T> altDugum){
        if(altDugum == null) return;
        ascending(altDugum.sol);
        System.out.print(altDugum.veri + " ");
        ascending(altDugum.sag);
    }
    // büyükten küçüğe yazdırır
    private void descending(Dugum<T> altDugum){
        if(altDugum == null) return;
        descending(altDugum.sag);
        System.out.print(altDugum.veri + " ");
        descending(altDugum.sol);
    }
    // giriliş sırasına göre yazdırır.
    private void searchingByGirilisNumarasi(Dugum<T> altDugum, int sira){
        if(altDugum == null) return;
        if(altDugum.girilisSirasi == sira) System.out.print(altDugum.veri + " ");
        searchingByGirilisNumarasi(altDugum.sol, sira);
        searchingByGirilisNumarasi(altDugum.sag, sira);
    }

    private int setSize(int boyut){
        size += boyut;
        return size;
    }

    public void add(T veri, int sira) {
        Dugum<T> yeni = new Dugum<>(veri, sira);
        root = add(root, yeni);
    }

    public int yukseklik() {
        return yukseklik(root);
    }

    public void levelOrder() {
        int h = yukseklik(root);
        System.out.print("Level order : ");
        for (int i = 0; i <= h; i++) {
            levelOrder(root, i);
        }
        System.out.println();
    }

    public void ascending(){
        System.out.print("Küçükten büyüğe sıralama : ");
        ascending(root);
        System.out.println();
    }
    public void descending(){
        System.out.print("Büyükten küçüğe sıralama : ");
        descending(root);
        System.out.println();
    }

    public void searchingByGirilisSirasi(int sayiAdedi){
        System.out.print("Giriliş sırasına göre : ");
        for(int i = 0; i < sayiAdedi; i++){
            searchingByGirilisNumarasi(root, i);
        }
        System.out.println();
    }

    public int getSize(){
        return size;
    }
}
