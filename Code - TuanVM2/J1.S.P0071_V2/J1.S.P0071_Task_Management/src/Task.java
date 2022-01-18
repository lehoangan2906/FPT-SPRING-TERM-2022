
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author win
 */
public class Task {

    private int id;
    private int taskTypeId;
    private String name;
    private Date date;
    private double from;
    private double to;
    private String assign;
    private String review;

    public Task() {
    }

    public Task(int taskTypeId, String name, Date date, double from, double to, String assign, String review) {
        this.taskTypeId = taskTypeId;
        this.name = name;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assign = assign;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public String getTaskTypeName() {
        String taskTypeName = "";
        switch (taskTypeId) {
            case 1:
                taskTypeName = "Code";
                break;
            case 2:
                taskTypeName = "Test";
                break;
            case 3:
                taskTypeName = "Design";
                break;
            case 4:
                taskTypeName = "Review";
                break;
        }
        return taskTypeName;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s", id, name, getTaskTypeName(),
                new SimpleDateFormat("dd/MM/yyyy").format(date), to - from, assign, review);
    }

}
