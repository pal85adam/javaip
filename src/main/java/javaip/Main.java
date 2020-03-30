package javaip;

import java.util.Date;
import java.util.Scanner;

public class Main{
    private UserTasks tasks;
    private Scanner userScanner;

    public Main(){
        tasks = new UserTasks();
        userScanner = new Scanner(System.in);
    }

    private void getMainMenu(){
        System.out.print(">> Welcome to ToDoLy \n"
        + ">> You have X tasks todo and Y tasks are done! \n"
        + ">> Pick an option: \n"
        + ">> (1) Show Task List (by date or project) \n"
        + ">> (2) Add New Task \n"
        + ">> (3) Edit Task (update, mark as done, remove) \n"
        + ">> (4) Save and Quit \n"
        + ">> ");
    }

    private void getEditTaskMenu(){
        System.out.print(">> Pick an option: \n"
        + ">> (1) Update \n"
        + ">> (2) Mark as done \n"
        + ">> (3) Remove \n"
        + ">> (4) Exit \n"
        + ">> ");
    }

    public void getTaskList(){
        System.out.println(tasks.toString());
    }

    public void processShowTaskList(){
        System.out.println("Pick to show task list \n(1) sorted by date. \n(2) sorted by project.\n");
        int input = readLineAsOption();
        switch (input){
            case 1: tasks.sortByDate(); break;
            case 2: tasks.sortByProject(); break;
            default: System.out.println("Invalid input!"); break;
        }
        getTaskList();
    }

    public void addTasks() {
        while(true){
            System.out.println("Write the task as following:\n Task name, DD/MM/YYYY, Project name\n");
            String input = this.userScanner.nextLine();

            if(!tasks.addTaskFromStringLine(input + ", Await")){
                System.out.println("Invalid input!");
            }

            System.out.println("Add a new task? (Y = Yes, Others No) ");
            input = this.userScanner.nextLine();
            if(!(input.equals("Y") || input.equals("y"))) break;
        }
    }

    public void updateTask(int index) {
        System.out.println("Choose what to update:"
        +"(1) Task title.\n"
        +"(2) Due to date.\n"
        +"(3) Project name.");
        int input = readLineAsOption();
        System.out.println("Enter the new value!");
        String attrToUpdate = this.userScanner.nextLine();
        switch(input){
            case 1:  tasks.getTaskByIndex(index).setTitle(attrToUpdate); break;
            case 2:   
            Date dueDate = tasks.isValidDate(attrToUpdate.trim());
            if(dueDate != null){
                tasks.getTaskByIndex(index).setDueDate(dueDate);
            }
            break;
            case 3:  tasks.getTaskByIndex(index).setProject(attrToUpdate); break;
            case 4: System.out.println("Exit the editing mode."); break;
            default: System.out.println("Invalid input!"); break;
        }
    }

    public void doneTask(int index){
        tasks.getTaskByIndex(index).setStatus(true);
    }

    public void removeTask(Task task){
        tasks.removeTask(task);
    }

    public void quitAndSave(){
        tasks.saveToFile();
    }

    public int readLineAsOption(){
        int input = Integer.parseInt(this.userScanner.nextLine());
        System.out.println(input);
        return input;
    }

    public void processEdit() {
        int input = 0;
        while(true){
            this.getTaskList();
            this.getEditTaskMenu();
            input = readLineAsOption();
            switch(input){
                case 1: editTask("Update"); break;
                case 2: editTask("Done"); break;
                case 3: editTask("Remove"); break;
                case 4: System.out.println("Exit the editing mode."); break;
                default: System.out.println("Invalid input!"); break;
            }
            
            if(input == 4) break;            
        }
    }

    public void editTask(String action) {
        System.out.println("Enter task title to "+action+": ");
        String input = this.userScanner.nextLine();
        int index = tasks.getTaskIndex(input.trim());
        if(index == -1){
            System.out.println("Invalid task title! ");
        }else{
            if(action.equals("Update")){
                updateTask(index);
            }
            if(action.equals("Done")){
                doneTask(index);
            }
            if(action.equals("Remove")){
                removeTask(tasks.getTaskByIndex(index));
            }
        }
    }
    
    public static void main(String[] args) {
        Main obj = new Main();
        obj.tasks.readFromFile();
        int input = 0;
        while(true){
            obj.getMainMenu();
            input = obj.readLineAsOption();
            switch(input){
                case 1: obj.processShowTaskList(); break;
                case 2: obj.addTasks(); break;
                case 3: obj.processEdit(); break;
                case 4: obj.quitAndSave(); break;
                default: System.out.println("Invalid input!"); break;
            }
            
            if(input == 4) break;
        }
    }

}