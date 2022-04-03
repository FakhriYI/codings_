import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout.*;
import javax.swing.border.*;
import java.util.Hashtable;
import java.text.DecimalFormat;

public class konversisuhu extends JFrame implements ActionListener, ChangeListener {

    JFrame frame = new JFrame("NPM Genap");
    JPanel panel = new JPanel();
    JLabel suhuc = new JLabel("Suhu celcius Celcius");
    JLabel lblkonversi = new JLabel("Konversi Ke -");
    String konversi[] = { "Farenheit", "Reamur" };
    JComboBox<String> convert = new JComboBox<String>(konversi);
    JTextField txtc = new JTextField("0 C");
    JTextField txta = new JTextField("0");
    JSlider slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
    JSlider slider2 = new JSlider(JSlider.HORIZONTAL);
    GroupLayout layout = new GroupLayout(panel);

    public konversisuhu() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        txta.setEditable(false);
        txtc.setEditable(false);

        slider1.setMinorTickSpacing(1);
        slider1.setMinorTickSpacing(100);
        slider1.setPaintLabels(true);
        slider1.addChangeListener(this);

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
                .addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(suhuc).addComponent(txtc)
                        .addComponent(slider1)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(lblkonversi))
                                .addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(convert))

                        ).addComponent(txta).addComponent(slider2)

                ));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(suhuc))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(txtc))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(slider1))
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblkonversi).addComponent(convert))

                        )).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(txta))
                .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(slider2)));

        frame.add(panel);
        frame.pack();

    }

    public static void main(String[] args) {
        new konversisuhu();
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
        txta.setText(df.format(result) + code);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setSlider2(convert.getSelectedItem());
        calculate(slider1.getValue());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int value = slider1.getValue();
        txtc.setText(value + " C");
        calculate(value);
    }

}
