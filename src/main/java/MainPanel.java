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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainPanel {
    public JPanel mainJpanel;
    private JButton generateButton;
    private JButton screenshot;
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
    private boolean breakSwitch = true;

    // Panel
    public MainPanel() {

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
        screenshot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage img = new BufferedImage(screenshot.getWidth(), screenshot.getHeight(), BufferedImage.TYPE_INT_RGB);
                screenshot.paint(img.getGraphics());
                File outputfile = new File("saved.png");
                try {
                    ImageIO.write(img, "png", outputfile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


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

                    JPanel panel = new JPanel();
                    panel.setBackground(Color.CYAN);
                    panel.setBorder(new EmptyBorder(0, 10, 0, 10));
                    // Y_AXIS means each component added will be added vertically
                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                    ArrayList<String> song = new ArrayList<>();

                    if (easyCheckBox.isSelected()) {
                        String csvFile = "./classes/easy.csv";
                        String line = "";
                        String cvsSplitBy = ";";
                        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                            while ((line = br.readLine()) != null) {
                                String[] csvfile = line.split(cvsSplitBy);
                                float size = Float.valueOf(csvfile[1].trim()).floatValue();
                                if (size >= comboBoxmini && size <= comboBoxmaxi) {
                                    System.out.println("titre " + csvfile[0] + " " + csvfile[1]);
                                    song.add(csvfile[0] + " | Difficulté : Easy | Niveau : " + csvfile[1]);

                                }
                            }
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (NumberFormatException nfe) {
                            System.err.println("NumberFormatException: " + nfe.getMessage());
                        }
                    }

                    if (normalCheckBox.isSelected()) {

                        String csvFile = "./classes/normal.csv";
                        String line = "";
                        String cvsSplitBy = ";";
                        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                            while ((line = br.readLine()) != null) {
                                String[] csvfile = line.split(cvsSplitBy);
                                float size = Float.valueOf(csvfile[1].trim()).floatValue();
                                if (size >= comboBoxmini && size <= comboBoxmaxi) {
                                    System.out.println("titre " + csvfile[0] + " " + csvfile[1]);
                                    song.add(csvfile[0] + " | Difficulté : Normal | Niveau : " + csvfile[1]);

                                }
                            }
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (NumberFormatException nfe) {
                            System.err.println("NumberFormatException: " + nfe.getMessage());
                        }
                    }

                    if (hardCheckBox.isSelected()) {

                        String csvFile = "./classes/hard.csv";
                        String line = "";
                        String cvsSplitBy = ";";
                        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                            while ((line = br.readLine()) != null) {
                                String[] csvfile = line.split(cvsSplitBy);
                                float size = Float.valueOf(csvfile[1].trim()).floatValue();
                                if (size >= comboBoxmini && size <= comboBoxmaxi) {
                                    System.out.println("titre " + csvfile[0] + " " + csvfile[1]);
                                    song.add(csvfile[0] + " | Difficulté : Hard | Niveau : " + csvfile[1]);

                                }
                            }
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (NumberFormatException nfe) {
                            System.err.println("NumberFormatException: " + nfe.getMessage());
                        }
                    }

                    if (extremeCheckBox.isSelected()) {

                        String csvFile = "./classes/extreme.csv";
                        String line = "";
                        String cvsSplitBy = ";";
                        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                            while ((line = br.readLine()) != null) {
                                String[] csvfile = line.split(cvsSplitBy);
                                float size = Float.valueOf(csvfile[1].trim()).floatValue();
                                if (size >= comboBoxmini && size <= comboBoxmaxi) {
                                    System.out.println("titre " + csvfile[0] + " " + csvfile[1]);
                                    song.add(csvfile[0] + " | Difficulté : Extreme | Niveau : " + csvfile[1]);

                                }
                            }
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (NumberFormatException nfe) {
                            System.err.println("NumberFormatException: " + nfe.getMessage());
                        }
                    }

                    if (exExtremeCheckBox.isSelected()) {

                        String csvFile = "./classes/exextreme.csv";
                        String line = "";
                        String cvsSplitBy = ";";
                        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                            while ((line = br.readLine()) != null) {
                                String[] csvfile = line.split(cvsSplitBy);
                                float size = Float.valueOf(csvfile[1].trim()).floatValue();
                                if (size >= comboBoxmini && size <= comboBoxmaxi) {
                                    System.out.println("titre " + csvfile[0] + " " + csvfile[1]);
                                    song.add(csvfile[0] + " | Difficulté : Ex-Extreme | Niveau : " + csvfile[1]);

                                }
                            }
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (NumberFormatException nfe) {
                            System.err.println("NumberFormatException: " + nfe.getMessage());
                        }
                    }


                    //shuffle
                    double textfield = Double.valueOf(textField1.getText());
                    Random rand = new Random();

                    System.out.println("Results after shuffle operation #1:");
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

                    /*for (String word : song) {*/
                    for (int i = 1; i <= textfield; i++) {
                        float randomIndex = rand.nextInt(song.size());
                        String randomElement = song.get((int) randomIndex);
                        song.remove(randomElement);
                        System.out.println(randomElement);

                        JLabel j1 = new JLabel(randomElement);
                        j1.setFont(new Font("Nirmala UI", Font.BOLD, 16));
                        panel.add(j1);
                        frame.add(panel);

                    }
                    JButton button = new JButton("Save");
                    button.setBounds(50,100,100,50); /*Distance from left,
                      Distance from top,length of button, height of button*/
                    button.add(screenshot);
                    frame.pack();
                    frame.setVisible(true);

                }
                else {
                    JOptionPane.showMessageDialog(frame, "Remplissez tous les champs correctement.");
                }
            }

        });
    }
}
