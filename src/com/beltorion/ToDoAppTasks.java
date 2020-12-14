package com.beltorion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ToDoAppTasks {

    static void listTasks() throws IOException {
        try {
            Path filePath = Paths.get("src/com/beltorion/todolist");
            List<String> lines = Files.readAllLines(filePath);
            if (lines.isEmpty()) {
                System.out.println("Nincs mára tennivalód! :)");
            }else {
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

}
