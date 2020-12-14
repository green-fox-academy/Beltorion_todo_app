package com.beltorion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            ToDoAppTasks.userManual();
        } else if ((args[0].equals("-l"))) {
            ToDoAppTasks.listTasks();
        } else if ((args[0].equals("-a"))) {
            System.out.println("New task");
        } else if ((args[0].equals("-r"))) {
            System.out.println("Remove task");
        } else if ((args[0].equals("-c"))) {
            System.out.println("complete task");
        } else {
            System.out.println("not valid argument");
        }
    }


    private static void addTask(){


    }

}
