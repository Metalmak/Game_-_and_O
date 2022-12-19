package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class XOGame implements ActionListener {

    JFrame frame = new JFrame();
    Random random = new Random();
    JPanel info_panel = new JPanel();
    JPanel panel_button = new JPanel();
    JLabel text = new JLabel();
    JButton [] buttons = new  JButton[9];
    boolean first_playet;


    XOGame(){ // конструктор
        frame.setSize(800,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground( new Color( 70,70,70 ));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text.setBackground( new Color(30,30,30));
        text.setForeground(new Color(30,200,100));
        text.setFont(new Font("Ink Free",Font.BOLD, 50));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("X <-> O Game");
        text.setOpaque(true);

        info_panel.setLayout(new BorderLayout());
        info_panel.setBounds(0,0,800,200);
        info_panel.add(text);
        frame.add(info_panel,BorderLayout.NORTH);

        panel_button.setLayout(new GridLayout(3,3));
        panel_button.setBackground(new Color(200,200,200));

        for (int i=0; i < 9; i++){
            buttons [i] = new JButton();
            panel_button.add(buttons[i]);
            buttons[i].setFont(new Font("MVbolt",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        frame.add(panel_button);
        setFirst_playet ();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; 1 < 9; i++)
            if (e.getSource() == buttons[i]) {
                if (first_playet) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(200, 110, 0));
                        buttons[i].setText("X");
                        first_playet = false;
                        text.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 200));
                        buttons[i].setText("O");
                        first_playet = true;
                        text.setText("X turn");
                        check();
                    }
                }


            }


    }
    public void check(){
        // condition X
        if ((buttons[0].getText()=="X") && (buttons[1].getText()=="X")&& (buttons[2].getText()=="X")) {
            xWins (0,1,2);
        }
        if ((buttons[3].getText()=="X") && (buttons[4].getText()=="X")&& (buttons[5].getText()=="X")) {
            xWins (3,4,5);
        }
        if ((buttons[6].getText()=="X") && (buttons[7].getText()=="X")&& (buttons[8].getText()=="X")) {
            xWins (6,7,8);
        }
        if ((buttons[0].getText()=="X") && (buttons[3].getText()=="X")&& (buttons[6].getText()=="X")) {
            xWins (0,3,6);
        }
        if ((buttons[1].getText()=="X") && (buttons[4].getText()=="X")&& (buttons[7].getText()=="X")) {
            xWins (1,4,7);
        }
        if ((buttons[2].getText()=="X") && (buttons[5].getText()=="X")&& (buttons[8].getText()=="X")) {
            xWins (2,5,8);
        }

        if ((buttons[0].getText()=="X") && (buttons[4].getText()=="X")&& (buttons[8].getText()=="X")) {
            xWins (0,4,8);
        }
        if ((buttons[2].getText()=="X") && (buttons[4].getText()=="X")&& (buttons[6].getText()=="X")) {
            xWins (2,4,6);
        }


        // condition O
        if ((buttons[0].getText()=="O") && (buttons[1].getText()=="O")&& (buttons[2].getText()=="O")) {
            oWins(0,1,2);
        }
        if ((buttons[3].getText()=="O") && (buttons[4].getText()=="O")&& (buttons[5].getText()=="O")) {
            oWins(3,4,5);
        }
        if ((buttons[6].getText()=="O") && (buttons[7].getText()=="O")&& (buttons[8].getText()=="O")) {
            oWins(6,7,8);
        }
        if ((buttons[0].getText()=="O") && (buttons[3].getText()=="O")&& (buttons[6].getText()=="O")) {
            oWins(0,3,6);
        }
        if ((buttons[1].getText()=="O") && (buttons[4].getText()=="O")&& (buttons[7].getText()=="O")) {
            oWins(1,4,7);
        }
        if ((buttons[2].getText()=="O") && (buttons[5].getText()=="O")&& (buttons[8].getText()=="O")) {
            oWins(2,5,8);
        }

        if ((buttons[0].getText()=="O") && (buttons[4].getText()=="O")&& (buttons[8].getText()=="O")) {
            oWins(0,4,8);
        }
        if ((buttons[2].getText()=="O") && (buttons[4].getText()=="O")&& (buttons[6].getText()=="O")) {
            oWins(2,4,6);
        }

    }
    public void xWins (int a, int b, int c){
        buttons[a].setBackground(Color.CYAN);
        buttons[b].setBackground(Color.CYAN);
        buttons[c].setBackground(Color.CYAN);

        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("Wins X");
    }

    public void oWins (int a, int b, int c){
        buttons[a].setBackground(Color.CYAN);
        buttons[b].setBackground(Color.CYAN);
        buttons[c].setBackground(Color.CYAN);

        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        text.setText("Wins O");
    }
    public void setFirst_playet (){
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();

        }

        if(random.nextInt(2)==0){
            first_playet = true;
            text.setText("First turn X");

        } else {
            first_playet = false;
            text.setText("First turn O");
        }
    }
}
