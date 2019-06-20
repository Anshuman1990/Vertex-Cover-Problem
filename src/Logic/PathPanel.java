package Logic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import Forms.Vertex;

@SuppressWarnings("serial")
public class PathPanel extends JPanel {
    private String path;

    public PathPanel() {
    }

    public PathPanel(String path) {
        this.setVisible(false);
        this.setOpaque(false);
        this.path = path;
    }

    public void paintComponent(Graphics comp) {
        if (path == null) {
            return;
        }

        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, new float[] { 10f }, 1f));
        comp2D.setColor(Color.MAGENTA);

        String[] nodes = path.split("-");
        int prevIndex = -1;
        for (String node : nodes) {

            int index = Integer.parseInt(node.substring(4));
            if (prevIndex == -1) {
                prevIndex = index;
                continue;
            }

            float prevX = Vertex.posx[prevIndex] + 25;
            float prevY = Vertex.posy[prevIndex] + 25;
            float x = Vertex.posx[index] + 25;
            float y = Vertex.posy[index] + 25;
            Line2D line2d = new Line2D.Float(prevX, prevY, x, y);
            comp2D.draw(line2d);
            prevIndex = index;
        }
    }
}