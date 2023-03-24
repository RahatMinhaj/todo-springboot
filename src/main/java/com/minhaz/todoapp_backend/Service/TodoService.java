package com.minhaz.todoapp_backend.Service;

import com.minhaz.todoapp_backend.Entity.TodoList;
import com.minhaz.todoapp_backend.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;


    public TodoList SaveData(TodoList todoList) {
        return todoRepo.save(todoList);
    }

    public List<TodoList> getList(){
        return todoRepo.findAll();
    }

    public int changeStatusByIds(List<Long> ids, String status) {
        System.out.println(ids.toString());
        return todoRepo.UpdateStatusByIds(ids, status);

    }

    public void delete(Long id){
        todoRepo.deleteById(id);
    }
}
