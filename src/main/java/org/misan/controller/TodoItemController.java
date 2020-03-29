package org.misan.controller;

import lombok.extern.slf4j.Slf4j;
import org.misan.model.TodoData;
import org.misan.model.TodoItem;
import org.misan.services.TodoItemService;
import org.misan.utils.AttributeNames;
import org.misan.utils.Mappings;
import org.misan.utils.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    private TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }


    // ==Model Attribute ==

    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methods ==

    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {

            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoitem from = {}", todoItem);
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        }else{
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;

    }


    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.VIEW_ITEM;
    }


}
