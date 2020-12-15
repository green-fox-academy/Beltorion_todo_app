package com.beltorion;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            ToDoAppTasks.userManual();
        } else if (args[0].equals("-l")) {
            ToDoAppTasks.listTasks();
        } else if (args[0].equals("-a") && args.length > 1) {
            ToDoAppTasks.addTask(args[1]);
        } else if (args[0].equals("-r")&& args.length > 1) {
            ToDoAppTasks.removeTask(args[1]);
        } else if (args[0].equals("-c")) {
            System.out.println("complete task");
        } else if (args.length == 1 && (args[0].equals("-r") || args[0].equals("-c") || args[0].equals("-a"))) {
            System.out.println("Please give a task or index");
        } else {
            System.out.println("not valid argument");
        }
    }

}
