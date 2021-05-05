package com.ddd.dddstart.common.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class EmailConverter implements AttributeConverter<EmailSet, String> {

    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
        if (attribute == null)
        {
            return null;
        }
        return attribute.getEmails().stream()
                .map(Email::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
        if (dbData == null)
        {return null;}
        String [] emails = dbData.split(",");
        Set<Email> emailSet = Arrays.stream(emails)
                .map(Email::new)
                .collect(Collectors.toSet());

        return new EmailSet(emailSet);
    }
}
