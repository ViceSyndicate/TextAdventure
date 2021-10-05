public class Position {
    int x;
    int y;
    int z;

    public Position(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Position(Position position){
        this.x = position.x;
        this.y = position.y;
        this.z = position.z;
    }
}
