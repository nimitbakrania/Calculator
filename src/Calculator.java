import javax.swing.*;

public class Calculator {

    private JTextField results;
    private JButton clearbut;
    private JButton signbut;
    private JButton percentbut;
    private JButton dividebut;
    private JButton sevenbut;
    private JButton fourbut;
    private JButton eightbut;
    private JButton fivebut;
    private JButton ninebut;
    private JButton sixbut;
    private JButton multiplybut;
    private JButton minusbut;
    private JButton addbut;
    private JButton onebut;
    private JButton twobut;
    private JButton threebut;
    private JButton zerobut;
    private JButton equalsbut;
    private JButton digitbut;
    private JButton changeclr;
    private javax.swing.JPanel JPanel;



    static void main(String args[])
    {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
