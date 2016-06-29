package com.tasj.pages.todomvc;

import static com.tasj.core.ConciseAPI.*;
import static com.tasj.pages.todomvc.TodoMVC.filterActive;
import static com.tasj.pages.todomvc.TodoMVC.filterCompleted;

public class PreconditionBuilder {

    public static class Task {

        public TaskType taskType;
        public String taskText;

        public Task(String taskText, TaskType taskType) {
            this.taskText = taskText;
            this.taskType = taskType;
        }
    }

    public static Task aTask(String taskText, TaskType taskType) {
        return new Task(taskText, taskType);
    }

    public enum TaskType {
        ACTIVE("false"), COMPLETED("true");

        public String flag;

        TaskType(String flag) {
            this.flag = flag;
        }

        public String getFlag() {
            return flag;
        }
    }

    public static void ensurePageOpenedAndSetUpData(StringBuilder jsCommand) {

        if (!getDriver().getCurrentUrl().equals("https://todomvc4tasj.herokuapp.com/")) {
            open("https://todomvc4tasj.herokuapp.com/");
        }
        executeJavaScript(jsCommand.toString());
        refresh();
    }

    public static StringBuilder createJSCommandString(Task... todos) {

        StringBuilder jsCommand = new StringBuilder();
        jsCommand.append("localStorage.setItem(\"todos-troopjs\", \"[");
        for (Task todo : todos) {
            jsCommand.append("{\\\"completed\\\":").append(todo.taskType.getFlag()).append(", \\\"title\\\":\\\"").append(todo.taskText).append("\\\"}, ");
        }
        if (todos.length != 0) {
            jsCommand.deleteCharAt(jsCommand.length() - 2);
        }
        jsCommand.append("]\")");

        return jsCommand;
    }

    public static Task[] convertToTaskArray(TaskType taskType, String... taskText) {
        Task[] todos = new Task[taskText.length];
        for (int i = 0; i < taskText.length; i++) {
            todos[i] = aTask(taskText[i], taskType);
        }
        return todos;
    }

    public static void givenHelper(Task... todos) {

        ensurePageOpenedAndSetUpData(createJSCommandString(todos));
    }

    public static void givenAtAll(Task... todos) {
        givenHelper(todos);
    }

    public static void givenAtAll(TaskType taskType, String... taskText) {
        givenHelper(convertToTaskArray(taskType, taskText));
    }

    public static void givenAtActive(Task... todos) {
        givenHelper(todos);
        filterActive();
    }

    public static void givenAtActive(TaskType taskType, String... taskText) {
        givenHelper(convertToTaskArray(taskType, taskText));
        filterActive();
    }

    public static void givenAtCompleted(Task... todos) {
        givenHelper(todos);
        filterCompleted();
    }
}
