import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;

import java.rmi.RemoteException;
import java.rmi.Remote;


public class App implements ActionListener,Ap {

    OperationHandler calc;

    int opPressed, numPressed, decPressed;

    JFrame f;
    JTextField t;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bAdd,bSub,bMult,bDiv,bClr,bDec,bDel,bEq;


    public App() {


        opPressed = 0;
        numPressed = 0;
        decPressed = 0;

        calc = new OperationHandler(); // initialize a calculator to proceed with operations
        f = new JFrame("Calculator App");
        t = new JTextField("");
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
        f.setResizable(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            t.setText(t.getText().concat("1"));
            numPressed++;
        }

        if(e.getSource() == b2) {
            t.setText(t.getText().concat("2"));
            numPressed++;
        }

        if(e.getSource() == b3) {
            t.setText(t.getText().concat("3"));
            numPressed++;
        }

        if(e.getSource() == b4) {
            t.setText(t. getText().concat("4"));
            numPressed++;
        }


        if(e.getSource() == b5) {
            t.setText(t.getText().concat("5"));
            numPressed++;
        }

        if(e.getSource() == b6) {
            t.setText(t.getText().concat("6"));
            numPressed++;
        }

        if(e.getSource() == b7) {
            t.setText(t.getText().concat("7"));
            numPressed++;
        }

        if(e.getSource() == b8) {
            t.setText(t.getText().concat("8"));
            numPressed++;
        }

        if(e.getSource() == b9) {
            t.setText(t.getText().concat("9"));
            numPressed++;
        }

        if(e.getSource() == b0) {
            t.setText(t.getText().concat("0"));
            numPressed++;
        }

        if(e.getSource() == bDec){
            if ( numPressed != 0 && decPressed == 0 ) {
                t.setText(t.getText().concat("."));
                decPressed++;
            }
            else {  }
        }

        if(e.getSource() == bAdd) {
            if ( numPressed != 0 ) {
                if ( opPressed == 0 ) {
                    calc.opX = Double.parseDouble(t.getText());
                    calc.opNumber = 1;
                    t.setText(t.getText().concat("+"));
                    opPressed = 1;
                    numPressed = 0;
                    decPressed = 0;
                }
                else
                    JOptionPane.showMessageDialog(f, "You can only do one-step calculations!");
            } else {  }
        }

        if(e.getSource() == bSub) {
            if ( numPressed != 0 ) {
                if ( opPressed == 0 ) {
                    calc.opX = Double.parseDouble(t.getText());
                    calc.opNumber = 2;
                    t.setText(t.getText().concat("-"));
                    opPressed = 1;
                    numPressed = 0;
                    decPressed = 0;
                }
                else
                    JOptionPane.showMessageDialog(f, "You can only do one-step calculations!");
            } else {  }
        }

        if(e.getSource() == bMult) {
            if ( numPressed != 0 ) {
                if ( opPressed == 0 ) {
                    calc.opX = Double.parseDouble(t.getText());
                    calc.opNumber = 3;
                    t.setText(t.getText().concat("×"));
                    opPressed = 1;
                    numPressed = 0;
                    decPressed = 0;
                }
                else
                    JOptionPane.showMessageDialog(f, "You can only do one-step calculations!");
            } else {  }
        }

        if(e.getSource() == bDiv) {
            if ( numPressed != 0 ) {
                if ( opPressed == 0 ) {
                    calc.opX = Double.parseDouble(t.getText());
                    calc.opNumber = 4;
                    t.setText(t.getText().concat("/"));
                    opPressed = 1;
                    numPressed = 0;
                    decPressed = 0;
                }
                else
                    JOptionPane.showMessageDialog(f, "You can only do one-step calculations!");
            } else {  }
        }

        if(e.getSource() == bEq) {
            if ( opPressed == 1 && numPressed != 0) {
                calc.opY = Double.parseDouble(t.getText().split("\\+|\\-|\\×|\\/")[1]);
                if ( calc.isset() ) {
                    calc.calculate();
                }
                t.setText("" + calc.result);
                opPressed = 0;
                decPressed = 1;
            }
            else {  }

        }

        if(e.getSource() == bClr){
            t.setText("");
            opPressed = 0;
            numPressed = 0;
        }


        if(e.getSource() == bDel) {
            String s = t.getText(); //save it for later use inside loop
            t.setText("");
            for(int i = 0 ; i < s.length()-1 ; i++)
                t.setText(t.getText() + s.charAt(i));
        }

    }

//    public static void main(String[] args) {
//      //   App app = new App();
//    }

}