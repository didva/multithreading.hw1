package school.lemon.changerequest.java.multithreading.hw1.nameprinter;

import java.io.PrintStream;

/**
 * Base interface for any thread, printing specified name.
 */
public interface NamePrinter {

    /**
     * Set thread name
     * @param name thread name
     * @throws NullPointerException name == null
     * @throws IllegalArgumentException name.length == 0
     */
    void setPrintName(String name) throws NullPointerException, IllegalArgumentException;

    /**
     * Set writer which should be used to print name. E.g. System.out
     * @param writer which should print specified name.
     * @throws NullPointerException stream == null
     */
    void setWriter(PrintStream writer) throws NullPointerException;

    /**
     * Set interval between printing name in ms.
     * @param ms time in ms between printing name.
     * @throws IllegalArgumentException ms <= 0
     */
    void setInterval(long ms) throws IllegalArgumentException;

    /**
     * Set how many times thread should print name.
     * @param count amount of times which thread should print name.
     * @throws IllegalArgumentException count <= 0
     */
    void setCount(int count) throws IllegalArgumentException;

}
