package com.taskmaster.services;

import java.sql.SQLException;
import java.util.List;

import com.taskmaster.beans.Task;

/* 
 * This is a placeholder interface for the taskDAO
 * 
 * 
 */

public interface TaskServices {

	//insert a task
	int insertTask(Task task) throws SQLException;
	
	//select a task by id
	Task selectTask(int taskID);
	
	//list tasks
	List<Task> selectAllTasks();
	
	//delete a task
	int deleteTask(int taskID) throws SQLException;
	
	//update task
	int updateTask(Task task) throws SQLException;
	
	//update status
	int updateStatus(int taskID) throws SQLException;
	
	//
	int deleteAllTasks() throws SQLException;


}
