package ru.job4j.todo.persistence;

import ru.job4j.todo.model.Category;
import ru.job4j.todo.model.Item;
import ru.job4j.todo.model.User;

import java.util.List;

public interface Store extends AutoCloseable {

    Item addTask(Item item);

    void updateTask(int id, boolean done);

    List<Item> findAllTasks();

    List<Category> findAllCategories();

    User addUser(User user);

    User findUserByEmail(String email);

}
