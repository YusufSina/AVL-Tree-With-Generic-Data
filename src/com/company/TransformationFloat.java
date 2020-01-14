package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TransformationFloat extends TransformationTemplate {
    private Object deger;
    private final String regex = "^(\\+|\\-)?\\d+[.]\\d+f$"; // ^(+|-)?\d+[.]\d+[f]$ tarzında sayıları ekler.
    private final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

    public TransformationFloat() {
        deger = null;
    }

    @Override
    public Object convert(Object deger) {
        Matcher matcher = pattern.matcher((String) deger);

        matcher.find();
        deger = Float.valueOf(matcher.group(0));


        return deger;

    }
}
