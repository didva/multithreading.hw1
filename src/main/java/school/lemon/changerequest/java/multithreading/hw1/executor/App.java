package school.lemon.changerequest.java.multithreading.hw1.executor;

public class App {

    public static void main(String[] args) throws TaskExecutionFailedException {
        TasksStorage tasksStorage = new ArrayListTaskStorage();
        tasksStorage.add(new CopyFileTask("LICENSE111", "test"));
        tasksStorage.add(new CopyFileTask(".gitignore", "test"));
        tasksStorage.add(new CopyFileTask(".travis.yml", "test"));
        tasksStorage.add(new CopyFileTask("build.gradle", "test"));
        tasksStorage.add(new CopyFileTask("gradlew", "test"));
        tasksStorage.add(new CopyFileTask("gradlew.bat", "test"));
        tasksStorage.add(new CopyFileTask("README.md", "test"));
        tasksStorage.add(new CopyFileTask("settings.gradle", "test"));

        TaskExecutor[] taskExecutors = new TaskExecutor[3];
        for (int i = 0; i < taskExecutors.length; ++i) {
            taskExecutors[i] = new TaskExecutorImpl();
            taskExecutors[i].setStorage(tasksStorage);
            taskExecutors[i].start();
        }

        for (TaskExecutor taskExecutor : taskExecutors) {
            taskExecutor.stop();
        }

    }

}
