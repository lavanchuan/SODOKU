
package Element;

public class Point {
    public int col, row;
    
    public Point(int row, int col){
        
        this.row = row;
        this.col = col;
    }
    
    public boolean equals(Point p){
        
        if(p.row == this.row && p.col == this.col)
            return true;
        else
            return false;
    }
}
