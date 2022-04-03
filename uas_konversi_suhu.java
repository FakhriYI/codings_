// Muhammad Fariz Rahman
// 13.2020.1.00880
// Sistem Informasi (Malam)

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class uas_konversi_suhu {
    int celsius;
    double fahrenheit, reamur;

    // Pendefinisian Komponen
    JFrame frame = new JFrame("Konversi Suhu NPM Genap");

    JPanel panel1 = new JPanel();
    JLabel title = new JLabel("KONVERSI SUHU");
    JLabel label1 = new JLabel("Suhu Dalam Celcius");
    JTextField txtcelcius = new JTextField("0.0", 10);
    JSlider slider1 = new JSlider(0, 100, 0);

    JPanel panel2 = new JPanel();
    JLabel label2 = new JLabel("Konversi Ke - ");
    String[] data = { "Pilih Suhu", "Fahrenheit", "Reamur" };
    JComboBox combobox = new JComboBox(data);
    JTextField txtkonversi = new JTextField(10);
    JSlider slider2 = new JSlider();

    // Konstruktor
    public uas_konversi_suhu() {
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));
        frame.setResizable(false);

        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBounds(3, 0, 200, 100);
        title.setIconTextGap(10);

        label1.setBounds(3, 115, 200, 20);

        txtcelcius.setBounds(3, 140, 150, 30);
        txtcelcius.setEnabled(false);
        txtcelcius.setText(slider1.getValue() + " C");

        slider1.setPreferredSize(new Dimension(300, 40));
        slider1.setPaintTicks(true);
        slider1.setMinorTickSpacing(10);
        slider1.setPaintTrack(true);
        slider1.setMajorTickSpacing(20);
        slider1.setPaintLabels(true);
        slider1.setFont(new Font("Arial", Font.PLAIN, 10));
        slider1.setOrientation(SwingConstants.HORIZONTAL);
        slider1.setBounds(3, 185, 375, 50);

        label2.setBounds(3, 30, 100, 30);

        combobox.setBounds(93, 30, 120, 30);
        combobox.setSelectedItem(1);

        txtkonversi.setBounds(3, 70, 150, 30);
        txtkonversi.setEnabled(false);

        slider2.setPreferredSize(new Dimension(300, 40));
        slider2.setPaintTicks(true);
        slider2.setMinorTickSpacing(10);
        slider2.setPaintTrack(true);
        slider2.setMajorTickSpacing(20);
        slider2.setPaintLabels(true);
        slider2.setFont(new Font("Arial", Font.PLAIN, 10));
        slider2.setOrientation(SwingConstants.HORIZONTAL);
        slider2.setBounds(3, 130, 375, 50);
        slider2.setEnabled(false);

        panel1.setLayout(null);
        panel1.add(title);
        panel1.add(label1);
        panel1.add(txtcelcius);
        panel1.add(slider1);

        panel2.setLayout(null);
        panel2.add(combobox);
        panel2.add(txtkonversi);
        panel2.add(label2);
        panel2.add(slider2);

        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);

        slider1.addChangeListener(new slider());
        combobox.addActionListener(new combobox());
    }

    // class ChangeListener
    private class slider implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            txtcelcius.setText(slider1.getValue() + " C");
        }
    }

    // proses calculate
    public class combobox implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DecimalFormat fmt = new DecimalFormat("0.0");
            celsius = slider1.getValue();

            if (combobox.getSelectedIndex() == 1) {
                fahrenheit = (9.0 / 5.0) * celsius + 32.0;
                int a = (int) fahrenheit;
                txtkonversi.setText(fmt.format(fahrenheit) + " F");
                slider2.setValue(a);
                slider2.setMaximum(212);
                slider2.setMinimum(-32);
            } else if (combobox.getSelectedIndex() == 2) {
                reamur = (4.0 / 5.0) * celsius;
                int b = (int) reamur;
                txtkonversi.setText(fmt.format(reamur) + " R");
                slider2.setValue(b);
                slider2.setMaximum(80);
                slider2.setMinimum(0);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Konversi Suhu Apps is Running...");
        new uas_konversi_suhu();
    }
}
