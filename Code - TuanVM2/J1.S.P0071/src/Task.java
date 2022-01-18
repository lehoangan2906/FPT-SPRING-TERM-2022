import java.util.Locale;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */


public class Task {

    private int id;
    private String name;
    private int typeId;
    private String date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getTypeName() {
        switch (typeId) {
            case 1:
                return "code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Reviewer";
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", id, name, getTypeName(), date, (to - from), assignee, reviewer);
    }

}
