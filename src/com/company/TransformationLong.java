package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformationLong extends TransformationTemplate {
    private Object deger;
    private final String regex = "^(\\+|\\-)?\\d*\\d+$";
    private final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

    public TransformationLong() {
        deger = null;
    }

    @Override
    public Object convert(Object deger) {
        Matcher matcher = pattern.matcher((String) deger);

        matcher.find();

        deger = Long.valueOf(matcher.group(0));


        return deger;
    }
}
