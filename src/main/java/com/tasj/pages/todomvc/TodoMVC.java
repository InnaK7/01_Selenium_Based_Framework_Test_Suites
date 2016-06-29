package com.tasj.pages.todomvc;

import com.tasj.core.entities.ProxyCollection;
import com.tasj.core.entities.ProxyElement;
import org.openqa.selenium.By;

import static com.tasj.core.ConciseAPI.*;
import static com.tasj.core.conditions.CollectionConditions.empty;
import static com.tasj.core.conditions.CollectionConditions.exactTexts;
import static com.tasj.core.conditions.ElementConditions.*;

public class TodoMVC {

    public static ProxyElement newTask = $("#new-todo");
    public static ProxyCollection tasks = $$(byCSS("#todo-list>li"));

    public static void add(String... taskTexts) {
        for (String text : taskTexts) {
            newTask.setValue(text).pressEnter();
        }
    }

    public static ProxyElement startEditing(String oldTaskText, String newTaskText) {
        tasks.find(exactText(oldTaskText)).find("label").doubleClick();
        return tasks.find(cssClass("editing")).$(".edit").setValue(newTaskText);
    }

    public static void delete(String taskText) {
        tasks.find(exactText(taskText)).hover().$(".destroy").click();
    }

    public static void toggle(String taskText) {
        tasks.find(exactText(taskText)).$(".toggle").click();
    }

    public static void toggleAll() {
        $("#toggle-all").click();
    }

    public static void clearCompleted() {
        $("#clear-completed").click();
    }

    public static void filterAll() {
        $(By.linkText("All")).click();
    }

    public static void filterActive() {
        $(By.linkText("Active")).click();
    }

    public static void filterCompleted() {
        $(By.linkText("Completed")).click();
    }

    //asserts
    public static void assertTasks(String... taskTexts) {
        tasks.shouldHave(exactTexts(taskTexts));
    }

    public static void assertNoTasks() {
        tasks.shouldBe(empty());
    }

    public static void assertVisibleTasks(String... taskTexts) {
        tasks.filter(visible()).shouldHave(exactTexts(taskTexts));
    }

    public static void assertNoVisibleTasks() {
        tasks.filter(visible()).shouldBe(empty());
    }

    public static void assertItemsLeft(int count) {
        $(byCSS("#todo-count>strong")).shouldHave(exactText(Integer.toString(count)));
    }

}
