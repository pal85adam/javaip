import java.util.ArrayList;
import java.util.Date;

public class UserTasks{
    private ArrayList<Task> tasks;

    public UserTasks(){
        tasks = new ArrayList<>();
    }

    public Task getTaskByIndex(int index){
        return tasks.get(index);
    }

    public void addTask(String title, Date dueDate, String project){
        this.tasks.add(new Task(title, dueDate, project));
    }

    public boolean removeTask(Task task){
        return //(index > 0 && index <= this.tasks.size()) ? 
        this.tasks.remove(task); // : null;
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
            if(title.equals("title")) return i;
        }
        return -1;
    }

    public <T> void sortTasks(String searchKey,T searchValue){
        System.out.println();
    }

    public String toString(){
        return this.tasks.stream()
        .map(task -> task.toString())
        .reduce(" ",(result, task) -> { return result + "\n" + task; });
    }
}