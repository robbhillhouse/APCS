public class Position {
    private int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position(){
        row = -1;
        col = -1;
    }

    public int getRow() {return row;}

    public int getColumn() {return col;}

    public void setRow(int row) {this.row = row;}

    public void setCol(int col) {this.col = col;}

    public boolean equals(Object o){
        if(o instanceof Position){
            Position temp = (Position)o;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;
    }

}
