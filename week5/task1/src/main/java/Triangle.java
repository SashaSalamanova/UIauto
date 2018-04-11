import java.lang.*;
public class Triangle {

    public enum Coordinates {
        A(0, 0),
        B(1, 1),
        C(1, -1);

        private int xCoordinate;
        private int yCoordinate;

        Coordinates(int xCoordinate, int yCoordinate) {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
        }

        private int[] getCoordinates() {
            int[] coordinatesArr = {xCoordinate, yCoordinate};
            return coordinatesArr;
        }
    }

    private double getSideLength(Coordinates Start, Coordinates End){
        int[] startPoint = Start.getCoordinates();
        int[] endPoint = End.getCoordinates();
        double sideLength = Math.sqrt((startPoint[0] - endPoint[0])*(startPoint[0] - endPoint[0])
                                    + (startPoint[1] - endPoint[1])*(startPoint[1] - endPoint[1]));
        return sideLength;
    }

    public double getABLength(){
        return getSideLength(Coordinates.A, Coordinates.B);
    }
    public double getACLength(){
        return getSideLength(Coordinates.A, Coordinates.C);
    }
    public double getBCLength(){
        return getSideLength(Coordinates.B, Coordinates.C);
    }
}
