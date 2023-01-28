package com.taskmaster.beans;


/* 
 * This class extends the tasklist class in order to make specific tasks in the list
 * 
 * 
 */

public class Task {
	
	private int taskID;
	private String taskName;
	private String taskStatus;
	private String targetDate;
	
	

	public Task() {
		super();
	}
	
	
	public Task(int taskID, String taskName, String taskStatus, String targetDate) { 
		this.taskID = taskID;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
		this.targetDate = targetDate;
	}

	public Task(String taskName, String targetDate) {
		this.taskName = taskName;
		this.targetDate = targetDate;
	}


	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
}
