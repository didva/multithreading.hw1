package school.lemon.changerequest.java.multithreading.hw1.executor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileTask implements Task {

    private int triesCount;
    private String filePath;
    private String folderPath;

    public CopyFileTask(String filePath, String folderPath) {
        this.triesCount = 0;
        this.filePath = filePath;
        this.folderPath = folderPath;
    }

    @Override
    public int getTryCount() {
        return triesCount;
    }

    @Override
    public void incTryCount() {
        ++triesCount;
    }

    @Override
    public void execute() throws TaskExecutionFailedException {
        File file = new File(filePath);
        byte[] buffer = new byte[10000];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            try (BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(folderPath + File.separator + file.getName()))) {
                int read = bis.read(buffer);
                while (read != -1) {
                    bos.write(buffer, 0, read);
                    read = bis.read(buffer);
                }
            }
        } catch (IOException e) {
            throw new TaskExecutionFailedException(e);
        }
    }
}
