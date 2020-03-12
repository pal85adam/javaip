import java.util.Date;

public class Task {
    private String title;
    private Date dueDate;
    private boolean status;
    private String project;

    public Task(String title, Date dueDate, String project){
        this.title = title;
        this.dueDate = dueDate;
        this.status = false;
        this.project = project;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean getStatus(){
        return this.status;
    }

    public Date getDueDate(){
        return this.dueDate;
    }

    public String getProject(){
        return this.project;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }     
    
    public void setProject(String project){
        this.project = project;
    }    

    public String toString(){
        return getTitle() + ", " + getDueDate() + ", " + getProject() + ", " + (getStatus()?"Done":"Await");
    }
}