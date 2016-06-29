package com.tasj.pages.gmail;

import com.tasj.core.entities.ProxyCollection;
import org.openqa.selenium.By;

import static com.tasj.core.ConciseAPI.*;
import static com.tasj.core.conditions.CollectionConditions.texts;
import static com.tasj.core.conditions.ElementConditions.text;

public class Mails {

    public static ProxyCollection emails = $$(byCSS("[role='main'] .zA"));

    public static void send(String to, String emailSubject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(to).pressEnter();
        $(By.name("subjectbox")).setValue(emailSubject).pressEnter();
        $(byText("Send")).click();

    }

    public static void assertNthMail(int index, String subject) {
        emails.get(index).shouldHave(text(subject));
    }

    public static void assertMails(String... subjects) {
        emails.shouldHave(texts(subjects));
    }

    public static void searchBySubject(String subject) {
        $(By.name("q")).setValue("subject:" + subject).pressEnter();
    }
}
