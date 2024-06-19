package com.indusnet.tm1.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Tasks1")
public class Tasks {

//    taskid int not null auto_increment,
//    pid int not null,
//    task_name varchar(255) default null,
//    task_description varchar(255) default null,
//    task_assignment varchar(255) default null,
//    task_priority int default null,
//    task_duedate varchar(255) default null,


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskid;

    @Column(name="pid")
    private int pid;
    @Column(name = "task_name")
    private String task_name;
    @Column(name = "task_description")
    private String task_description;
    @Column(name = "task_assignment")
    private String task_assignment;
    @Column(name = "task_priority")
    private int task_priority;
    @Column(name = "task_duedate")
    private String task_duedate;



    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_assignment() {
        return task_assignment;
    }

    public void setTask_assignment(String task_assignment) {
        this.task_assignment = task_assignment;
    }

    public int getTask_priority() {
        return task_priority;
    }

    public void setTask_priority(int task_priority) {
        this.task_priority = task_priority;
    }

    public String getTask_duedate() {
        return task_duedate;
    }

    public void setTask_duedate(String task_duedate) {
        this.task_duedate = task_duedate;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Tasks(int taskid, int pid, String task_name, String task_description, String task_assignment, int task_priority, String task_duedate) {
        this.taskid = taskid;
        this.pid=pid;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_assignment = task_assignment;
        this.task_priority = task_priority;
        this.task_duedate = task_duedate;
    }

    public Tasks(){}

}
