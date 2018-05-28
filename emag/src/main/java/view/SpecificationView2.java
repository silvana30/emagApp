/*
 * Created by JFormDesigner on Sun May 27 22:37:23 GMT+02:00 2018
 */

package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Silvana Man
 */
public class SpecificationView2 extends JFrame {
    public SpecificationView2() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Silvana Man
        scrollPane1 = new JScrollPane();
        tableSpec = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tableSpec);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 20, scrollPane1.getPreferredSize().width, 240);

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
    private JScrollPane scrollPane1;
    public JTable tableSpec;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
