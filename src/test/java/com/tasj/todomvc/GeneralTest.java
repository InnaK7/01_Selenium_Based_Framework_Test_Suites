package com.tasj.todomvc;

import com.tasj.testconfigs.BaseTest;
import org.junit.Test;

import static com.tasj.pages.todomvc.PreconditionBuilder.*;
import static com.tasj.pages.todomvc.TodoMVC.*;

public class GeneralTest extends BaseTest {

    @Test
    public void testTasksLifeCycle() {

        givenAtAll();
        add("a");
        toggle("a");

        filterActive();
        assertItemsLeft(0);
        assertNoVisibleTasks();

        filterCompleted();
        toggle("a");
        assertNoVisibleTasks();

        filterActive();
        startEditing("a", "a edited").pressEnter();
        toggle("a edited");
        assertNoVisibleTasks();

        filterAll();
        delete("a edited");
        assertNoTasks();
    }

    @Test
    public void testFilteringFromCompletedToAll() {
        givenAtCompleted(
                aTask("a", TaskType.COMPLETED),
                aTask("b", TaskType.ACTIVE));

        filterAll();
        assertTasks("a", "b");
        assertItemsLeft(1);
    }

    @Test
    public void testFilteringFromAllToCompleted() {
        givenAtAll(
                aTask("a", TaskType.COMPLETED),
                aTask("b", TaskType.ACTIVE));

        filterCompleted();
        assertVisibleTasks("a");
        assertItemsLeft(1);
    }
}
