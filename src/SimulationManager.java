import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulationManager implements Runnable {

    private int minArrTime;
    private int maxArrTime ;
    private Scheduler scheduler;
    public int timeLimit ;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int numberOfServers;
    public int numberofClients;
    private List<Task> generatedTasks;
    private int WaitingTime;
    private int noClients;
    private int peakHour;
    private View view;

    public SimulationManager(int minArrTime, int maxArrTime, int timeLimit, int maxProcessingTime, int minProcessingTime, int numberOfServers, int numberofClients, View view) {
        scheduler = new Scheduler(numberOfServers, 100);
        this.timeLimit = timeLimit;
        this.numberofClients = numberofClients;
        this.numberOfServers = numberOfServers;
        this.maxProcessingTime = maxProcessingTime+1;
        this.minProcessingTime = minProcessingTime;
        this.minArrTime = minArrTime;
        this.maxArrTime = maxArrTime+1;
        this.view = view;
        generateNRandomTasks();
    }


    public void generateNRandomTasks() {
        Random random = new Random();
        generatedTasks = new ArrayList<>(numberofClients);
        for (int i = 0; i < numberofClients; i++) {
            generatedTasks.add(new Task(i + 1, random.nextInt(maxArrTime - minArrTime) + minArrTime, random.nextInt(maxProcessingTime - minProcessingTime) + minProcessingTime));
        }
        Collections.sort(generatedTasks);

    }

    private boolean finished() {
        if (generatedTasks.size() == 0) {
            for (Server s : scheduler.getServers()) {
                if (s.getTasks().size() >= 1) {
                    return false;
                }
            }
        } else {
            return false;
        }
        for(Server s: scheduler.getServers()){
            s.setThreadLife(false);
        }
        appendFile("---------------------" + "\n" + "Average waiting time: " + (double) WaitingTime / numberofClients + "\n");
        appendFile("Peak hour: " + peakHour + "\n\n\n");
        return true;
    }

    private void calcpeakHour(int currentTime) {
        int n = 0;
        for (Server s : scheduler.getServers()) {
            n += s.getTasks().size();
        }
        if (n > noClients) {
            peakHour = currentTime;
            noClients = n;
        }
    }

    private void WaitingTime() {
        Server server = scheduler.getServers().get(0);
        for (Server s : scheduler.getServers()) {
            if (server.getWaitingPeriod().intValue() > s.getWaitingPeriod().intValue() && s.getTasks().size() < scheduler.getMaxTasksPerServer()) {
                server = s;
            }
        }
        if (server.getTasks().size() < scheduler.getMaxTasksPerServer()) {
            WaitingTime += server.getWaitingPeriod().intValue();
        }
    }

    private void createOutput(int currentTime){
        String res = "Clients: ";
        for(Task t : generatedTasks){
            res += t;
        }
        res+="\n";
        int i = 1;
        for (Server s : scheduler.getServers()) {
            res+=("Server " + i++ + ":" + (s.getTasks().size() > 0 ? s.printServer() + ";" : " closed") + "\n");
        }
        view.getjTextArea().setText(res);
        view.getTextField8().setText(currentTime+"");
    }

    @Override
    public void run() {
        int currentTime = 0;
        ArrayList<Task> taskToDel = new ArrayList<>();
        while (currentTime < timeLimit) {
            if (finished()) {
                break;
            }
            for (Task t : generatedTasks) {
                if (t.getArrivalTime() == currentTime) {
                    WaitingTime();
                    scheduler.dispatchTask(t);
                    calcpeakHour(currentTime);
                    taskToDel.add(t);
                }
            }
            generatedTasks.removeAll(taskToDel);
            createOutput(currentTime);
            appendFile("Time " + currentTime++ + "\n" + "Waiting clients: " + generatedTasks + "\n");
            int i = 1;
            for (Server s : scheduler.getServers()) {
                appendFile("Queue " + i++ + ":" + (s.getTasks().size() > 0 ? s.printServer() + ";" : " closed") + "\n");
            }
            appendFile("\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void appendFile(String message) {
        try {
            File f1 = new File("Log.txt");
            if (!f1.exists()) {
                f1.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(f1.getName(), true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(message);
            bw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMinArrTime(int minArrTime) {
        this.minArrTime = minArrTime;
    }

    public void setMaxArrTime(int maxArrTime) {
        this.maxArrTime = maxArrTime;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Scheduler getScheduler(){
        return this.scheduler;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setMaxProcessingTime(int maxProcessingTime) {
        this.maxProcessingTime = maxProcessingTime;
    }

    public void setMinProcessingTime(int minProcessingTime) {
        this.minProcessingTime = minProcessingTime;
    }

    public void setNumberOfServers(int numberOfServers) {
        this.numberOfServers = numberOfServers;
    }

    public void setNumberofClients(int numberofClients) {
        this.numberofClients = numberofClients;
    }

    public void setWaitingTime(int waitingTime) {
        WaitingTime = waitingTime;
    }

    public void setNoClients(int noClients) {
        this.noClients = noClients;
    }

    public void setPeakHour(int peakHour) {
        this.peakHour = peakHour;
    }
}
