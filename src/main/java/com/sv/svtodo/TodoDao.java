package com.sv.svtodo;

import java.sql.SQLException;
import java.util.List;

public interface TodoDao {

    void insertTodo(Todo todo) throws SQLException;

    Todo selectTodo(int todoId);

    List<Todo> selectAllTodos();

    void deleteTodo(int id) throws SQLException;

    void updateTodo(Todo todo) throws SQLException;

    boolean authorization(String username, String password) throws SQLException;

}
