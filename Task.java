import java.util.Date;

public class Task {
    private String title;
    private Date dueDate;
    private boolean status;

    public Task(String title, Date dueDate, boolean status){
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
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

    public void setTitle(String title){
        this.title = title;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }    

    public String toString(){
        return this.getTitle().", ".this.getDueDate().", ".this.getStatus()?"Done":"Await";
    }
}