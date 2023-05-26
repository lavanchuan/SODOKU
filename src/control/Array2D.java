
package control;

import Element.Point;
import gui_game.GamePanle;
import java.util.ArrayList;


public class Array2D {
    
    public GamePanle gp;
    public LineRandom lr;
    public int[] amountNumber;
    public ArrayList<Point> notEdit;
    public int fullArray = 0;
    
    public Array2D(GamePanle gp, LineRandom lr){
        
        this.gp = gp;
        this.lr = lr;
        amountNumber = new int[gp.gameSize];
        notEdit = new ArrayList<>();
    }
    
    public void getAmountNumber(){
        
        for(int i = 0; i < gp.gameSize; i++){
            for(int j = 0; j < gp.gameSize; j++){
                if(gp.array2D[i][j]!=0){
                    amountNumber[gp.array2D[i][j]-1]++;
                }
            }
        }
    }
    
    public void setArray2D(){
        
        int isFalse = (int)(Math.random()*10)%gp.gameSize;
        int lineSet = (int)(Math.random()*10)%gp.gameSize;
        for(int i = 0; i < gp.gameSize; i++){
            if(i!=isFalse){
                 gp.array2D[lineSet][i] = lr.getLine().get(i);
                 notEdit.add(new Point(lineSet, i));
                 fullArray++;
            } else {
                gp.array2D[lineSet][i] = 0;
            }
        }
        
        ArrayList<Integer> lineSetEmpty = new ArrayList<>();
        for(int i = 0; i < gp.gameSize; i++){
            if(i != lineSet){
                lineSetEmpty.add(i);
            }
        }
//        System.out.println("Dong chua co the dung: " + lineSetEmpty);
        
        int isTrue = (int)(Math.random()*10)%gp.gameSize;
        lineSet = lineSetEmpty.get((int)(Math.random()*10)%lineSetEmpty.size());
//        System.out.println("Dong chua: " + lineSet);
//        System.out.println("Cot chua: " + isTrue);
        
        int isExists = lr.getLine().get(isTrue);
//        System.out.println("So da dung: " + isExists);
        ArrayList<Integer> listGet = new ArrayList<>();
        for(int i = 0; i < gp.gameSize; i++){
            if(i+1 != isExists){
                listGet.add(i+1);
            }
        }
//        System.out.println("So co the dung: " + listGet);
        int getNum = listGet.get((int)(Math.random()*10)%listGet.size());
        gp.array2D[lineSet][isTrue] = getNum;
        notEdit.add(new Point(lineSet, isTrue));
        fullArray++;
//        System.out.println("So chua: " + getNum);
        getAmountNumber();
//        System.out.println("So luong da dung: ");
//        for(int i = 0; i < gp.gameSize; i++){
//            System.out.println("So " + (i+1) + " con lai " + (gp.gameSize - amountNumber[i]));
//        }
//        System.out.println("Not edit: ");
//        for(int i = 0; i < notEdit.size(); i++){
//            System.out.println(notEdit.get(i).row + " " + notEdit.get(i).col);
//        }
        
    }
    
    public boolean checkEdit(Point p){
        
        for(int i = 0; i < notEdit.size(); i++){
            if(p.equals(notEdit.get(i)))
                return false;
        }
        return true;
    }
    
    
}
