import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Hashtable;

/**
 * Suhu
 */
public class Suhu extends JFrame implements ActionListener, ChangeListener {

  JPanel panel = new JPanel();

  JLabel suhuC = new JLabel("Suhu dalam Celcius");
  JLabel labelConvert = new JLabel("Konversi Ke -");

  JTextField currentC = new JTextField("0 C");
  JTextField currentA = new JTextField("0");

  String konversi[] = { "Farenheit", "Reamur" };
  JComboBox<String> convert = new JComboBox<String>(konversi);

  JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
  JSlider slider2 = new JSlider(JSlider.HORIZONTAL);

  GroupLayout layout = new GroupLayout(panel);

  public Suhu() {
    setTitle("Konversi Suhu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    currentC.setEditable(false);
    currentA.setEditable(false);

    slider.setMinorTickSpacing(1);
    slider.setMajorTickSpacing(100);
    slider.setPaintLabels(true);
    slider.addChangeListener(this);

    slider2.setMinorTickSpacing(1);
    slider2.setValue(0);
    slider2.setPaintLabels(true);

    convert.addActionListener(this);
    setSlider2(convert.getSelectedItem());
    panel.setLayout(layout);

    panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Konversi Suhu",
        TitledBorder.LEFT, TitledBorder.TOP));

    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(suhuC).addComponent(currentC)
            .addComponent(slider)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(labelConvert))
                .addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(convert))

            ).addComponent(currentA).addComponent(slider2)

        ));

    layout.setVerticalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(suhuC))
        .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(currentC))
        .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(slider))
        .addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(labelConvert).addComponent(convert))

        )).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(currentA))
        .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(slider2)));

    add(panel);
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    new Suhu();
  }

  public void setSlider2(Object value) {

    Hashtable<Integer, JLabel> labels = new Hashtable<>();
    if (value == "Farenheit") {

      slider2.setMinimum(-32);
      slider2.setMaximum(212);

      labels.put(-32, new JLabel("-32"));
      labels.put(212, new JLabel("212"));
    } else {
      slider2.setMinimum(0);
      slider2.setMaximum(80);

      labels.put(0, new JLabel("0"));
      labels.put(80, new JLabel("80"));
    }
    slider2.setLabelTable(labels);
  }

  public void calculate(int value) {

    DecimalFormat df = new DecimalFormat("#.###");

    double result;
    String code = " F";
    if (convert.getSelectedItem() == "Farenheit") {
      result = 1.8 * value + 32;
      code = " F";
    } else {
      result = 0.8 * value;
      code = " R";
    }

    slider2.setValue((int) result);
    currentA.setText(df.format(result) + code);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    setSlider2(convert.getSelectedItem());
    calculate(slider.getValue());
  }

  @Override
  public void stateChanged(ChangeEvent e) {
    int value = slider.getValue();
    currentC.setText(value + " C");
    calculate(value);
  }

}