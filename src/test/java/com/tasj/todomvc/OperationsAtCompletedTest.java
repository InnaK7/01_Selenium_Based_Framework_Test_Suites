package com.tasj.todomvc;

import com.tasj.pages.todomvc.PreconditionBuilder.TaskType;
import com.tasj.testconfigs.BaseTest;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.tasj.pages.todomvc.PreconditionBuilder.aTask;
import static com.tasj.pages.todomvc.PreconditionBuilder.givenAtCompleted;
import static com.tasj.pages.todomvc.TodoMVC.*;

public class OperationsAtCompletedTest extends BaseTest {


    @Test
    public void testAddAtCompleted() {
        givenAtCompleted(
                aTask("a", TaskType.ACTIVE));

        add("b");
        assertNoVisibleTasks();
        assertItemsLeft(2);
    }

    @Test
    public void testEditAtCompleted() {
        givenAtCompleted(
                aTask("a", TaskType.COMPLETED),
                aTask("b", TaskType.ACTIVE));

        startEditing("a", "a edited").sendKeys(Keys.ENTER);
        assertVisibleTasks("a edited");
        assertItemsLeft(1);
    }

    @Test
    public void testDeleteAtCompleted() {
        givenAtCompleted(
                aTask("a", TaskType.COMPLETED));

        delete("a");
        assertNoVisibleTasks();
    }

    @Test
    public void testCompleteAllAtCompleted() {
        givenAtCompleted(
                aTask("a", TaskType.ACTIVE),
                aTask("b", TaskType.ACTIVE),
                aTask("c", TaskType.COMPLETED));

        toggleAll();
        assertVisibleTasks("a", "b", "c");
        assertItemsLeft(0);
    }

    @Test
    public void testClearCompletedAtCompleted() {
        givenAtCompleted(
                aTask("a", TaskType.COMPLETED),
                aTask("b", TaskType.COMPLETED));

        clearCompleted();
        assertNoVisibleTasks();
    }

    @Test
    public void testReopenAllAtCompleted() {
        givenAtCompleted(
                aTask("b", TaskType.COMPLETED),
                aTask("c", TaskType.COMPLETED));

        toggleAll();
        assertNoVisibleTasks();
        assertItemsLeft(2);
    }

    //Additional Edit Operations
    @Test
    public void testCancelEditAtCompleted() {
        givenAtCompleted(
                aTask("a", TaskType.COMPLETED));

        startEditing("a", "a edited").sendKeys(Keys.ESCAPE);
        assertVisibleTasks("a");
        assertItemsLeft(0);
    }

    @Test
    public void testConfirmEditWithTabAtCompleted() {
        givenAtCompleted(
                aTask("a", TaskType.COMPLETED));

        startEditing("a", "a edited").sendKeys(Keys.TAB);
        assertVisibleTasks("a edited");
        assertItemsLeft(0);
    }

    @Test
    public void testConfirmEditClickOutsideAtCompleted() {
        givenAtCompleted(
                aTask("a", TaskType.COMPLETED),
                aTask("b", TaskType.ACTIVE));

        startEditing("a", "a edited");
        newTask.click();
        assertVisibleTasks("a edited");
        assertItemsLeft(1);
    }

    @Test
    public void testDeleteClearNameAtCompleted() {
        givenAtCompleted(
                aTask("a", TaskType.COMPLETED),
                aTask("b", TaskType.ACTIVE));

        startEditing("a", "").sendKeys(Keys.ENTER);
        assertNoVisibleTasks();
        assertItemsLeft(1);
    }
}
