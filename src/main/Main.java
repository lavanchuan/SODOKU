package main;

import DatabaseManager.FileManager;
import gui_game.GamePanle;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        GamePanle gp = new GamePanle();
        while(gp.isContinue){
            gp.start();
        }

//        String readString = FileManager.readFile("src/Databate/HightPoint.txt");
//        JFrame window = new JFrame();
//        window.setSize(800, 600);
//        window.setLocationRelativeTo(null);
//        window.setDefaultCloseOperation(3);
//        window.getContentPane().setBackground(Color.black);
//        window.setVisible(true);
//        JOptionPane.showMessageDialog(window, readString);
    }

}
