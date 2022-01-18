
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author win
 */
public class TaskManagement {

    private List<Task> listTasks = new ArrayList<>();

    public void addNewTask() {
        int id = 1;
        if (!listTasks.isEmpty()) {
            id = listTasks.get(listTasks.size() - 1).getId() + 1;
        }
        String name = Validation.getString("Requirement Name: ", "Name invalid", "^[a-zA-Z ]+$");
        int taskType = Validation.getInt("Task Type: ", "Task type invalid", 1, 4);
        Date date = Validation.getDate("Date: ", "Date invalid", "dd/MM/yyyy");
        double from = Validation.getDouble("From: ", "From[8.0 - 17.5]", 8.0, 17.5);
        double to = Validation.getDouble("To: ", "To[" + from + " - 17.5]", from, 17.5);
        String assign = Validation.getString("Assignee: ", "Assignee invalid", "^[a-zA-Z ]+$");
        String review = Validation.getString("Reviewer: ", "Reviewer invalid", "^[a-zA-Z ]+$");
        Task task = new Task(taskType, name, date, from, to, assign, review);
        task.setId(id);
        listTasks.add(task);
        System.out.println("Add Task successful!");
    }

    public void deleteTask() {
        System.out.println("---------Del Task------");
        int id = Validation.getInt("Id: ", "Id is a positive integer!", 1, Integer.MAX_VALUE);
        // found task, if found then delete
        boolean isIdExisted = false;
        for (int i = 0; i < listTasks.size(); i++) {
            Task task = listTasks.get(i);
            if (task.getId() == id) {
                isIdExisted = true;
                // delete task
                listTasks.remove(i);
                System.out.println("Delete task succesful!");
            }
        }
        if (!isIdExisted) {
            System.out.println("Not found");
            System.out.println("Delete task fail!");
        }

    }

    public void displayTask() {
        System.out.println("----------------------------------------- Task ---------------------------------------");
        if (listTasks.isEmpty()) {
            System.out.println("List task is empty");
        } else {
            System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "ID", "Name", "Task Type", "Date", "Time",
                    "Assignee", "Reviewer");
            for (Task task : listTasks) {
                System.out.println(task);
            }
        }
    }

}
