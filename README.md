# Java Individual Project

## IP Specification


### Project Brief

ToDoly is a command-line application for the user to track his own tasks. It eases the tasks of the adding, updating, deleting of user tasks. Moreover, the app will provide a way to view tasks sorted by project and date.

### Functional requirements

FR1 - User can add a new task.\
FR2 - User can update a task.\
FR3 - User can delete a task.\
FR4 - User can view task list sorted by project or date.\
FR5 - System should restore task list on app restart.

### Class Diagram

<!-- ```plantuml
@startuml

    class Task {
        - title
        - dueDate
        - project
        - status
        + Task()
        + getTitle()
        + getDueDate()
        + getProject()
        + getStatus()
        + setTitle()
        + setDueDate()
        + setProject()
        + setStatus()
        + toString()
    }

    class UserTasks {
        - Tasks
        + UserTasks()
        + addTask()
        + removeTask()
        + updateTask()
        + getTask()
        + sortTask()
        + toString()
    }

    class Main{
        + userTasks
        + main()
    }

Main <-- UserTasks
UserTasks "1" *-- "1..*" Task 

@enduml
```
 -->

![Class diagram](https://github.com/pal85adam/javaip/blob/master/classdiagram.png?raw=true)

### The interface should look similar to the mockup below:

>\>> Welcome to ToDoLy \
\>> You have X tasks todo and Y tasks are done! \
\>> Pick an option: \
\>> (1) Show Task List (by date or project) \
\>> (2) Add New Task \
\>> (3) Edit Task (update, mark as done, remove) \
\>> (4) Save and Quit \
\>>

