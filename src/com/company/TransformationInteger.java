package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformationInteger extends TransformationTemplate {
    private Object deger;
    private final String regex = "^(\\+|\\-)?[\\d]{1,9}$"; ; // ^(+|-)?\d{1,9}$ tarzında sayıları alır
    private final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

    public TransformationInteger() {
        deger = null;
    }

    @Override
    public Object convert(Object deger) {
        Matcher matcher = pattern.matcher((String) deger);

        matcher.find();

        deger = Integer.valueOf(matcher.group(0));



        return deger;
    }
}
