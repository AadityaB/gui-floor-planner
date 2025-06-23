import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class CanvasPanel extends JPanel {
    private ArrayList<Room> rooms;

    public CanvasPanel() {
        rooms = new ArrayList<>();
        setBackground(Color.BLACK);
    }

    public void addRoom(String type, int x, int y, int width, int height) {
        Room newRoom = new Room(type, x, y, width, height);
        if (isPlacementValid(newRoom)) {
            rooms.add(newRoom);
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid placement! Rooms cannot overlap.");
        }
    }

    private boolean isPlacementValid(Room newRoom) {
        for (Room room : rooms) {
            if (room.getBounds().intersects(newRoom.getBounds())) {
                return false;
            }
        }
        return true;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Room room : rooms) {
            g.setColor(room.getColor());
            g.fillRect(room.getX(), room.getY(), room.getWidth(), room.getHeight());
        }
    }
    // Inside CanvasPanel
public void addDoor(int x, int y, int width, int height) {
    Door newDoor = new Door(x, y, width, height);
    if (isPlacementValid(newDoor)) {
        rooms.add(newDoor);
        repaint();
    } else {
        JOptionPane.showMessageDialog(this, "Invalid placement for door! Cannot overlap rooms or other doors.");
    }
}

}
