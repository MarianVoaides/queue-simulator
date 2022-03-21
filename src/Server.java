import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private ArrayBlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private boolean threadLife = true;


    public Server(int maxTasksPerServer) {
        waitingPeriod = new AtomicInteger(0);
        tasks = new ArrayBlockingQueue<>(maxTasksPerServer);
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
        newTask.taskFinished(waitingPeriod.getAcquire());
        waitingPeriod.addAndGet(newTask.getProcessingTime());
    }

    @Override
    public void run() {
        while (threadLife) {
            if (tasks.peek() != null) {
                try {
                    Thread.sleep(1000);
                    tasks.peek().decProcTime();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitingPeriod.addAndGet(-1);
                if (tasks.peek().getProcessingTime() == 0) {
                    tasks.poll();
                }
            }
        }
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public String printServer() {
        String rez = "";

        for (Task t : tasks) {
            rez += " " + t.toString();
        }

        return rez;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setThreadLife(boolean threadLife) {
        this.threadLife = threadLife;
    }
}
