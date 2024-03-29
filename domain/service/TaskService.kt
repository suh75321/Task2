package com.teamsparta.courseregistration2.domain.service

import com.teamsparta.courseregistration2.domain.Task
import com.teamsparta.courseregistration2.domain.TaskRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(private val taskRepository: TaskRepository) {

    fun getAllTasks(): List<Task> {
        val tasks = taskRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"))
        return tasks
    }

    fun getTaskById(id: Long): Optional<Task> {
        return taskRepository.findById(id)
    }

    fun createTask(task: Task): Task {
        return taskRepository.save(task)
    }

    fun updateTask(id: Long, newTask: Task): Optional<Task> {
        return taskRepository.findById(id).map { existingTask ->
            existingTask.title = newTask.title
            existingTask.content = newTask.content
            existingTask.writer = newTask.writer
            taskRepository.save(existingTask)
        }
    }

    fun deleteTask(id: Long) {
        return taskRepository.deleteById(id)
    }

    fun deleteAllTasks() {
        TODO("Not yet implemented")
    }


}