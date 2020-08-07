import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Double leftOperand;
    private Double rightOperand;
    private Operations calcOperation;

    public Calculator()
    {
        zerobut.addActionListener(new NumberbutClicked(zerobut.getText()));
        onebut.addActionListener(new NumberbutClicked(onebut.getText()));
        twobut.addActionListener(new NumberbutClicked(twobut.getText()));
        threebut.addActionListener(new NumberbutClicked(threebut.getText()));
        fourbut.addActionListener(new NumberbutClicked(fourbut.getText()));
        fivebut.addActionListener(new NumberbutClicked(fivebut.getText()));
        sixbut.addActionListener(new NumberbutClicked(sixbut.getText()));
        sevenbut.addActionListener(new NumberbutClicked(sevenbut.getText()));
        eightbut.addActionListener(new NumberbutClicked(eightbut.getText()));
        ninebut.addActionListener(new NumberbutClicked(ninebut.getText()));

        addbut.addActionListener(new operationbutclicked(Operations.ADDITION));
        minusbut.addActionListener(new operationbutclicked(Operations.SUBTRACTION));
        multiplybut.addActionListener(new operationbutclicked(Operations.MULTIPLICATION));
        dividebut.addActionListener(new operationbutclicked(Operations.DIVISION));
        percentbut.addActionListener(new operationbutclicked(Operations.PERCENTAGE));

        clearbut.addActionListener(new ClearBtnClicked());
        equalsbut.addActionListener(new equalsclicked());
        digitbut.addActionListener(new DigitBtnClicked());
        signbut.addActionListener(new SignBtnClicked());
    }

    private class NumberbutClicked implements ActionListener{
        private String value;

        public NumberbutClicked(String value)
        {
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(leftOperand==0 || leftOperand == null)
            {
                value = results.getText() + value;
            }
            else{
                rightOperand = Double.valueOf(value);
            }
            results.setText(value);
        }
    }

    private class operationbutclicked implements ActionListener{
        private Operations operation;

        public operationbutclicked(Operations operation)

        {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calcOperation = operation;
            leftOperand = Double.valueOf(results.getText());
        }
    }

    private class ClearBtnClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            results.setText("");
            leftOperand = 0.0;
            rightOperand = 0.0;
        }
    }

    private class DigitBtnClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            results.setText(results.getText() + ".");
        }
    }

    private class SignBtnClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            results.setText("-"+ results.getText());
        }
    }

    private class equalsclicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Double output = calcOperation.getOperator().applyAsDouble(leftOperand, rightOperand);
            results.setText(output%1==0?String.valueOf(output.intValue()):String.valueOf(output));
            leftOperand = 0.0;
            rightOperand = 0.0;
        }
    }

    public static void main(String args[])
    {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}