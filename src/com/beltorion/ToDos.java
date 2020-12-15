package com.beltorion;

public class ToDos {

   private String task;

   public void setTask(String task) {
      this.task = task;
   }

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
