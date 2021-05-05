package com.ddd.dddstart.common.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EmailSet {
    private Set<Email> emailSet = new HashSet<>();

    private EmailSet(){}

    public EmailSet(Set<Email> emailSet)
    {
        this.emailSet.addAll(emailSet);
    }

    public Set<Email> getEmails()
    {
        return Collections.unmodifiableSet(emailSet);
    }
}
