import javax.swing.*;
import java.awt.event.*;

public class MoveStringFrame extends JFrame {
    private JLabel label;
    private String text = "Love Java";

    public MoveStringFrame() {
        setTitle("Move String Example");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label = new JLabel(text, SwingConstants.CENTER);
        add(label);
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    shiftLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    shiftRight();
                }
            }
        });
        
        setFocusable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void shiftLeft() {
        text = text.substring(1) + text.charAt(0);
        label.setText(text);
    }

    private void shiftRight() {
        text = text.charAt(text.length() - 1) + text.substring(0, text.length() - 1);
        label.setText(text);
    }

    public static void main(String[] args) {
    	new MoveStringFrame();
    }
}
