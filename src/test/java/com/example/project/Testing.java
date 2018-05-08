package com.example.project;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import nl.hu.sie.bep.friendspammer.EmailDTO;
import nl.hu.sie.bep.friendspammer.MongoSaver;
import org.junit.Test;

import java.util.ArrayList;

public class Testing {

    @Test
    public void test_fail() {
        System.out.println("Let's test the failing unit test");
    }

    @Test
    public void test_getAllEmails() {
        ArrayList<EmailDTO> allEmails = MongoSaver.getAllEmails();
        assertThat(allEmails.size(), is(not(0)));
    }
}