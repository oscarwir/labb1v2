import Head.AutoVehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawAutoVehiclesPanel extends JPanel{


    // To keep track of a single cars position
    ArrayList<AutoVehicle> autoVehicles = new ArrayList<>();


    // TODO: Make this general for all cars
    public void updateAutoVehicles(ArrayList<AutoVehicle> autoVehicles){
        this.autoVehicles = autoVehicles;

    }

    // Initializes the panel and reads the images
    public DrawAutoVehiclesPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (AutoVehicle autoVehicle : autoVehicles){
            BufferedImage image = autoVehicle.getImage();
            g.drawImage(image, (int) autoVehicle.getLocation().getX(), (int) autoVehicle.getLocation().getY(), null);
        }

    }
}
