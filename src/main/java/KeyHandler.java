import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

    Player player;

    public KeyHandler(Player player) {
        this.player = player;
    }
@Override 
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) player.moveLeft();
        if (code == KeyEvent.VK_D) player.moveRight();
        if (code == KeyEvent.VK_SPACE) player.jump();
    }
}