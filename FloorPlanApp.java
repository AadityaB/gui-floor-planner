import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FloorPlanApp {
    private JFrame frame;
    private CanvasPanel canvas;
    private JPanel controlPanel;

    public FloorPlanApp() {
        frame = new JFrame("2D Floor Plan Maker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Canvas panel where rooms will be drawn
        canvas = new CanvasPanel();
        frame.add(canvas, BorderLayout.CENTER);

        // Control panel for user input
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(8, 1));
        setupControlPanel();
        frame.add(controlPanel, BorderLayout.WEST);

        frame.setVisible(true);
    }

    private void setupControlPanel() {
        // Add controls for room type, dimensions, position
        controlPanel.add(new JLabel("Room Type"));
        JComboBox<String> roomTypeCombo = new JComboBox<>(new String[]{"Bedroom", "Bathroom", "Kitchen", "Living Room"});
        controlPanel.add(roomTypeCombo);

        controlPanel.add(new JLabel("Width"));
        JTextField widthField = new JTextField();
        controlPanel.add(widthField);

        controlPanel.add(new JLabel("Height"));
        JTextField heightField = new JTextField();
        controlPanel.add(heightField);

        controlPanel.add(new JLabel("Position (x, y)"));
        JTextField xField = new JTextField();
        JTextField yField = new JTextField();
        controlPanel.add(xField);
        controlPanel.add(yField);

        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String roomType = (String) roomTypeCombo.getSelectedItem();
                int width = Integer.parseInt(widthField.getText());
                int height = Integer.parseInt(heightField.getText());
                int x = Integer.parseInt(xField.getText());
                int y = Integer.parseInt(yField.getText());
                canvas.addRoom(roomType, x, y, width, height);
            }
        });
        controlPanel.add(addRoomButton);
    }

    public static void main(String[] args) {
        new FloorPlanApp();
    }
}
