package com.tasj.gmail;

import com.tasj.core.Configuration;
import com.tasj.pages.gmail.Gmail;
import com.tasj.pages.gmail.Mails;
import com.tasj.pages.gmail.Menu;
import com.tasj.testconfigs.BaseTest;
import com.tasj.testdata.TestData;
import org.junit.Test;

import java.time.LocalTime;

public class GmailTest extends BaseTest {

    static {
        Configuration.timeout = 15000;
    }

    @Test
    public void testLoginAndSendSearchEmail() {

        Gmail.visit();
        Gmail.logIn(TestData.EMAIL, TestData.PASSWORD);

        String subject = "test" + LocalTime.now();
        Mails.send(TestData.EMAIL, subject);
        Menu.refresh();
        Mails.assertNthMail(0, subject);

        Menu.goToSent();
        Mails.assertNthMail(0, subject);

        Menu.goToInbox();
        Mails.searchBySubject(subject);
        Mails.assertMails(subject);
    }
}
