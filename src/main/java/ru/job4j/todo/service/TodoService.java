package ru.job4j.todo.service;

import ru.job4j.todo.model.Category;
import ru.job4j.todo.model.Item;
import ru.job4j.todo.model.User;
import ru.job4j.todo.persistence.HbmStore;

import java.util.List;

public class TodoService {

    private static final class Lazy {
        private static final TodoService INST = new TodoService();
    }

    public static TodoService instOf() {
        return TodoService.Lazy.INST;
    }

        public void addTask(String task, String description, String email, String[] categories) {
            User user = HbmStore.instOf().findUserByEmail(email);
            Item item = Item.of(task, description, user);
            List<Category> allCategories = findAllCategories();
            for (String id : categories) {
                item.addCategory(allCategories.get(Integer.parseInt(id) - 1));
            }
            HbmStore.instOf().addTask(item);
        }

    public List<Item> findAllTasks() {
        return HbmStore.instOf().findAllTasks();
    }

    public List<Category> findAllCategories() {
        return HbmStore.instOf().findAllCategories();
    }

    public void changeTaskStatus(int id, boolean done) {
        HbmStore.instOf().updateTask(id, done);
    }
}
