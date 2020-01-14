package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformationDate extends TransformationTemplate {
    private Object deger;
    private final String regex = "^\\d{2}[.]\\d{2}[.]\\d{4}$"; // sadece dd.MM.yyyy türünden veri dönüşümü yapabilir.
    private final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public TransformationDate(){
        deger = null;
    }

    @Override
    public Object convert(Object deger) throws ParseException {
        Matcher matcher = pattern.matcher((String)deger);

        matcher.find();

            deger = sdf.parse(matcher.group(0));

        return deger;

    }
}
