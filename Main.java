import java.util.ArrayList;

public class Main{
    ArrayList<Task> tasks;

    public Main(){
        tasks = new ArrayList<>();
    }

    public String getMainMenu(){
        return ">> Welcome to ToDoLy \n"
        + ">> You have X tasks todo and Y tasks are done! \n"
        + ">> Pick an option: \n"
        + ">> (1) Show Task List (by date or project) \n"
        + ">> (2) Add New Task \n"
        + ">> (3) Edit Task (update, mark as done, remove) \n"
        + ">> (4) Save and Quit \n"
        + ">> \n";
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

    public static void main(String[] args){

    }

}