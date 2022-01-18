import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
public class TaskApp {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        int option;

        //loop until user choice option Exit.
        do {
            System.out.println("===== Task Program =====");
            
      
            System.out.println("1.Add task");
            System.out.println("2.Delete task");
            System.out.println("3.Display task");
            System.out.println("4. Exit");

            System.out.println("Enter Your Choice: ");
            option = Validator.inputNumber();

            switch (option) {
                case 1:

                    System.out.println("----- Add Task -----");

                    if (manager.addTask(inputTask())) {
                        System.out.println("Add successfull");
                    } else {
                        System.out.println("Add false");
                    }
                    break;
                case 2:

                    if (manager.deleteTask(inputId())) {
                        System.out.println("Delete successfull");
                    } else {
                        System.out.println("Delete false");
                    }
                    break;
                case 3:
                    System.out.println("-----Task-----");
                    System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID","Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
                    for (Task objTask : manager.getDataTask()) {
                        System.out.println(objTask);

                    }
                    break;
            }

        } while (option != 4);
    }

    private static Task inputTask() {
        Task objTask = new Task();
        System.out.println("Requirement Name");
        objTask.setName(Validator.inputString()); //input name
        System.out.println("Task Type: ");
        objTask.setTypeId(Validator.inputTaskType());
        objTask.setDate(Validator.inputDate()); // input date
        System.out.println("From: ");
        objTask.setFrom(Validator.inputTimeFrom());//input timeform
        System.out.println("To: ");
        objTask.setTo(Validator.inputTimeTo(objTask.getFrom()));
       
//input time to , time to > time from
        System.out.println("Assignee: ");
        objTask.setAssignee(Validator.inputString());//input Assign
        System.out.println("Reviewer: ");
        objTask.setReviewer(Validator.inputString());// input reviewer
        return objTask;
    }

    //function to enter TaskId to delete
    public static int inputId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Id:");
        int id = Validator.inputNumber(); //input in need delete

        return id;
    }

}
