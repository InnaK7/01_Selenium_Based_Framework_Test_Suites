package com.tasj.pages.gmail;


import static com.tasj.core.ConciseAPI.*;

public class Menu {

    public static void goToInbox() {
        $(byTitle("Inbox")).click();
    }

    public static void goToSent() {
        $(byText("Sent Mail")).click();
    }

    public static void refresh() {
        $(".nu").click();
    }
}
