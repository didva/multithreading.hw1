package school.lemon.changerequest.java.multithreading.hw1.executor;

public class TaskExecutorImpl implements TaskExecutor {

    private TasksStorage tasksStorage;
    private Executor executor;

    @Override
    public void setStorage(TasksStorage storage) throws NullPointerException {
        if (storage == null) {
            throw new NullPointerException();
        }
        this.tasksStorage = storage;
    }

    @Override
    public TasksStorage getStorage() {
        return tasksStorage;
    }

    @Override
    public void start() throws NullPointerException, IllegalStateException {
        if (tasksStorage == null) {
            throw new NullPointerException();
        } else if (executor != null) {
            throw new IllegalStateException();
        }
        executor = new Executor(tasksStorage);
        executor.start();
    }

    @Override
    public void stop() throws IllegalStateException {
        try {
            if (executor == null) {
                throw new IllegalStateException();
            }
            executor.interrupt();
            executor.join();
            executor = null;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private class Executor extends Thread {

        private TasksStorage tasksStorage;

        private Executor(TasksStorage tasksStorage) {
            this.tasksStorage = tasksStorage;
        }

        @Override
        public void run() {
            Task task = tasksStorage.get();
            while (task != null) {
                handleTask(task);
                task = tasksStorage.get();
            }
        }

        private void handleTask(Task task) {
            try {
                if (task != null) {
                    task.execute();
                }
            } catch (TaskExecutionFailedException e) {
                e.printStackTrace();
                task.incTryCount();
                if (task.getTryCount() < 5) {
                    tasksStorage.add(task);
                }
            }
        }
    }

}
