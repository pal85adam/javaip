import java.util.ArrayList;
import java.util.Date;

public class UserTasks{
    private ArrayList<Task> tasks;

    public UserTasks(){
        tasks = new ArrayList<>();
    }

    public void addTask(String title, Date dueDate, String project){
        this.tasks.add(new Task(title, dueDate, project));
    }

    public Task removeTask(int index){
        return this.tasks.remove(index);
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

    public <T> void sortTasks(String searchKey,T searchValue){
        System.out.println();
    }

    public String toString(){
        return this.tasks.stream()
        .map(task -> task.toString())
        .reduce(" ",(result, task) -> { return result + "\n" + task; });
    }
}