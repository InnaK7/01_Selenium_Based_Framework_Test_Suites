package com.tasj.todomvc;

import com.tasj.pages.todomvc.PreconditionBuilder.TaskType;
import com.tasj.testconfigs.BaseTest;
import org.junit.Test;

import static com.tasj.pages.todomvc.PreconditionBuilder.aTask;
import static com.tasj.pages.todomvc.PreconditionBuilder.givenAtAll;
import static com.tasj.pages.todomvc.TodoMVC.*;


public class OperationsAtAllTest extends BaseTest {


    @Test
    public void testEditAtAll() {
        givenAtAll(TaskType.ACTIVE, "a");

        startEditing("a", "a edited").pressEnter();
        assertTasks("a edited");
        assertItemsLeft(1);
    }

    @Test
    public void testCompleteAllAtAll() {
        givenAtAll(TaskType.ACTIVE, "a", "b");

        toggleAll();
        assertTasks("a", "b");
        assertItemsLeft(0);
    }

    @Test
    public void testClearCompletedAtAll() {
        givenAtAll(
                aTask("a", TaskType.ACTIVE),
                aTask("b", TaskType.COMPLETED),
                aTask("c", TaskType.COMPLETED));

        clearCompleted();
        assertTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testReopenAtAll() {
        givenAtAll(TaskType.COMPLETED, "a");

        toggle("a");
        assertTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testReopenAllAtAll() {
        givenAtAll(TaskType.COMPLETED, "a", "b");

        toggleAll();
        assertTasks("a", "b");
        assertItemsLeft(2);
    }

    //Additional Edit Operations
    @Test
    public void testCancelEditAtAll() {
        givenAtAll(TaskType.ACTIVE, "a", "b");

        startEditing("a", "a edited").pressEsc();
        assertTasks("a", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testConfirmEditWithTabAtAll() {
        givenAtAll(
                aTask("a", TaskType.ACTIVE),
                aTask("b", TaskType.COMPLETED));

        startEditing("a", "a edited").pressTab();
        assertTasks("a edited", "b");
        assertItemsLeft(1);
    }

    @Test
    public void testConfirmEditClickOutsideAtAll() {
        givenAtAll(TaskType.ACTIVE, "a");

        startEditing("a", "a edited");
        newTask.click();
        assertTasks("a edited");
        assertItemsLeft(1);
    }

    @Test
    public void testDeleteClearNameAtAll() {
        givenAtAll(TaskType.ACTIVE, "a");

        startEditing("a", "").pressEnter();
        assertNoTasks();
    }


}
