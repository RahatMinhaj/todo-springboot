package com.minhaz.todoapp_backend.Controller;

import com.minhaz.todoapp_backend.DTM.DeleteMessage;
import com.minhaz.todoapp_backend.Entity.TodoList;
import com.minhaz.todoapp_backend.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
@RequestMapping("/todoapp")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @PostMapping("/create")
    public TodoList create(@RequestBody TodoList todoList){
        return todoService.SaveData(todoList);
    }

   @GetMapping("/list")
   public List<TodoList> getList(){
        return todoService.getList();
   }

   @GetMapping("/statuschange/updateall")
    public void statusChange(@RequestParam(value = "ids") List<Long> ids, @RequestParam(value = "status") String status){
       System.out.println(ids.toString());
       System.out.println(status);
       todoService.changeStatusByIds(ids, status);
   }

   @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<DeleteMessage> deteteById(@PathVariable("id") Long id){

       try {
           todoService.delete(id);
           System.out.println(id);
           return new ResponseEntity<>(new DeleteMessage("Data Deleted, Message From SpringBoot!"), HttpStatus.OK);
       } catch (Exception e) {
//            System.out.println("Generating erro");
           return new ResponseEntity<>(new DeleteMessage("Data is not Deleted!, Message From SpringBoot! "), HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

}
