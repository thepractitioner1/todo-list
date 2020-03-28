package org.misan.services;

import org.misan.model.TodoData;
import org.misan.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem todoItem);
    void removeItem(int id);
    TodoItem getItem(int id);
    void updateItem(TodoItem todoItem);
    TodoData getData();

}
