package com.company;

public class TransformationString extends TransformationTemplate {
    @Override
    public Object convert(Object deger) {
        //Alınan obje zaten string tir.
        return deger;
    }
}
