package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape {
    protected int xEnd;
    protected int yEnd;

    public MyLine() {
        super(0,0);
        this.xEnd = 0;
        this.yEnd = 0;
    }

    public MyLine(int x, int y, int xEnd, int yEnd) {
        super(x, y);
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x - xEnd, 2) + Math.pow(y - yEnd, 2));
    }

    public double get_xAngle() {
        if(this.y == this.yEnd) {
            return 0;
        } else if (this.x == this.xEnd) {
            return 90;
        } else {
            return Math.abs(Math.toDegrees(Math.asin((y - yEnd) / this.getLength())));
        }
    }

    public void draw(GraphicsContext gc) {
        gc.strokeLine(this.x, this.y, this.xEnd, this.yEnd);
    }

}
