import javafx.scene.shape.Line;
@FunctionalInterface
public interface LineInfoDisplayer {

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERT_HORZ, SLOPE;
    }
      
    public static LineInfoDisplayer createLineInfoDisplayer(InfoType type) {
    	switch (type) {
            case InfoType.DISTANCE:
                return (Line line) -> {
                    double changeX = line.getEndX() - line.getStartX();
                    double changeY = line.getEndY() - line.getStartY();
                    double dist = Math.sqrt(changeX*changeX + changeY*changeY);
                    return String.format("Distance = %.2f", dist);
                };
            case InfoType.MIDPOINT:
                return (Line line) -> {
                    double midX = (line.getEndX() + line.getStartX()) / 2;
                    double midY = (line.getEndY() + line.getStartY()) / 2;
                    return String.format("Midpoint = (%.2f, %.2f)", midX, midY);
                };
            case InfoType.VERT_HORZ:
                return (Line line) -> {
                    String typeOfLine = "Type of line: ";
                    if (line.getStartX() == line.getEndX()) {
                        typeOfLine += "vertical.";
                    }
                    else if (line.getStartY() == line.getEndY()) {
                        typeOfLine += "horizonal.";
                    }
                    else {
                        typeOfLine += "neither vertical nor horizontal.";
                    }
                    return typeOfLine;
                };
            case InfoType.SLOPE:
                return (Line line) -> {
                    double changeX = line.getEndX() - line.getStartX();
                    double changeY = line.getEndY() - line.getStartY();
                    double slope = changeY / changeX;
                    return String.format("Slope = %.2f", slope);
                };
        }
        return null;
    }

}
