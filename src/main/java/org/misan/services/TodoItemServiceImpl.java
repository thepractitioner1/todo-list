package org.misan.services;

import org.misan.model.TodoData;
import org.misan.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem todoItem) {

        data.addItem(todoItem);

    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
         data.updateItem(todoItem);
    }

    @Override
    public TodoData getData() {
        return data;
    }
}
