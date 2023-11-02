import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField tfDisplay;
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear;

    private double num1, num2, result;
    private boolean addition, subtraction, multiplication, division;

    public SimpleCalculator() {
        setTitle("州哥计算器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        JPanel panel = new JPanel(new GridLayout(4, 4));

        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);


        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivide = new JButton("/");
        btnEquals = new JButton("=");
        btnClear = new JButton("C");

        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        btnEquals.addActionListener(this);
        btnClear.addActionListener(this);

        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btnDivide);

        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btnMultiply);

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btnSubtract);

        panel.add(btn0);
        panel.add(btnClear);
        panel.add(btnEquals);
        panel.add(btnAdd);

        setLayout(new BorderLayout());
        add(tfDisplay, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn0) {
            tfDisplay.setText(tfDisplay.getText() + "0");
        } else if (e.getSource() == btn1) {
            tfDisplay.setText(tfDisplay.getText() + "1");
        } else if (e.getSource() == btn2) {
            tfDisplay.setText(tfDisplay.getText() + "2");
        } else if (e.getSource() == btn3) {
            tfDisplay.setText(tfDisplay.getText() + "3");
        } else if (e.getSource() == btn4) {
            tfDisplay.setText(tfDisplay.getText() + "4");
        } else if (e.getSource() == btn5) {
            tfDisplay.setText(tfDisplay.getText() + "5");
        } else if (e.getSource() == btn6) {
            tfDisplay.setText(tfDisplay.getText() + "6");
        } else if (e.getSource() == btn7) {
            tfDisplay.setText(tfDisplay.getText() + "7");
        } else if (e.getSource() == btn8) {
            tfDisplay.setText(tfDisplay.getText() + "8");
        } else if (e.getSource() == btn9) {
            tfDisplay.setText(tfDisplay.getText() + "9");
        } else if (e.getSource() == btnAdd) {
            num1 = Double.parseDouble(tfDisplay.getText());
            addition = true;
            tfDisplay.setText("");
        } else if (e.getSource() == btnSubtract) {
            num1 = Double.parseDouble(tfDisplay.getText());
            subtraction = true;
            tfDisplay.setText("");
        } else if (e.getSource() == btnMultiply) {
            num1 = Double.parseDouble(tfDisplay.getText());
            multiplication = true;
            tfDisplay.setText("");
        } else if (e.getSource() == btnDivide) {
            num1 = Double.parseDouble(tfDisplay.getText());
            division = true;
            tfDisplay.setText("");
        } else if (e.getSource() == btnEquals) {
            num2 = Double.parseDouble(tfDisplay.getText());

            if (addition == true) {
                result = num1 + num2;
                addition = false;
            } else if (subtraction == true) {
                result = num1 - num2;
                subtraction = false;
            } else if (multiplication == true) {
                result = num1 * num2;
                multiplication = false;
            } else if (division == true) {
                result = num1 / num2;
                division = false;
            }

            tfDisplay.setText(String.valueOf(result));
        } else if (e.getSource() == btnClear) {
            tfDisplay.setText("");
        }
    }


}

class cc {
    public static void main(String[] args) {
        new SimpleCalculator();
    }
}