import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffPanel extends JFrame {

    OrderPanel orderPanel = new OrderPanel();
    MenuManagement menuManagement = new MenuManagement();

    JPanel pnlLblOccupiedTables = new JPanel(new FlowLayout());
    JPanel pnlOccupiedTables = new JPanel(new GridLayout(3, 3));
    JPanel pnlSouthElements = new JPanel(new FlowLayout());
    JPanel pnlNorth = new JPanel(new GridLayout(2, 1));
    JPanel pnlSouth = new JPanel(new BorderLayout());

    JButton btnTable1 = new JButton("Table #1");
    JButton btnTable2 = new JButton("Table #2");
    JButton btnTable3 = new JButton("Table #3");
    JButton btnTable4 = new JButton("Table #4");
    JButton btnTable5 = new JButton("Table #5");
    JButton btnTable6 = new JButton("Table #6");
    JButton btnTable7 = new JButton("Table #7");
    JButton btnTable8 = new JButton("Table #8");
    JButton btnTable9 = new JButton("Table #9");

    JButton btnOrderQueue = new JButton("Orders");
    JButton btnMenuManagement = new JButton("Menu Management");

    JLabel lblOccupiedTables = new JLabel("Occupied Tables");

    public StaffPanel() {

        setDesign();
        setListeners();
    }

    void setDesign() {

        setSize(400, 300);
        setLocation(610,250);

        pnlLblOccupiedTables.add(lblOccupiedTables);

        pnlOccupiedTables.add(btnTable1);
        pnlOccupiedTables.add(btnTable2);
        pnlOccupiedTables.add(btnTable3);
        pnlOccupiedTables.add(btnTable4);
        pnlOccupiedTables.add(btnTable5);
        pnlOccupiedTables.add(btnTable6);
        pnlOccupiedTables.add(btnTable7);
        pnlOccupiedTables.add(btnTable8);
        pnlOccupiedTables.add(btnTable9);

        pnlNorth.add(pnlLblOccupiedTables);
        pnlNorth.add(pnlOccupiedTables);

        add(pnlNorth, BorderLayout.NORTH);

        pnlSouthElements.add(btnOrderQueue);
        pnlSouthElements.add(btnMenuManagement);
        pnlSouth.add(pnlSouthElements, BorderLayout.CENTER);

        add(pnlSouth, BorderLayout.CENTER);

        pnlLblOccupiedTables.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        lblOccupiedTables.setFont(new Font("Dialog.bold", Font.PLAIN, 15));
    }

    void setListeners() {

        setActionListenersForButtons();

        btnMenuManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuManagement.setVisible(true);
            }
        });

    }

    void setActionListenersForButtons() {

        btnTable1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnTable2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnTable3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnTable4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnTable5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnTable6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnTable7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnTable8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnTable9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



//    public static void main(String[] args) {
//        new StaffPanel().setVisible(true);
//    }


}

