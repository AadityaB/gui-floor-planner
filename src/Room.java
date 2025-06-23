import java.awt.*;

class Room {
    private String type;
    private int x, y, width, height;

    public Room(String type, int x, int y, int width, int height) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public Color getColor() {
        switch (type) {
            case "Bedroom": return Color.GREEN;
            case "Bathroom": return Color.BLUE;
            case "Kitchen": return Color.YELLOW;
            case "Living Room": return Color.ORANGE;
            default: return Color.GRAY;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}


