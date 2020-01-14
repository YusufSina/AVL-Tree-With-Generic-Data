package com.company;

import javax.xml.crypto.dsig.TransformService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        AVL[] avlList = new AVL[]{
            new AVL<Integer>(), new AVL<Double>(), new AVL<Float>(), new AVL<Long>(),
                    new AVL<Date>(), new AVL<String>()
        };
        TransformationTemplate[] transformationList = new TransformationTemplate[]{
            new TransformationInteger(), new TransformationDouble(), new TransformationFloat(),
                    new TransformationLong(), new TransformationDate(), new TransformationString()

        } ;
        Scanner scanner = new Scanner(System.in);
        String oku;
        do {
            System.out.println("Veri ekleyiniz : ");
            oku = scanner.next();
            for (int i = 0; i < 10; i++) {

                System.out.println();
            }

            for (int i = 0; i < transformationList.length; i++) {
                try {
                     // veri türü değiştirilir.
                    avlList[i].add((Comparable)transformationList[i].convert(oku), avlList[i].getSize());
                } catch (Exception e) {
                    continue; // eğer regex veya parse hatası verirse veri yapısı ile tür yapısı uyuşmuyordur.
                }
                // veri türü eklenir.
                break; //ekleme yapıldı diğer ağaçları gezme.
            }

            for(int i = 0; i < avlList.length; i++){
                avlList[i].levelOrder();
            }
        } while (true);
    }
}