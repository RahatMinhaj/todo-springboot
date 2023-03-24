package com.minhaz.todoapp_backend.Repository;

import com.minhaz.todoapp_backend.Entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoList, Long > {

    @Modifying
    @Transactional
    @Query(value = "update todo_list set status =:status where todoid in ( :ids )",nativeQuery = true)
    public int UpdateStatusByIds(@Param("ids") List<Long> ids, @Param("status") String status);
}


