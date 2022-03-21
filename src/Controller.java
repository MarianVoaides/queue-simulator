import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter implements ActionListener {

    private final View view;
    private Thread thread;

    public Controller(View v){
        this.view = v;
    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == view.getButton0()){
            int minArrTime = Integer.parseInt(view.getTextField4().getText());
            int maxArrTime = Integer.parseInt(view.getTextField5().getText());
            int timeLimit = Integer.parseInt(view.getTextField3().getText());
            int maxProcessingTime = Integer.parseInt(view.getTextField6().getText());
            int minProcessingTime = Integer.parseInt(view.getTextField7().getText());
            int numberOfServers = Integer.parseInt(view.getTextField2().getText());
            int numberofClients = Integer.parseInt(view.getTextField1().getText());

            if(thread != null){
                thread.stop();
            }
            SimulationManager simulationManager = new SimulationManager(minArrTime,maxArrTime,timeLimit,maxProcessingTime,minProcessingTime,numberOfServers,numberofClients,view);
            thread = new Thread(simulationManager);
            thread.start();
        }

        if(source == view.getButton1()){
            view.getTextField1().setText("");
            view.getTextField2().setText("");
            view.getTextField3().setText("");
            view.getTextField4().setText("");
            view.getTextField5().setText("");
            view.getTextField6().setText("");
            view.getTextField7().setText("");
            view.getTextField8().setText("");
        }

    }

}
