package ru.job4j.todo.service;

import ru.job4j.todo.model.Item;
import ru.job4j.todo.model.User;
import ru.job4j.todo.persistence.HbmStore;

import java.util.List;

public class TodoService {

    private static final class Lazy {
        private static final TodoService INST = new TodoService();
    }

    public static TodoService instOf() {
        return Lazy.INST;
    }

    public void addTask(String task, String description, String email) {
        User user = HbmStore.instOf().findUserByEmail(email);
        Item item = Item.of(task, description, user);
        HbmStore.instOf().addTask(item);
    }

    public List<Item> findAllTasks() {
        return HbmStore.instOf().findAllTasks();
    }

    public void changeTaskStatus(int id, boolean done) {
        HbmStore.instOf().updateTask(id, done);
    }
}
