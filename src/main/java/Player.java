import java.awt.*;
import java.util.ArrayList;

public class Player {

    int x = 100;
    int y = 300;

    int speed = 5;

    int velocityY = 0;
    int gravity = 1;
    boolean jumping = false;

    public void update(ArrayList<Platform> platforms) {

        velocityY += gravity;
        y += velocityY;

        Rectangle playerBounds = new Rectangle(x, y, 40, 40);

        for (Platform p : platforms) {

            Rectangle platformBounds = p.getBounds();

            if (playerBounds.intersects(platformBounds)) {

                if (velocityY > 0 && y + 40 - velocityY <= p.y) {
                    y = p.y - 40;
                    velocityY = 0;
                    jumping = false;
                }
            }
        }
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void jump() {
        if (!jumping) {
            velocityY = -15;
            jumping = true;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 40, 40);
    }
}