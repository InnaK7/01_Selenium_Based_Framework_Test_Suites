package com.tasj.todomvc;

import com.tasj.pages.todomvc.PreconditionBuilder.TaskType;
import com.tasj.testconfigs.BaseTest;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.tasj.pages.todomvc.PreconditionBuilder.aTask;
import static com.tasj.pages.todomvc.PreconditionBuilder.givenAtActive;
import static com.tasj.pages.todomvc.TodoMVC.*;

public class OperationsAtActiveTest extends BaseTest {

    @Test
    public void testAddAtActive() {
        givenAtActive(TaskType.ACTIVE, "a");

        add("b");
        assertVisibleTasks("a", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testDeleteAtActive() {
        givenAtActive(TaskType.ACTIVE, "a", "b");

        delete("a");
        assertVisibleTasks("b");
    }

    @Test
    public void testCompleteAllAtActive() {
        givenAtActive(TaskType.ACTIVE, "a", "b");

        toggleAll();
        assertNoVisibleTasks();
        assertItemsLeft(0);
    }

    @Test
    public void testClearCompletedAtActive() {
        givenAtActive(
                aTask("a", TaskType.ACTIVE),
                aTask("b", TaskType.COMPLETED));

        clearCompleted();
        assertVisibleTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testReopenAllAtActive() {
        givenAtActive(
                aTask("a", TaskType.COMPLETED),
                aTask("b", TaskType.COMPLETED));


        toggleAll();
        assertVisibleTasks("a", "b");
        assertItemsLeft(2);
    }

    //Additional Edit Operations
    @Test
    public void testCancelEditAtActive() {
        givenAtActive(TaskType.ACTIVE, "a");

        startEditing("a", "a edited").sendKeys(Keys.ESCAPE);
        assertVisibleTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testConfirmEditWithTabAtActive() {
        givenAtActive(TaskType.ACTIVE, "a", "b");

        startEditing("a", "a edited").sendKeys(Keys.TAB);
        assertVisibleTasks("a edited", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testConfirmEditClickOutsideAtActive() {
        givenAtActive(TaskType.ACTIVE, "a", "b");

        startEditing("a", "a edited");
        newTask.click();
        assertVisibleTasks("a edited", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testDeleteClearNameAtActive() {
        givenAtActive(TaskType.ACTIVE, "a", "b");

        startEditing("a", "").sendKeys(Keys.ENTER);
        assertVisibleTasks("b");
        assertItemsLeft(1);
    }
}
