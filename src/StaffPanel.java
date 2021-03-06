import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffPanel extends JFrame {

    OrderPanel orderPanel = new OrderPanel();
    MenuManagement menuManagement = new MenuManagement();
    SeeAllOrdersPanel seeAllOrdersPanel = new SeeAllOrdersPanel();

    JPanel pnlLblOccupiedTables = new JPanel(new FlowLayout());
    JPanel pnlOccupiedTables = new JPanel(new GridLayout(3, 3));
    JPanel pnlSouthElements = new JPanel(new FlowLayout());
    JPanel pnlNorth = new JPanel(new GridLayout(2, 1));
    JPanel pnlSouth = new JPanel(new BorderLayout());

    JButton btnTable1 = new JButton("Table1");
    JButton btnTable2 = new JButton("Table2");
    JButton btnTable3 = new JButton("Table3");
    JButton btnTable4 = new JButton("Table4");
    JButton btnTable5 = new JButton("Table5");
    JButton btnTable6 = new JButton("Table6");
    JButton btnTable7 = new JButton("Table7");
    JButton btnTable8 = new JButton("Table8");
    JButton btnTable9 = new JButton("Table9");

    JButton btnOrderQueue = new JButton("Orders");
    JButton btnMenuManagement = new JButton("Menu Management");

    JLabel lblOccupiedTables = new JLabel("Occupied Tables");

    public StaffPanel() {
        super("Staff Panel");

        setDesign();
        setListeners();

        seeAllOrdersPanel.cocktailLinkedQueue.initializeQueue(); // not necessarily essential since it already makes rear and front null
                                                                 // using queue constructor
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

        btnMenuManagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuManagement.setVisible(true);
            }
        });


        btnOrderQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seeAllOrdersPanel.setVisible(true);
            }
        });
    }

}

