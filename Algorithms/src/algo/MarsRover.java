package algo;

public class MarsRover {
    
    int upperRight = 0;
    int upperLeft = 0;
    int startingX = 0;
    int startingY = 0;

    public MarsRover(int upperLeft, int upperRight, int startingX, int startingY) {
        this.upperLeft = upperLeft;
        this.upperRight = upperRight;
        this.startingX = startingX;
        this.startingY = startingY;
    }

    public static void main(String[] args) {
       MarsRover mr = new MarsRover(0, 0, 0, 0);
    }
    
}
