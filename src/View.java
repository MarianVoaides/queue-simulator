import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class View extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JPanel mainPanel = new JPanel();
    private final JPanel grid;

    private final JButton button0 = new JButton("Run");
    private final JButton button1 = new JButton("CE");


    private final JTextField textField8 = new JTextField("",10);
    private final JTextField textField7 = new JTextField("3",10);
    private final JTextField textField6 = new JTextField("8",10);
    private final JTextField textField5 = new JTextField("7",10);
    private final JTextField textField4 = new JTextField("2",10);
    private final JTextField textField3 = new JTextField("40",10);
    private final JTextField textField2 = new JTextField("3",10);
    private final JTextField textField1 = new JTextField("8",10);

    private final JLabel label1 = new JLabel("Numarul de clienti");
    private final JLabel label2 = new JLabel("Numarul de servere");
    private final JLabel label3 = new JLabel("Timpul de simulare");
    private final JLabel label4 = new JLabel("Timpul minim de venire");
    private final JLabel label5 = new JLabel("Timpul maxim de venire");
    private final JLabel label6 = new JLabel("Timpul minim de procesare");
    private final JLabel label7 = new JLabel("Timpul maxim de procesare");
    private final JLabel label8 = new JLabel("Timp");
    private final JLabel label9 = new JLabel("Servere");

    private JTextArea jTextArea;

    Controller controller = new Controller(this);

    public View(String name) {

        super(name);
        setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 500));
        this.pack();
        this.setResizable(true);
        this.setLocation(500,200);
        this.setVisible(true);
        GridBagConstraints gbc;

        grid = new JPanel(new FlowLayout());
        grid.setBackground(new Color(-11579569));

        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(-11579569));
        mainPanel.setEnabled(true);
        mainPanel.setForeground(new Color(-11579569));



        textField1.setBackground(new Color(-1337021));
        textField2.setBackground(new Color(-1337021));
        textField3.setBackground(new Color(-1337021));
        textField4.setBackground(new Color(-1337021));
        textField5.setBackground(new Color(-1337021));
        textField6.setBackground(new Color(-1337021));
        textField7.setBackground(new Color(-1337021));
        textField8.setBackground(new Color(-1337021));


        label1.setForeground(new Color(-1320014));
        label2.setForeground(new Color(-1320014));
        label3.setForeground(new Color(-1320014));
        label4.setForeground(new Color(-1320014));
        label5.setForeground(new Color(-1320014));
        label6.setForeground(new Color(-1320014));
        label7.setForeground(new Color(-1320014));
        label8.setForeground(new Color(-1320014));
        label9.setForeground(new Color(-1320014));

        button0.setBackground(new Color(-11579569));
        button1.setBackground(new Color(-11579569));


        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(label1,gbc);

        textField1.addKeyListener(controller);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(textField1,gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(label2,gbc);

        textField2.addKeyListener(controller);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(textField2,gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(label3, gbc);

        textField3.addKeyListener(controller);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(textField3,gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(label4,gbc);

        textField4.addKeyListener(controller);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(textField4,gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(label5,gbc);

        textField5.addKeyListener(controller);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(textField5,gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(label6,gbc);

        textField6.addKeyListener(controller);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(textField6,gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        mainPanel.add(label7,gbc);

        textField7.addKeyListener(controller);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(textField7,gbc);

        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label8.setHorizontalAlignment(JLabel.CENTER);
        label9.setHorizontalAlignment(JLabel.CENTER);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(label8,gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        textField8.setEditable(false);
        mainPanel.add(textField8,gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(button0,gbc);
        button0.addActionListener(controller);


        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(button1,gbc);
        button1.addActionListener(controller);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(grid,gbc);


        jTextArea = new JTextArea(10,46);
        jTextArea.setFont(jTextArea.getFont().deriveFont(13f));
        JScrollPane scrollableTextArea = new JScrollPane(jTextArea);
        scrollableTextArea.getHorizontalScrollBar().setBackground(new Color(-1337021));
        scrollableTextArea.getHorizontalScrollBar().setUI(new BasicScrollBarUI(){
            @Override
            protected void configureScrollBarColors() {
                super.configureScrollBarColors();
                this.thumbColor = new Color(0xFF2D2B2B);
            }
        });
        scrollableTextArea.getVerticalScrollBar().setBackground(new Color(-1337021));
        scrollableTextArea.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
            @Override
            protected void configureScrollBarColors() {
                super.configureScrollBarColors();
                this.thumbColor = new Color(0xFF2D2B2B);
            }
        });
        jTextArea.setEditable(true);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollableTextArea.setMaximumSize(new Dimension(20,20));
        grid.add(scrollableTextArea);
        jTextArea.setBackground(new Color(-1337021));
        grid.setPreferredSize(new Dimension(50, 200));



        this.add(mainPanel);
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public JButton getButton0() {
        return button0;
    }

    public JButton getButton1() {
        return button1;
    }

    public JTextField getTextField8() {
        return textField8;
    }

    public JTextField getTextField7() {
        return textField7;
    }

    public JTextField getTextField6() {
        return textField6;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }
}
