package com.beltorion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ToDoAppTasks {
    private static final Path TODOLIST_TXT = Paths.get("G:\\GreenFox\\Beltorion\\Beltorion_todo_app\\src\\com\\beltorion\\todolist.txt");

    static void listTasks() {
        try {
            List<String> lines = Files.readAllLines(TODOLIST_TXT);
            if (lines.isEmpty()) {
                System.out.println("Nincs mára tennivalód! :)");
            } else {
                int lineNumber = 1;
                for (String line : lines) {
                    System.out.println(lineNumber + ". " + line);
                    lineNumber++;
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to read file: todolist.txt");
        }
    }

    static void addTask(String args) {
        try {
            List<String> lines = Files.readAllLines(TODOLIST_TXT);
            lines.add("[ ] " + args);
            Files.write(TODOLIST_TXT, lines);

            System.out.println("Task has been added to your list");
        } catch (Exception e) {
            System.out.println("Could not write the file!");
        }
    }

    static void removeTask(String args) {
        try {
            List<String> lines = Files.readAllLines(TODOLIST_TXT);
            lines.remove(Integer.parseInt(args) - 1);
            Files.write(TODOLIST_TXT, lines);
        } catch (IOException e) {
            System.out.println("Unable to read file: todolist.txt");
        }
    }

    static void completeTask(String args) {
        try {
            List<String> lines = Files.readAllLines(TODOLIST_TXT);
            String taskDone = lines.get(Integer.parseInt(args) - 1);
            taskDone = taskDone.replace("[ ] ", "[X] ");
            lines.remove(Integer.parseInt(args) - 1);
            lines.add(Integer.parseInt(args) - 1, taskDone);
            Files.write(TODOLIST_TXT, lines);
        } catch (IOException e) {
            System.out.println("Unable to read file: todolist.txt");
        }
    }

    static void userManual() {
        System.out.println("\nParancssori Todo applikáció\n" +
                "=============================\n" +
                "\n" +
                "Parancssori argumentumok:\n" +
                "    -l   Kilistázza a feladatokat\n" +
                "    -a   Új feladatot ad hozzá\n" +
                "    -r   Eltávolít egy feladatot\n" +
                "    -c   Teljesít egy feladatot.");
    }
}
