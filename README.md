Multithreading HW1
===============

#### 1 Name Printer

Take a look at **NamePrinter** interface. Every class which implements this interface should save name and print it specified amount of times.
Interface defines several method:

1. **setPrintName** - set name which should be printed
2. **setWriter** - set writer which should be used for printing name
3. **setCount** - set how many times class should print name of thread
4. **setInterval** - set interval between

Implement interface NamePrinter and start thread with two different ways:

1. Implementing interface Runnable
2. Extending class Thread

**NOTE:** throw IllegalStateException if any of the parameters wasn't set. 

#### 2 Task Executor

Implement TaskExecutor interface, class should be used for execution tasks in background.

Every task class should implement Task interface. There should be two different tasks:
* Copy File. Copies specified file to specified folder.
* Search for files. Recursively search for files which in specified directory. 
Search criteria should be set via list of FileFilter instances.

Task executor gets tasks for execution from TasksStorage. TasksStorage - interface which defines methods for working with tasks queue. 
It should be implemented too. Please be sure, that your implementation is thread-safe, so tasks can be added/gotten from many threads.

On task execution may occur exceptions. 
If task failed the tries count for this task should be incremented and that task should be pushed back to the queue.
If task failed 5 times - task shouldn't be added to the queue.

Please read javadocs for more information for each class.

Create Demo class to show how all these stuff work together.
Demo class should do next things:
1. Create 3 objects of tasks executor (let's call them just "executors");
2. Create queue TasksStorage and add 3-4 tasks for coping very very big files and 15-20 tasks for finding files on disk in this queue;
3. Run all executors in parallel in the main thread;
4. The main thread should wait for finishing all tasks;
5. After all tasks will be done the main thread should stop executors correctly.
