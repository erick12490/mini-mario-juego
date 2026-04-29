import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    final int WIDTH = 800;
    final int HEIGHT = 600;

    Thread gameThread;

    Player player = new Player();
    ArrayList<Platform> platforms = new ArrayList<>();

    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        // CONTROLES
        KeyHandler keyH = new KeyHandler(player);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        // PLATAFORMAS
        platforms.add(new Platform(0, 500, 800, 50)); // suelo
        platforms.add(new Platform(200, 400, 120, 20));
        platforms.add(new Platform(400, 350, 120, 20));
        platforms.add(new Platform(600, 300, 120, 20));
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while (gameThread != null) {

            update();
            repaint();

            try {
                Thread.sleep(16);
            } catch (Exception e) {}
        }
    }

    public void update() {
        player.update(platforms);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
g.setColor(Color.white);
g.setFont(new Font("Arial", Font.BOLD, 30));
g.drawString("Mary manca y noob", 20, 40);
        // dibujar plataformas
        for (Platform p : platforms) {
            p.draw(g);
        }

        // dibujar jugador
        player.draw(g);
    }
}