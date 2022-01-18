import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
public class TaskManager {
    
    ArrayList<Task> listTask = new ArrayList<>();
   
    
    public ArrayList<Task> getDataTask(){
        return listTask;
    }
    
    //function to add task
    public boolean addTask(Task objTask){
        if(objTask == null){
            return false;
        }
        else{
            int lastId = 1;
            if(listTask.size() !=0){
                lastId=listTask.get(listTask.size()-1).getId()+1;
            }
            if(objTask.getTo() <= objTask.getFrom()){
                return false;
            }
            objTask.setId(lastId);
            listTask.add(objTask);// add task to list
            return true;
        }
    }
    
    //function to Delete Task
    public boolean deleteTask(int taskID){
      
        for (int i = 0; i < listTask.size(); i++) {
            if(listTask.get(i).getId() == taskID){
               
                listTask.remove(i);
                return true;
            }
        }
        return false;
    }
}
