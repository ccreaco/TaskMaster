package com.taskmaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.taskmaster.beans.Task;
import com.taskmaster.services.TaskServices;

/*
 * The TaskDao is implementing the TaskServices interface. This class is following CRUD operations that can be performed on the tasks that
 * have been added to the task list. 
 * 
 */

public class TaskDao implements TaskServices {

	private Connection connection;
	private String INSERT_TASKS_SQL = "INSERT INTO tasks(taskName, targetDate) VALUES (?,?);";
	private String SELECT_TASK_BY_ID = "select taskID, taskName, taskStatus, targetDate from tasks where taskID=?";
	private String SELECT_ALL_TASKS = "select * from tasks ORDER BY CASE when taskStatus = 'Pending' THEN 1 WHEN taskStatus ='Complete' THEN 2 END;";
	private String DELETE_TASK_SQL = "delete from tasks where taskID=?;";
	private String UPDATE_TASK_SQL = "UPDATE TASKS set taskName = ?, targetDate = ? where taskID=?'";
	private String UPDATE_TASK_STATUS_SQL = "UPDATE TASKS set taskStatus='Complete' where taskID=?;";
	private String DELETE_ALL_TASKS_SQL = "DELETE from tasks;";

	@Override
	public int insertTask(Task task) throws SQLException {

		int rows = 0; 
		
		try {

			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(INSERT_TASKS_SQL);

			ps.setString(1, task.getTaskName());
			ps.setString(2, task.getTargetDate());
			
			rows = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		 
		return rows;
	}

	@Override
	public Task selectTask(int taskID) {
		Task task = null;

		try {

			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_TASK_BY_ID);

			ps.setInt(1, taskID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int ID = rs.getInt("taskID");
				String taskName = rs.getString("taskName");
				String taskStatus = rs.getString("taskStatus");
				String targetDate = rs.getString("targetDate");

				task = new Task(ID, taskName, taskStatus, targetDate);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return task;
	}

	@Override
	public List<Task> selectAllTasks() {

		List<Task> task = new ArrayList<>();

		try {

			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_TASKS);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int ID = rs.getInt("taskID");
				String taskName = rs.getString("taskName");
				String taskStatus = rs.getString("taskStatus");
				String targetDate = rs.getString("targetDate");

				task.add(new Task(ID, taskName, taskStatus, targetDate));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return task;
	}

	@Override
	public int deleteTask(int taskID) throws SQLException {

		int rowDeleted = 0;

		try {

			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(DELETE_TASK_SQL);

			ps.setInt(1, taskID);

			rowDeleted = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return rowDeleted;
	}

	@Override
	public int updateTask(Task task) throws SQLException {

		int rowUpdated = 0;

		try {

			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_TASK_SQL);

			ps.setInt(1, task.getTaskID());
			ps.setString(2, task.getTaskName());
			ps.setString(3, task.getTaskStatus());
			ps.setString(2, task.getTargetDate());

			rowUpdated = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rowUpdated;
	}

	@Override
	public int updateStatus(int taskID) throws SQLException {
		int rowUpdated = 0;

		try {

			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_TASK_BY_ID);

			ps.setInt(1, taskID);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) { 
				
				ps = connection.prepareStatement(UPDATE_TASK_STATUS_SQL);
				ps.setInt(1, taskID);
				
				ps.executeUpdate();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rowUpdated;
	}

	@Override
	public int deleteAllTasks() throws SQLException { 
		
		int delete = 0;
		

		try {

			connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps = connection.prepareStatement(DELETE_ALL_TASKS_SQL);

			delete = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return delete;
	}
}
