import javax.swing.*;
import java.awt.event.*;


public class Calc implements ActionListener {

    OperationHandler calc;

    int opPressed;
    String opPressedMsg;


    JFrame f;
    JTextField t;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bAdd,bSub,bMult,bDiv,bClr,bDec,bDel,bEq;


    public Calc() {

        opPressed = 0;
        opPressedMsg = "You can only do one-step calculations!";

        calc = new OperationHandler(); // initialize a calculator object to calculate
        f = new JFrame("Calculator App");
        t = new JTextField();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bDiv = new JButton("/");
        bMult = new JButton("×");
        bSub = new JButton("-");
        bAdd = new JButton("+");
        bDec = new JButton(".");
        bEq = new JButton("=");
        bDel = new JButton("Delete");
        bClr = new JButton("Clear");

        t.setBounds(30,40,280,30);
        b7.setBounds(40,100,50,40);
        b8.setBounds(110,100,50,40);
        b9.setBounds(180,100,50,40);
        bDiv.setBounds(250,100,50,40);

        b4.setBounds(40,170,50,40);
        b5.setBounds(110,170,50,40);
        b6.setBounds(180,170,50,40);
        bMult.setBounds(250,170,50,40);

        b1.setBounds(40,240,50,40);
        b2.setBounds(110,240,50,40);
        b3.setBounds(180,240,50,40);
        bSub.setBounds(250,240,50,40);

        bDec.setBounds(40,310,50,40);
        b0.setBounds(110,310,50,40);
        bEq.setBounds(180,310,50,40);
        bAdd.setBounds(250,310,50,40);

        bDel.setBounds(60,380,100,40);
        bClr.setBounds(180,380,100,40);

        f.add(t);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(bDiv);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(bMult);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(bSub);
        f.add(bDec);
        f.add(b0);
        f.add(bEq);
        f.add(bAdd);
        f.add(bDel);
        f.add(bClr);

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(350,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null); // to center the window

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bAdd.addActionListener(this);
        bDiv.addActionListener(this);
        bMult.addActionListener(this);
        bSub.addActionListener(this);
        bDec.addActionListener(this);
        bEq.addActionListener(this);
        bDel.addActionListener(this);
        bClr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1)
            t.setText(t.getText().concat("1"));

        if(e.getSource() == b2)
            t.setText(t.getText().concat("2"));

        if(e.getSource() == b3)
            t.setText(t.getText().concat("3"));

        if(e.getSource() == b4)
            t.setText(t.getText().concat("4"));

        if(e.getSource() == b5)
            t.setText(t.getText().concat("5"));

        if(e.getSource() == b6)
            t.setText(t.getText().concat("6"));

        if(e.getSource() == b7)
            t.setText(t.getText().concat("7"));

        if(e.getSource() == b8)
            t.setText(t.getText().concat("8"));

        if(e.getSource() == b9)
            t.setText(t.getText().concat("9"));

        if(e.getSource() == b0)
            t.setText(t.getText().concat("0"));

        if(e.getSource() == bDec)
            t.setText(t.getText().concat("."));

        if(e.getSource() == bAdd) {
            if ( opPressed == 0 ) {
                calc.opX = Double.parseDouble(t.getText());
                calc.opNumber = 1;
                t.setText(t.getText().concat("+"));
                opPressed = 1;
            }
            else
                JOptionPane.showMessageDialog(f, opPressedMsg);
        }

        if(e.getSource() == bSub) {
            if ( opPressed == 0 ) {
                calc.opX = Double.parseDouble(t.getText());
                calc.opNumber = 2;
                t.setText(t.getText().concat("-"));
                opPressed = 1;
            }
            else
                JOptionPane.showMessageDialog(f, opPressedMsg);
        }

        if(e.getSource() == bMult) {
            if ( opPressed == 0 ) {
                calc.opX = Double.parseDouble(t.getText());
                calc.opNumber = 3;
                t.setText(t.getText().concat("×"));
                opPressed = 1;
            }
            else
                JOptionPane.showMessageDialog(f, opPressedMsg);
        }

        if(e.getSource() == bDiv) {
            if ( opPressed == 0 ) {
                calc.opX = Double.parseDouble(t.getText());
                calc.opNumber = 4;
                t.setText(t.getText().concat("/"));
                opPressed = 1;
            }
            else
                JOptionPane.showMessageDialog(f, opPressedMsg);

        }

        if(e.getSource() == bEq) {
            calc.opY = Double.parseDouble(t.getText().split("\\+|\\-|\\×|\\/")[1]);
            if ( calc.isset() ) {
                calc.calculate();
            }
            t.setText("" + calc.result);
            opPressed = 0;
        }

        if(e.getSource() == bClr)
            t.setText("");

        if(e.getSource() == bDel) {
            String s = t.getText(); //save it for later use inside loop
            t.setText("");
            for(int i = 0 ; i < s.length()-1 ; i++)
                t.setText(t.getText() + s.charAt(i));
        }

    }

    public static void main(String[] args) {
        new Calc();
    }


}