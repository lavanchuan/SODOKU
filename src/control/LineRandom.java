
package control;

import gui_game.GamePanle;
import java.util.ArrayList;

public class LineRandom {
    
    private ArrayList<Integer> line;
    
    public LineRandom(GamePanle gp){
        
        line = new ArrayList<>();
        ArrayList<Integer> defaul = new ArrayList<>();
        int k = 0;
        while (k < gp.gameSize){
            defaul.add(++k);
        }
        
        k = 0;
        while(k < gp.gameSize){
            int index = (int)(Math.random()*10)%defaul.size();
            int rs = defaul.get(index);
            defaul.remove(index);
            line.add(k, rs);
            k++;
        }
    }
    
    public ArrayList<Integer> getLine(){
        
        return line;
    }
}
