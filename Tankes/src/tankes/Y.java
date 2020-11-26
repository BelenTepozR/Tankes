package tankes;

public class Y {   
    Y(){
            this.y = 250;
    }
    public synchronized int getY() {
        return y;
    }
    public synchronized void setY(int y) {
        this.y = y;
    }
    private int  y;
}


