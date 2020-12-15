package com.beltorion;

public class ToDos {

   private String task;
   Boolean isTaskCompleted;

   public ToDos(String task) {
      this.task = task;
      this.isTaskCompleted = false;
   }

   @Override
   public String toString() {
      return "ToDos{" +
              "task='" + task + '\'' +
              ", isTaskCompleted=" + isTaskCompleted +
              '}';
   }
}
