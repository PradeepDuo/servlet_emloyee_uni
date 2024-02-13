package com.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Task implements Comparable<Task>{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "task_id")
@SequenceGenerator(name = "task_id",initialValue = 100,allocationSize = 1)
private int id;
private String description;
@CreationTimestamp
private LocalDateTime creationTime;
@UpdateTimestamp
private LocalDateTime completeTime;

private String status;

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}



public LocalDateTime getCreationTime() {
	return creationTime;
}

public void setCreationTime(LocalDateTime creationTime) {
	this.creationTime = creationTime;
}

public LocalDateTime getCompleteTime() {
	return completeTime;
}

public void setCompleteTime(LocalDateTime completeTime) {
	this.completeTime = completeTime;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getId() {
	return id;
}

@Override
public int compareTo(Task o) {
	if(this.status.equals(o.status))
		return 1;
	return -1;
}
}


