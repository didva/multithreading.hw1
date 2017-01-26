package school.lemon.changerequest.java.multithreading.hw1.executor;

/**
 * Interface for a task.
 */
public interface Task {

    /**
     * Returns how many times executor has tried to execute this task.
     * @return tries count
     */
    int getTryCount();

    /**
     * Increment tries count.
     */
    void incTryCount();

    /**
     * Execute this task.
     * @throws TaskExecutionFailedException if the task wasn't completed successfully
     */
    void execute() throws TaskExecutionFailedException;
}

