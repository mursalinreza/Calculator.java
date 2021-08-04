package com.RMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    ImageIcon icon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\Universal Calculator\\src\\images\\calculator.png");
    JFrame frame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[18];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,clrButton,delButton;
    JButton negButton,sqrButton,powButton,piButton;
    JButton expButton,perButton,recButton,sinButton;
    JButton cosButton,tanButton;

    JPanel panel;
    Font myFont = new Font("Ink Free",Font.BOLD,30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    final float PI = 3.14159F;
    final float E = 2.718281F;
    Calculator(){
        frame = new JFrame("Universal Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,600);
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(42,25,600,50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(Color.gray);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        negButton = new JButton("(-)");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("CLR");
        delButton = new JButton("DEL");
        sqrButton = new JButton("_/-");
        powButton = new JButton("^");
        piButton = new JButton("Pi");
        expButton = new JButton("e");
        perButton = new JButton("%");
        recButton = new JButton("1/x");
        sinButton = new JButton("SIN");
        cosButton = new JButton("COS");
        tanButton= new JButton("TAN");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = negButton;
        functionButton[5] = decButton;
        functionButton[6] = equButton;
        functionButton[7] = clrButton;
        functionButton[8] = delButton;
        functionButton[9] = sqrButton;
        functionButton[10] = powButton;
        functionButton[11] = piButton;
        functionButton[12] = expButton;
        functionButton[13] = perButton;
        functionButton[14] = recButton;
        functionButton[15] = sinButton;
        functionButton[16] = cosButton;
        functionButton[17] = tanButton;

        for(int i = 0; i < 18; i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setBorder(BorderFactory.createLoweredBevelBorder());
            functionButton[i].setFocusable(false);
            functionButton[i].setBackground(Color.ORANGE);
            functionButton[i].setForeground(Color.white);
        }
        for(int j = 0; j < 10;  j++){
            numberButton[j] = new JButton(String.valueOf(j));
            numberButton[j].addActionListener(this);
            numberButton[j].setFont(myFont);
            numberButton[j].setFocusable(false);
            numberButton[j].setBorder(BorderFactory.createLoweredBevelBorder());
            numberButton[j].setForeground(Color.white);
            numberButton[j].setBackground(Color.BLACK);
        }

        panel = new JPanel();
        panel.setBounds(42,100,600,400);
        panel.setLayout(new GridLayout(5,5,5,5));
        panel.setBackground(Color.DARK_GRAY);
        panel.setBorder(BorderFactory.createLoweredSoftBevelBorder());

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(negButton);
        panel.add(sinButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(piButton);
        panel.add(cosButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(expButton);
        panel.add(tanButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(perButton);
        panel.add(recButton);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(sqrButton);
        panel.add(powButton);

        decButton.setBackground(Color.BLACK);
        decButton.setForeground(Color.white);
        equButton.setBackground(Color.BLACK);
        equButton.setForeground(Color.gray);
        frame.add(panel);
        frame.add(textField);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(Color.BLACK);

    }

    public static void main(String[] args){
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int k = 0; k < 10 ; k++){
            if(e.getSource() == numberButton[k]){
                textField.setText(textField.getText().concat(String.valueOf(k)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == powButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator){
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
                case'^':
                    result = Math.pow(num1,num2);
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String delete = textField.getText();
            textField.setText("");
            for(int i = 0; i< delete.length()-1;i++){
                textField.setText(textField.getText() + delete.charAt(i));
            }
        }
        if(e.getSource() == recButton){
            num1 = Double.parseDouble(textField.getText());
            result = 1/num1 ;
            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
        if(e.getSource() == perButton){
           num1 = Double.parseDouble(textField.getText());
           result = (num1/100);
           textField.setText(String.valueOf(result));
        }
        if(e.getSource() == piButton){
           num1 = Double.parseDouble(textField.getText());
           result = num1 * PI;
           textField.setText(String.valueOf(result));
        }
        if(e.getSource() == sqrButton){
            num1 = Double.parseDouble(textField.getText());
            result = Math.sqrt(num1);
            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == expButton){
            num1 = Double.parseDouble(textField.getText());
            result = num1 * E;
            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == sinButton){
            num1 = Double.parseDouble(textField.getText());
            result = Math.sin(num1);
            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == cosButton){
            num1 = Double.parseDouble(textField.getText());
            result = Math.cos(num1);
            textField.setText(String.valueOf(result));
        }
        if(e.getSource() == tanButton){
            num1 = Double.parseDouble(textField.getText());
            result = Math.tan(num1);
            textField.setText(String.valueOf(result));
        }
    }
}
