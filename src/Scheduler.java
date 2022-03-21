import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scheduler {

    private List<Server> servers;
    private int maxTasksPerServer;

    public Scheduler(int maxNoServers, int maxTasksPerServer) {
        this.maxTasksPerServer = maxTasksPerServer;
        servers = Collections.synchronizedList(new ArrayList<>(maxNoServers));
        for (int i = 0; i < maxNoServers; i++) {
            Server s = new Server(maxTasksPerServer);
            Thread thread = new Thread(s);
            servers.add(s);
            thread.start();
        }
    }


    public void dispatchTask(Task t) {
        Server server = servers.get(0);
        for (Server s : servers) {
            if (server.getWaitingPeriod().intValue() > s.getWaitingPeriod().intValue() && s.getTasks().size() < maxTasksPerServer) {
                server = s;
            }
        }
        if (server.getTasks().size() < maxTasksPerServer) {
            server.addTask(t);
        }
    }

    public int getMaxTasksPerServer() {
        return maxTasksPerServer;
    }

    public List<Server> getServers() {
        return servers;
    }
}
