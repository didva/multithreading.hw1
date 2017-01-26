package school.lemon.changerequest.java.multithreading.hw1.executor;

/**
 * Interface for task list.
 *
 */
public interface TasksStorage {

    /**
     * Add task to the list for executing.
     * @param task to add
     * @throws NullPointerException if task == null
     */
    void add(Task task) throws NullPointerException;

    /**
     * Get first task from the tasks list and delete task from this list.
     * @return task or null if tasks list is empty.
     */
    Task get();

    /**
     * Get quantity of tasks in lists, which can be executed.
     * @return quantity of tasks in lists, which can be executed.
     */
    int count();
}

