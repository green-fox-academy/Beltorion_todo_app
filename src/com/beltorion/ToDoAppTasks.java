package com.beltorion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class ToDoAppTasks {

    static void listTasks() throws IOException {
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

    static void addTask() {
        Scanner scanner = new Scanner(System.in);
        String taskToAdd = "\r" + scanner.nextLine();
        if (taskToAdd.length() == 1) {
            System.out.println("Nem lehetséges új feladat hozzáadása: nincs megadva a feladat!");
        } else {
            try {
                Path filePath = Paths.get("src/com/beltorion/todolist");
                Files.write(filePath, taskToAdd.getBytes(), StandardOpenOption.APPEND);
                System.out.println("Task has been added to your list");
            } catch (Exception e) {
                System.out.println("Could not write the file!");
            }
        }
    }

    static void removeTask() {
        try {
            Path filePath = Paths.get("src/com/beltorion/todolist");
            List<String> lines = Files.readAllLines(filePath);
            lines.remove(1);
            Files.write(filePath, lines);
        } catch (IOException e) {
            System.out.println("Unable to read file: todolist.txt");
        }
    }

}
