package com.company;

import java.util.Arrays;

public class JsonDecipherer {
    private Task[] tasks;

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "JsonDecipherer{" +
                "tasks=" + Arrays.toString(tasks) +
                '}';
    }
}
