import javax.swing.*;
import java.awt.event.*;

import java.rmi.RemoteException;
import java.rmi.Remote;


public class Calculator implements ActionListener {

    OperationHandler calc;

    boolean opPressed, numPressed, decPressed;      // operator staters that's what we call them, explained inside the constructor

    JFrame f;
    JTextField t;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bAdd,bSub,bMult,bDiv,bClr,bDec,bDel,bEq;


    public Calculator() {

        opPressed = false;      // this operator staters will be used
        numPressed = false;     // inside overridden actionPerformed()
        decPressed = false;     // to set the correct priority for calculator Calculator

        f = new JFrame("Calculator Calculator");
        t = new JTextField("");                     // this will be representing calculation monitor
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
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close when clicking EXIT
        f.setResizable(true);
        f.setLocationRelativeTo(null); // to center the Calculator window

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
            numPressed = true;      // numPressed stater will be set to true each time a new number key is pressed.
        }                           // this is done to prevent pressing + or - (operator) keys which cause errors.
                                    // this action is used on each number keys
        if(e.getSource() == b2) {
            t.setText(t.getText().concat("2"));
            numPressed = true;
        }

        if(e.getSource() == b3) {
            t.setText(t.getText().concat("3"));
            numPressed = true;
        }

        if(e.getSource() == b4) {
            t.setText(t. getText().concat("4"));
            numPressed = true;
        }

        if(e.getSource() == b5) {
            t.setText(t.getText().concat("5"));
            numPressed = true;
        }

        if(e.getSource() == b6) {
            t.setText(t.getText().concat("6"));
            numPressed = true;
        }

        if(e.getSource() == b7) {
            t.setText(t.getText().concat("7"));
            numPressed = true;
        }

        if(e.getSource() == b8) {
            t.setText(t.getText().concat("8"));
            numPressed = true;
        }

        if(e.getSource() == b9) {
            t.setText(t.getText().concat("9"));
            numPressed = true;
        }

        if(e.getSource() == b0) {
            t.setText(t.getText().concat("0"));
            numPressed = true;
        }

        if(e.getSource() == bDec){
            if ( numPressed && !decPressed ) {        // this checks if a number is pressed because without number you can't put "." representing conversion to decimal
                t.setText(t.getText().concat("."));   // and checks that . is not pressed before. This is to prevent user from pressing .. twice or more.Otherwise text parser won't parse it properly.
                decPressed = true;
            }
            else {  }
        }

        if(e.getSource() == bAdd) {
            if ( numPressed ) {         // so this is Calculatorlied to all operator buttons simply to press any operator key a number has to be pressed first
                if ( !opPressed ) {     // this is Calculatorlied to all operators as well and simply this is to prevent user from pressing 2 different or same operator keys
                    try {
                        calc.setX(Double.parseDouble(t.getText()));
                        calc.setOpNumber(1);  // pressed without having a number entered first.
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                    t.setText(t.getText().concat("+"));
                    opPressed = true;           // this stater is set to true to prevent from being pressed more than once
                    numPressed = false;         // to satisfy the condition of any operator keys.
                    decPressed = false;         // to set initial state
                }
                else
                    JOptionPane.showMessageDialog(f, "You can only do one-step calculations!");
            } else {  }        // so in all these 4 (+:-:×:/) operations we do the same steps as mentioned above with comments,
        }                      // and the reason why we used nested if's is that in second if's else part we want to do give an alert message
                                //  where in the first if's else (general else) we don't want to do anything

         if(e.getSource() == bSub) {
            if ( numPressed ) {
                if ( !opPressed ) {
                    try {
                        calc.setX(Double.parseDouble(t.getText()));
                        calc.setOpNumber(2);
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                    t.setText(t.getText().concat("-"));
                    opPressed = true;
                    numPressed = false;
                    decPressed = false;
                }
                else
                    JOptionPane.showMessageDialog(f, "You can only do one-step calculations!");
            } else {  }
        }

        if(e.getSource() == bMult) {
            if ( numPressed ) {
                if ( !opPressed ) {
                    try {
                        calc.setX(Double.parseDouble(t.getText()));
                        calc.setOpNumber(3);
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                    t.setText(t.getText().concat("×"));
                    opPressed = true;
                    numPressed = false;
                    decPressed = false;
                }
                else
                    JOptionPane.showMessageDialog(f, "You can only do one-step calculations!");
            } else {  }
        }

        if(e.getSource() == bDiv) {
            if ( numPressed ) {
                if ( !opPressed ) {
                    try {
                        calc.setX(Double.parseDouble(t.getText()));
                        calc.setOpNumber(4);
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }

                    t.setText(t.getText().concat("/"));
                    opPressed = true;
                    numPressed = false;
                    decPressed = false;
                }
                else
                    JOptionPane.showMessageDialog(f, "You can only do one-step calculations!");
            } else {  }
        }

        if(e.getSource() == bEq) { // So equal button is a bit different from that of operation key buttons that's why seperate comments for it

            if ( opPressed && numPressed ) {// Here we check if the operation button and any number is pressed, then do the steps
                try {

                            calc.setY(Double.parseDouble(t.getText().split("\\+|\\-|\\×|\\/")[1]));   // so after = is pressed, second operand has to be set but since we use textfield we need to parse it to double
                    if(calc.getY()== 0 && calc.getOpNum()==4) {

                        JOptionPane.showMessageDialog(f, "Exception : Division by Zero!\n");
                        t.setText("Error");

                    }
                     else if ( calc.isset() ) {   // to check if operands and operation Number is set
                                                 // but while parsing, we need to take the number before the operator sign so we combined parseDouble() and split function
                                                // and added the regex which simply means either + or one of these - , × , / signs.
                         calc.setReady(true); // in Client side it checks if Ready is true -> it invokes calculation
                      }

                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
                opPressed = false;   // operator stater can be set to false to further allow user to enter one of operators
                decPressed = true;   // the same implies to decimal stater
            }
            else {  }
        }

        if(e.getSource() == bClr){
            t.setText("");
            opPressed = false;      // we do this to revert back the changes to its initial state
            numPressed = false;     // as if no operator has selected because that's what its initial version is
            decPressed = false;     // every state was set to false when the object we created
        }

        if(e.getSource() == bDel) {
            String s = t.getText();  //save it for later use inside loop
            t.setText("");
            for(int i = 0 ; i < s.length()-1 ; i++)
                t.setText(t.getText() + s.charAt(i));
        }

    }

    public static void main(String[] args) {
    }

}