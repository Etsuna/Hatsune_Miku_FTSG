import javax.swing.*;
import java.io.IOException;

public class main {

    public static void main(String [] args) throws IOException {
        JFrame frame = new JFrame("Hatsune Miku FT Music Generator");
        frame.setContentPane(new MainPanel().mainJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
