/*
 * Created by JFormDesigner on Thu May 24 01:30:55 GMT+02:00 2018
 */

package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author Silvana Man
 */
public class SpecificationView extends JFrame {
    public SpecificationView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Silvana Man
        processor = new JTextField();
        screen = new JTextField();
        ram = new JTextField();
        hdd = new JTextField();
        video = new JTextField();
        color = new JTextField();
        camera = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        doneSpec = new JButton();

        //======== this ========
        setTitle("Add specification to product");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(processor);
        processor.setBounds(255, 20, 190, processor.getPreferredSize().height);
        contentPane.add(screen);
        screen.setBounds(255, 75, 190, screen.getPreferredSize().height);
        contentPane.add(ram);
        ram.setBounds(255, 125, 190, ram.getPreferredSize().height);
        contentPane.add(hdd);
        hdd.setBounds(255, 180, 190, hdd.getPreferredSize().height);
        contentPane.add(video);
        video.setBounds(255, 235, 190, video.getPreferredSize().height);
        contentPane.add(color);
        color.setBounds(255, 290, 190, color.getPreferredSize().height);
        contentPane.add(camera);
        camera.setBounds(255, 345, 190, camera.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Processor:");
        contentPane.add(label1);
        label1.setBounds(100, 25, 115, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Screen size:");
        contentPane.add(label2);
        label2.setBounds(100, 80, 115, label2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("RAM:");
        contentPane.add(label3);
        label3.setBounds(100, 135, 115, label3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("HDD:");
        contentPane.add(label4);
        label4.setBounds(100, 190, 115, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("Video card:");
        contentPane.add(label5);
        label5.setBounds(100, 240, 115, label5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("Color:");
        contentPane.add(label6);
        label6.setBounds(100, 300, 115, label6.getPreferredSize().height);

        //---- label7 ----
        label7.setText("Camera:");
        contentPane.add(label7);
        label7.setBounds(100, 345, 115, label7.getPreferredSize().height);

        //---- doneSpec ----
        doneSpec.setText("DONE");
        contentPane.add(doneSpec);
        doneSpec.setBounds(new Rectangle(new Point(230, 425), doneSpec.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Silvana Man
    public JTextField processor;
    public JTextField screen;
    public JTextField ram;
    public JTextField hdd;
    public JTextField video;
    public JTextField color;
    public JTextField camera;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    public JButton doneSpec;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
