import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public void addTasks(){
        while(true){
            System.out.println("Write the task as following:\n Task name, DD/MM/YYYY, Project name\n");
            String input = this.userScanner.nextLine();
            //System.out.println(input);
            String[] parts = input.split(",");
            String taskTitle = parts[0];
            Date dueDate = isValidDate(parts[1].trim(), "dd/MM/YYYY");
            String project = parts[2];
            if(parts.length == 3 && dueDate != null){
                tasks.addTask(taskTitle, dueDate, project);
            }else{
                System.out.println("Invalid input!");
            }

            System.out.println("Add a new task? (Y = Yes, Others No) ");
            input = this.userScanner.nextLine();
            if(!(input.equals("Y") || input.equals("y"))) break;
        }
    }

    public void updateTask(int index){
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
            Date dueDate = isValidDate(attrToUpdate.trim(), "dd/MM/YYYY");
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
        
    }

    public int readLineAsOption(){
        int input = Integer.parseInt(this.userScanner.nextLine());
        System.out.println(input);
        return input;
    }

    public void processEdit(){
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

    public void editTask(String action){
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

    public Date isValidDate(String dateToValidate, String dateFromat){
        Date date = null;
        if(dateToValidate == null){
            return null;
        }
    
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
    
        try {
    
            //if not valid, it will throw ParseException
            date = sdf.parse(dateToValidate);
            System.out.println(date);
    
        } catch (ParseException e) {
    
            e.printStackTrace();
            return null;
        }
    
        return date;
    }
    
    public static void main(String[] args){
        Main obj = new Main();
        int input = 0;
        while(true){
            obj.getMainMenu();
            input = obj.readLineAsOption();
            switch(input){
                case 1: obj.getTaskList(); break;
                case 2: obj.addTasks(); break;
                case 3: obj.processEdit(); break;
                case 4: obj.quitAndSave(); break;
                default: System.out.println("Invalid input!"); break;
            }
            
            if(input == 4) break;
        }
    }

}