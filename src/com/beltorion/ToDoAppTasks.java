package com.beltorion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ToDoAppTasks {

    static void listTasks() {
        try {
            Path filePath = Paths.get("src/com/beltorion/todolist");
            List<String> lines = Files.readAllLines(filePath);
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

            Path filePath = Paths.get("src/com/beltorion/todolist");
            List<String> lines = Files.readAllLines(filePath);
            lines.add("[ ] " + args);
            Files.write(filePath, lines);

            System.out.println("Task has been added to your list");
        } catch (Exception e) {
            System.out.println("Could not write the file!");
        }
    }

    static void removeTask(String args) {
        try {
            Path filePath = Paths.get("src/com/beltorion/todolist");
            List<String> lines = Files.readAllLines(filePath);
            lines.remove(Integer.parseInt(args) - 1);
            Files.write(filePath, lines);
        } catch (IOException e) {
            System.out.println("Unable to read file: todolist.txt");
        }
    }

    static void completeTask(String args) {
        try {
            Path filePath = Paths.get("src/com/beltorion/todolist");
            List<String> lines = Files.readAllLines(filePath);
            String taskDone = lines.get(Integer.parseInt(args) - 1);
            taskDone = taskDone.replace("[ ] ", "[X] ");
            lines.remove(Integer.parseInt(args) - 1);
            lines.add(Integer.parseInt(args) - 1, taskDone);
            Files.write(filePath, lines);
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
