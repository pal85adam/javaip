package javaip;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserTasks{
    private ArrayList<Task> tasks;

    public UserTasks(){
        tasks = new ArrayList<Task>();
    }

    public Task getTaskByIndex(int index){
        return tasks.get(index);
    }

    public void addTask(String title, Date dueDate, String project){
        this.tasks.add(new Task(title, dueDate, project));
    }

    public boolean removeTask(Task task){
        return this.tasks.remove(task);
    }

    public void updateTask(int index, String title, Date dueDate, String project){
        this.tasks.set(index, new Task(title, dueDate, project));
    }

    public Task getTask(String title){
        return this.tasks.stream()
        .filter(task -> title.equals(task.getTitle()))
        .findAny()
        .orElse(null);
    }

    public int getTaskIndex(String title){
        for(int i = 0; i < tasks.size(); i++){
            if(title.equals(title)) return i;
        }
        return -1;
    }

    public <T> void sortTasks(String searchKey,T searchValue){
        System.out.println();
    }

    public void sortByDate(){
        Collections.sort(tasks, Comparator.comparing(Task::getDueDate));
    }

    public void sortByProject(){
        Collections.sort(tasks, Comparator.comparing(Task::getProject));
    }
    // Collections.sort(task, Comparator.comparing((Task tsk) -> tsk.getDueDate()));

    public void saveToFile() {
        PrintWriter pw= null;
        try {
            pw = new PrintWriter(new FileWriter("myTasks.txt"));

            for (Task task : tasks) {
                String s = task.toString().replace("false","Await").replace("true","Done");
                pw.println(s);
            }

        } catch (IOException e){
            System.out.println("Unexpected error occurred. ");
        }
        finally {
            pw.close();
        }
    }

    public void readFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("myTasks.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = br.readLine()) != null) {
                this.addTaskFromStringLine(line);
                // System.out.println(line);
            }
        } catch (IOException e){
            System.out.println("File Error!");
        }
    }

    public boolean addTaskFromStringLine(String taskAsStringLine){
        String[] parts = taskAsStringLine.split(",");
        String taskTitle = parts[0];
        Date dueDate = isValidDate(parts[1].trim());
        String project = parts[2];
        if(parts.length == 4 && dueDate != null){
            this.addTask(taskTitle, dueDate, project);
            this.tasks.get(tasks.size()-1).setStatus(parts[3].trim().equals("Await")?false:true);
            return true;
        }else{
            return false;
        }
    }

    public Date isValidDate(String dateToValidate) {

        if(dateToValidate == null){
            return null;
        }

        Date date = null;
        try {

            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            format.setLenient(false);
            date = format.parse(dateToValidate);

        } catch (ParseException e) {

            e.printStackTrace();
            return null;
        }

        return date;
    }

    public String toString(){
        return this.tasks.stream()
        .map(task -> task.toString())
        .reduce(" ",(result, task) -> { return result + "\n" + task; });
    }
}