import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square {


    public static void main(String[] args) {
        FilledFrame frame = new FilledFrame();

        frame.setVisible(true);
    }
}

class FilledFrame extends JFrame {
    int size = 400;

    FilledFrame() {
        JButton butSmall = new JButton("Small");
        butSmall.addActionListener(new ButtonHandlerSmall(this));

        JButton butMedium = new JButton("Medium");
        butMedium.addActionListener(new ButtonHandlerMedium(this));

        JButton butLarge = new JButton("Large");
        butLarge.addActionListener(new ButtonHandlerLarge(this));

        String[] sizes = {"Small", "Medium", "Large"};
        JComboBox sizeList = new JComboBox<>(sizes);
        sizeList.setSelectedIndex(0);
        sizeList.addActionListener(new SizeHandler(this));


        JButton butMessage = new JButton("Say Hi!");
        butMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hi");
            }
        });

        SquarePanel panel = new SquarePanel(this);
        JPanel butPanel = new JPanel();

        butPanel.add(butSmall);

        butPanel.add(butMedium);

        butPanel.add(butLarge);

        butPanel.add(sizeList);

        butPanel.add(butMessage);
        add(butPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setSize(size + 100, size + 100);
    }
}

class SquarePanel extends JPanel {
    private FilledFrame theApp;

    SquarePanel(FilledFrame app) {
        theApp = app;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(20, 20, theApp.size, theApp.size);
    }
}

class ButtonHandlerSmall implements ActionListener {
    private FilledFrame theApp;

    ButtonHandlerSmall(FilledFrame app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        theApp.size = 100;
        theApp.repaint();
    }
}

class ButtonHandlerMedium implements ActionListener {
    private FilledFrame theApp;

    ButtonHandlerMedium(FilledFrame app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        theApp.size = 200;
        theApp.repaint();
    }
}

class ButtonHandlerLarge implements ActionListener {
    private FilledFrame theApp;

    ButtonHandlerLarge(FilledFrame app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        theApp.size = 400;
        theApp.repaint();
    }
}

class SizeHandler extends JPanel implements ActionListener {
    private FilledFrame theApp;

    SizeHandler(FilledFrame app) {
        theApp = app;
    }

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String size = (String) cb.getSelectedItem();
        if (size != null) {
            switch (size) {
                case "Small":
                    theApp.size = 100;
                    theApp.repaint();
                    break;
                case "Medium":
                    theApp.size = 200;
                    theApp.repaint();
                    break;
                case "Large":
                    theApp.size = 400;
                    theApp.repaint();
                    break;
            }
        }
    }
}
