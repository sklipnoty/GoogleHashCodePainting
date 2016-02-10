package domain;

public class Line implements Comparable<Line>{
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Line() {
    }
    
    public Line(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }
    
    public int getLength() {
       return Math.max((endY - startY), (endX-startX));
    }
    
    public boolean isVertical() {
       return (endY == startY); 
    }

    @Override
    public int compareTo(Line line) {
        return Integer.compare(this.getLength(), line.getLength());
    }

//    public boolean isValid(Line line2) {
//        if (isVertical() && line2.isVertical()) {
//            // both vertical
//            /*
//            + <- startY
//            +
//            +
//            + <- endY
//            
//            + <- startY
//            +
//            + <- endY
//            */
//            boolean noOverlap = (getEndY() < line2.getStartY() || line2.getEndY() < getStartY());
//            return !noOverlap;
//        }
//        else if (!isVertical() && !line2.isVertical()) {
//            // both horizontal
//            boolean noOverlap = (getEndX() < line2.getStartX() || line2.getEndX() < getStartX());
//            return !noOverlap;
//        }
//        else {
//            // one vertical, one horizontal
//        }
//        return false;
//    }
    
}
