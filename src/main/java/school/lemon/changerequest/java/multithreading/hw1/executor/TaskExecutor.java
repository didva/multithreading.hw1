package school.lemon.changerequest.java.multithreading.hw1.executor;

/**
 * Interface for task executor.
 *
 */
public interface TaskExecutor {

	/**
	 * Set tasks storage.
	 *
	 * @param storage tasks storage
	 * @throws NullPointerException if tasks storage = null
	 */
	void setStorage(TasksStorage storage) throws NullPointerException;

	/**
	 * Get tasks storage.
	 *
	 * @return actual tasks storage.
	 */
	TasksStorage getStorage();

	/**
	 * Run task executor.
	 *
	 * @throws NullPointerException if tasks storage == null
	 * @throws IllegalStateException in cases when method can't be called or it is incorrect (e.g. recall method start without calling stop method)
	 */
	void start() throws NullPointerException, IllegalStateException;

	/**
	 * Stop task executor.
	 * The executor should wait for the finishing of all existing tasks.
	 *
	 * @throws IllegalStateException in cases when method can't be called or it is incorrect (e.g. recall method stop without calling start method)
	 */
	void stop() throws IllegalStateException;
}
