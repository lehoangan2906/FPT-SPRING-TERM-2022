
import java.util.Date;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Task {

    
    private static int Auto = 1;
    private int ID;
    private String name;
    private int TaskType;
    private Date date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(String name, int TaskType, Date date, double from, double to, String assignee, String reviewer) {

        this.ID = Auto++;
        this.name = name;
        this.TaskType = TaskType;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getID() {
        return ID;
    }

    public static int getAuto() {
        return Auto;
    }

    public static void setAuto(int Auto) {
        Task.Auto = Auto;
    }
    
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaskType() {
        return TaskType;
    }

    public void setTaskType(int TaskType) {
        this.TaskType = TaskType;
    }

    public Date getDate() {
        return date;

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assigne) {
        this.assignee = assigne;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    
    public String TaskType() {
        switch (this.TaskType) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    this.getID(),
                    this.getName(),
                    this.TaskType(),
                    Utility.toStringDateFormatByRegex(this.getDate(), "dd-MM-yyyy"),
                    this.getTo()-this.getFrom(),
                    this.getAssignee(),
                    this.getReviewer()
            );
    }

}
