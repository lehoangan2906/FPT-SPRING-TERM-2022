
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class TaskManagement {

    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("=====Task program=====");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit.");
    }

    public void addTask(ArrayList<Task> list) {
        String name = Utility.GetString("Requirement name: ", true);
        int TaskType = Utility.GetInt("Task Type: ", 1, 4);
        Date date = Utility.GetDate("Date: ");
        Double from = getFrom("From: ");
        double to;
        do{
            to = getFrom("To: ");
        }while(to > from && to <= 17.5);
        String assign = Utility.GetString("Assignee: ", true);
        String reviewer = Utility.GetString("Reviewer: ", true);

        Task t = new Task(name, TaskType, date, from, to, assign, reviewer);
        list.add(t);
        System.err.println("Add successfully!");

    }

    public void display(ArrayList<Task> list) {
        if (list.isEmpty()) {
            System.err.println("List empty!");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).toString());

        }
    }

    public int findByID(ArrayList<Task> list, int xID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == xID) {
                return i;
            }
        }
        return -1;
    }

    public void delete(ArrayList<Task> list) {
        int idDelete = Utility.GetInt("Enter ID to delete: ", 1, Integer.MAX_VALUE);
        if (findByID(list, idDelete) >= 0) {
            list.remove(findByID(list, idDelete));
            System.err.println("Removed successfully!");
        } else {
            System.err.println("This ID doesn't exist!");
        }

    }

    public double getFrom(String msg) {
        double from = 0;
        while (true) {
            try {
                System.out.println(msg);
                from = Double.parseDouble(sc.nextLine());
                if (from >= 8 && from <= 17.5) {
                    if (from % 0.5 == 0) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //    public double getTo(double from) {
        //        double to;
        //        while (true) {
        //            try {
        //                to = Utility.GetDouble("Enter to: ", 8, 17.5);
        //                if (to % 0.5 == 0 && to > from) {
        //                    return to;
        //                }
        //                System.err.println("Invalid!");
        //            } catch (Exception e) {
        //                System.out.println(e);
        //            }
        //        }
        //
//        //    }
//
//    public int getID(List<Task> list) {
//        if (list.isEmpty()) {
//            return 1;
//        } else {
//            return list.get(list.size() - 1).getID() + 1;
//        }
//    }
}
