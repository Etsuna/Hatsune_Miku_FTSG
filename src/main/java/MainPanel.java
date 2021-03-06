import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainPanel {
    private JPanel mainJpanel;
    private JButton generateButton;
    private JCheckBox easyCheckBox;
    private JCheckBox normalCheckBox;
    private JCheckBox hardCheckBox;
    private JCheckBox extremeCheckBox;
    private JCheckBox exExtremeCheckBox;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel checkboxPanel;
    private JPanel fieldJpanel;
    private JComboBox comboLanguage;
    private JLabel fieldNumberSongs;
    private JLabel labelLevelMin;
    private JLabel labelMaxLevel;
    private String labeldifficuly = "Difficulté";
    private boolean breakSwitch = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hatsune Miku FT Music Generator ");
        frame.setContentPane(new MainPanel().mainJpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    // Panel
    public MainPanel() {

        //Check Language
        comboLanguage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String comboSelectedValue = (String) comboLanguage.getSelectedItem();

                if (comboSelectedValue.equals("Français")) {
                    generateButton.setText("Générer");
                    fieldNumberSongs.setText("Nombre de musique");
                    labelLevelMin.setText("Difficulté Minimale");
                    labelMaxLevel.setText("Difficulté Maximale");
                    labeldifficuly = "Difficulté";
                }

                if (comboSelectedValue.equals("English")) {
                    generateButton.setText("Generate");
                    fieldNumberSongs.setText("Number of music");
                    labelLevelMin.setText("Minimum Difficulty");
                    labelMaxLevel.setText("Maximum Difficulty");
                    labeldifficuly = "Difficulty";
                }

            }
        });


        // Check box
        easyCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

            }
        });

        normalCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

            }
        });

        hardCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        extremeCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        exExtremeCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });

        // TextField
        textField1.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                JTextField text = (JTextField) e.getSource();
            }
        });

        //combobox
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });

        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });

        // Button
         generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                float comboBoxmini = Float.valueOf((String) comboBox1.getSelectedItem());
                float comboBoxmaxi = Float.valueOf((String) comboBox2.getSelectedItem());


                if (textField1.getText().isEmpty()) {
                    breakSwitch = true;
                } else {
                    breakSwitch = false;
                }

                JFrame frame = new JFrame("Songs");
                frame.setResizable(false);
                if ((comboBoxmini < comboBoxmaxi || comboBoxmini == comboBoxmaxi) && (easyCheckBox.isSelected() || easyCheckBox.isSelected() ||
                        normalCheckBox.isSelected() || hardCheckBox.isSelected() || extremeCheckBox.isSelected() || exExtremeCheckBox.isSelected()) && breakSwitch == false){

                    final JPanel panel = new JPanel(){
                        protected void paintComponent(Graphics g)
                        {
                            super.paintComponent(g);

                            ImageIcon m = new ImageIcon("./classes/wallpaper.jpg");
                            Image monImage = m.getImage();
                            g.drawImage(monImage, 0, 0, this);

                        }
                    };
                    panel.setBackground(Color.BLACK);
                    panel.setBorder(new EmptyBorder(0, 10, 0, 10));
                    // Y_AXIS means each component added will be added vertically
                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                    ArrayList<String> song = new ArrayList<>();

                    if (easyCheckBox.isSelected()) {
                        try {
                            new ReadXLS(0, "Easy", song, comboBoxmini, comboBoxmaxi, labeldifficuly);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }


                    if (normalCheckBox.isSelected()) {
                        try {
                            new ReadXLS(1, "Normal", song, comboBoxmini, comboBoxmaxi, labeldifficuly);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    if (hardCheckBox.isSelected()) {
                        try {
                            new ReadXLS(2, "Hard", song, comboBoxmini, comboBoxmaxi, labeldifficuly);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    if (extremeCheckBox.isSelected()) {
                        try {
                            new ReadXLS(3, "Extreme", song, comboBoxmini, comboBoxmaxi, labeldifficuly);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }

                    if (exExtremeCheckBox.isSelected()) {
                        try {
                            new ReadXLS(4, "Ex Extreme", song, comboBoxmini, comboBoxmaxi, labeldifficuly);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }


                    //shuffle
                    double textfield = Double.valueOf(textField1.getText());
                    Random rand = new Random();

                    System.out.println("Shuffle x 10 :");
                    Collections.shuffle(song);
                    Collections.shuffle(song);
                    Collections.shuffle(song);
                    Collections.shuffle(song);
                    Collections.shuffle(song);
                    Collections.shuffle(song);
                    Collections.shuffle(song);
                    Collections.shuffle(song);
                    Collections.shuffle(song);
                    Collections.shuffle(song);
                    System.out.println(song);

                    //*for (String word : song) {*//*
                    for (int i = 1; i <= textfield; i++) {
                        float randomIndex = rand.nextInt(song.size());
                        String randomElement = song.get((int) randomIndex);
                        song.remove(randomElement);
                        System.out.println(randomElement);

                        JLabel j1 = new JLabel(randomElement);
                        j1.setFont(new Font("MSMINCHO", Font.BOLD, 16));
                        j1.setForeground(Color.WHITE);
                        panel.add(j1);
                    }
                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
                    Date date = new Date();

                    BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
                    panel.paint(img.getGraphics());
                    File outputfile = new File("saved_" + dateFormat.format(date) + ".png");
                    try {
                        ImageIO.write(img, "png", outputfile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    String comboSelectedValue = (String) comboLanguage.getSelectedItem();
                    if (comboSelectedValue.equals("English")) {
                        JOptionPane.showMessageDialog(frame, "Fill in all the fields correctly.");
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Remplissez tous les champs correctement.");
                    }
                }
            }

        });
    }
}
