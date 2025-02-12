package com.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoController {

    private List<Todo> todos;
    private long lastTodoId;
    private Scanner sc = new Scanner(System.in);

    public TodoController(){
        todos = new ArrayList<>();
        lastTodoId = 0;
    }

    public void add() {
        long id = lastTodoId + 1;
        System.out.print("할 일 : ");
        String content = sc.nextLine().trim();

        Todo todo = new Todo(id, content);
        todos.add(todo);
        lastTodoId++;

        System.out.printf("%d번 todo 생성\n", id);
    }

    public void list() {
        System.out.println("번호    /    내용");

        todos.forEach(todo -> System.out.printf("%d    /    %s\n", todo.getId(), todo.getContent()));
    }

    public void del() {
        System.out.print("삭제할 todo 번호 : ");
        long id = Long.parseLong(sc.nextLine().trim());

        boolean isRemoved = todos.removeIf(todo -> todo.getId() == id);

        if (!isRemoved) {
            System.out.printf("%d번 할 일은 없어\n", id);
            return;
        }

        System.out.printf("%d번 할일이 삭제 됨\n", id);
    }

    public void modify() {
        System.out.print("수정할 todo 번호 : ");
        long id = Long.parseLong(sc.nextLine().trim());

        Todo foundTodo = todos.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (foundTodo == null) {
            System.out.printf("%d번 할 일은 없어\n", id);
            return;
        }

        System.out.printf("기존 할 일 : %s\n", foundTodo.getContent());
        System.out.printf("새 할일 : ");
        foundTodo.setContent(sc.nextLine().trim());

        System.out.printf("%d번 할일이 수정 됨\n", id);
    }
}
