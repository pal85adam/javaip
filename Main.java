import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private ArrayList<Task> tasks;
    private Scanner userScanner;

    public Main(){
        tasks = new ArrayList<>();
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

    public String getTaskList(){
        return "";
    }

    public void addTasks(){
        
    }

    public void updateTask(){
        
    }

    public void doneTask(){
        
    }

    public void removeTask(){
        
    }

    public void quitAndSave(){
        
    }

    public void processEdit(){
        int input = 0;
        while(true){
            this.getEditTaskMenu();
            input = Integer.parseInt(this.userScanner.nextLine());
            System.out.println(input);

            switch(input){
                case 1: this.updateTask(); break;
                case 2: this.doneTask(); break;
                case 3: this.removeTask(); break;
                case 4: System.out.println("Exit the editing mode."); break;
                default: System.out.println("Invalid input!"); break;
            }
            
            if(input == 4) break;            
        }
    }

    public static void main(String[] args){
        Main obj = new Main();
        int input = 0;

        while(true){
            obj.getMainMenu();
            input = Integer.parseInt(obj.userScanner.nextLine());
            System.out.println(input);

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