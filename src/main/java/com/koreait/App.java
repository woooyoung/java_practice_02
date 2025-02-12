package com.koreait;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private TodoController todoController;

    public App() {
        sc = new Scanner(System.in);
        todoController = new TodoController();
    }

    public void run() {
        System.out.println("TodoApp 시작");

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) break;
            else if (cmd.equals("add")) {
                todoController.add();
            } else if (cmd.equals("list")) {
                todoController.list();
            } else if (cmd.equals("del")) {
                todoController.del();
            } else if (cmd.equals("modify")) {
                todoController.modify();
            }
        }
        System.out.println("TodoApp 끝");
        sc.close();
    }


}
