package gui_game;

import DatabaseManager.FileManager;
import control.Array2D;
import control.LineRandom;
import java.util.ArrayList;
import java.util.Scanner;
import player.Player;
import player.PlayerHightPoint;

public class GamePanle {

    public int array2D[][];
    public final int gameSize = 3;
    public final int size = gameSize * gameSize;
    public LineRandom lr = new LineRandom(this);
    public Array2D array2DControl = new Array2D(this, lr);
    public Player player = new Player(this);
    long timeStart, timeEnd;
    long timeMin;
    public boolean isContinue = true;

    public GamePanle() {

        timeMin = FileManager.readFileInt("src/Databate/TimeMin.txt");
        array2D = new int[gameSize][gameSize];
        System.out.println("Time completion best: " + timeMin);
    }

    public void setGame() {

        array2DControl.setArray2D();
    }

    public void start() {

        System.out.print("New Game (n)\n"
                + "Select Hight Point (s)\n"
                + "Exit (e)\n");
        System.out.print("Chooes: ");
        char chooes = (new Scanner(System.in)).next().charAt(0);
        switch (chooes) {
            case 'n':
                newGame();
                timeStart = System.nanoTime();
                play();
                end();
                break;
            case 's':
                String getFile = (FileManager.readFile("src/Databate/HightPoint.txt"));
                String[] playerHight = getFile.split("\n");
                ArrayList<PlayerHightPoint> php = new ArrayList<>();
                for(int i = 0; i < playerHight.length; i++){
                    String name = playerHight[i].split(" ")[0];
                    long time = Long.parseLong(playerHight[i].split(" ")[1]);
                    boolean isAdded = false;
                    for(int j = 0; j < php.size(); j++){
                        if(name.equals(php.get(j).getName())){
                            if(php.get(j).getTime() > time){
                                php.get(j).setTime(time);
                            }
                            isAdded = true;
                            break;
                        }
                    }
                    if(isAdded){
                        continue;
                    } else {
                        php.add(new PlayerHightPoint(name, time));
                    }
                }
                sortPoint(php);
                for(int i = 0; i < php.size(); i++){
                    php.get(i).info();
                }
                break;
            case 'e':
                isContinue = false;
                break;
        }

    }
    
    public void sortPoint(ArrayList<PlayerHightPoint> php){
        
        for(int i = 0; i < php.size()-1; i++){
            for(int j = i+1; j < php.size(); j++){
                if(php.get(i).getTime() > php.get(j).getTime()){
                    PlayerHightPoint p = 
                            new PlayerHightPoint(php.get(i).getName(), php.get(i).getTime());
                    php.get(i).setName(php.get(j).getName());
                    php.get(i).setTime(php.get(j).getTime());
                    php.get(j).setName(p.getName());
                    php.get(j).setTime(p.getTime());
                }
            }
        }
    }

    public void end() {

        timeEnd = System.nanoTime();
        long time = (timeEnd - timeStart) / 1000000000;
        System.out.println("Time: " + time + " s");
        if (timeMin > time) {
            timeMin = time;
        }
        System.out.println("Time best: " + timeMin);
        if (time == timeMin) {
            System.out.print("You want save hight point (y/n): ");
            char chooes = (new Scanner(System.in)).next().charAt(0);
            if (chooes == 'y') {
                System.out.println("What is you name?");
                System.out.print("My name is ");
                String name = (new Scanner(System.in)).next();
                FileManager.writeFile("src/Databate/HightPoint.txt", name + " " + timeMin);
            }
        }

    }

    public void newGame() {

        System.out.println("Time completion best: " + timeMin);
        array2D = new int[gameSize][gameSize];
        lr = new LineRandom(this);
        array2DControl = new Array2D(this, lr);
        array2DControl.setArray2D();
        System.out.println("******");
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("******");
    }

    public void play() {

//        System.out.println("******");
//        for (int i = 0; i < gameSize; i++) {
//            for (int j = 0; j < gameSize; j++) {
//                System.out.print(array2D[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("******");
        while (array2DControl.fullArray < size) {
            System.out.println("So Luong cac chu so co the dien");
            for (int i = 0; i < gameSize; i++) {
                System.out.println((i + 1) + ": " + (gameSize - array2DControl.amountNumber[i]));
            }

            player.next();

            System.out.println("******");
            for (int i = 0; i < gameSize; i++) {
                for (int j = 0; j < gameSize; j++) {
                    System.out.print(array2D[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("******");
        }
    }
}
