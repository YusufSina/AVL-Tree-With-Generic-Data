package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformationDouble extends TransformationTemplate {
    private Object deger;
    private final String regex = "^(\\+|\\-)?[\\d]{1,9}[.][\\d]+$"; // ^(+|-)?\d{1,9}[.]\d+$ tarzında sayıları ekler.
    private final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

    public TransformationDouble() {
        deger = null;
    }

    @Override
    public Object convert(Object deger) {
        Matcher matcher = pattern.matcher((String) deger);

        matcher.find();

        deger = Double.valueOf(matcher.group(0));



        return deger;
    }
}
