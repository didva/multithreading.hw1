package school.lemon.changerequest.java.multithreading.hw1.executor;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTaskStorage implements TasksStorage {

    private List<Task> list = new ArrayList<>();

    @Override
    public void add(Task task) throws NullPointerException {
        if (task == null) {
            throw new NullPointerException();
        }
        synchronized (this) {
            list.add(task);
        }
    }

    @Override
    public synchronized Task get() {
        return list.isEmpty() ? null : list.remove(0);
    }

    @Override
    public int count() {
        return list.size();
    }
}
