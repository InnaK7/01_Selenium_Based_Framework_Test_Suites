package com.tasj.pages.gmail;

import static com.tasj.core.ConciseAPI.$;
import static com.tasj.core.ConciseAPI.open;

public class Gmail {

    public static void visit() {
        open("https://gmail.com");
    }

    public static void logIn(String email, String password) {
        $("#Email").setValue(email).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }

}
