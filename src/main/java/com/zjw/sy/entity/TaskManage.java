package com.zjw.sy.entity;


public class TaskManage {

  private long taskId;
  private String taskTitle;
  private String taskContent;
  private long taskDegree;
  private long userId;
  private String userName;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private long sendUserId;
  private String sendUserName;


  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }


  public String getTaskTitle() {
    return taskTitle;
  }

  public void setTaskTitle(String taskTitle) {
    this.taskTitle = taskTitle;
  }


  public String getTaskContent() {
    return taskContent;
  }

  public void setTaskContent(String taskContent) {
    this.taskContent = taskContent;
  }


  public long getTaskDegree() {
    return taskDegree;
  }

  public void setTaskDegree(long taskDegree) {
    this.taskDegree = taskDegree;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public long getSendUserId() {
    return sendUserId;
  }

  public void setSendUserId(long sendUserId) {
    this.sendUserId = sendUserId;
  }


  public String getSendUserName() {
    return sendUserName;
  }

  public void setSendUserName(String sendUserName) {
    this.sendUserName = sendUserName;
  }

}
