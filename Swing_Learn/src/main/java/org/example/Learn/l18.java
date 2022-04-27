package org.example.Learn;

import javax.swing.*;
import java.awt.*;

public class l18 {
    public static void main(String[] args) {
        l18_frame myframe = new l18_frame("mf1");
    }
}

class l18_frame extends JFrame {
    JPanel panel1 = new JPanel();
    l18_layout layout1 = new l18_layout();
    l11_label label1 = new l11_label("Label 1", Color.red);
    l11_label label2 = new l11_label("Label 2", Color.blue);
    l11_label label3 = new l11_label("Label 3", Color.green);
    l11_label label4 = new l11_label("Label 4", Color.yellow);
    l11_label label5 = new l11_label("Label 5", Color.orange);

    public l18_frame(String title) {
        super(title);
        Init();
    }

    public l18_frame() {
        Init();
    }

    void Init() {

        panel1.setLayout(layout1);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(label5);

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(800, 400);
        setVisible(true);
    }
}

class l18_layout implements LayoutManager2 {

    // 添加组件
    @Override
    public void addLayoutComponent(Component comp, Object constraints) {

    }

    // 布局组件
    @Override
    public void layoutContainer(Container parent) {
        System.out.println("layoutContainer");
        Component[] components = parent.getComponents();
        int width = parent.getWidth();
        int height = parent.getHeight();
        int x = -100;
        int y = 0;
        for (Component component : components) {
            x += 100;
            component.setBounds(x, y, 100, 100);
            if (x > width - 100) {
                x = -100;
                y += 100;
            }

        }
    }

    // 删除组件
    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return null;
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0;
    }

    @Override
    public void invalidateLayout(Container target) {

    }

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

}