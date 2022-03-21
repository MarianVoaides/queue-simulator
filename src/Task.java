public class Task implements Comparable<Task> {
    private int idTask;
    private int arrivalTime;
    private int processingTime;
    private int finishingTime;

    public Task(int idTask, int arrivalTime, int processingTime) {
        this.idTask = idTask;
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
    }


    public void taskFinished(int time) {
        finishingTime = arrivalTime + processingTime + time;
    }

    public void decProcTime() {
        processingTime--;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }


    public int getProcessingTime() {
        return processingTime;
    }


    @Override
    public int compareTo(Task t) {
        return this.arrivalTime - t.arrivalTime;
    }

    @Override
    public String toString() {
        return "(" +
                "" + idTask +
                "," + arrivalTime +
                "," + processingTime +
                ')';
    }
}
