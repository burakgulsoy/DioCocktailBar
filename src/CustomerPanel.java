import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPanel extends JFrame {

    CustomerPanelMenu customerPanelMenu = new CustomerPanelMenu();

    JLabel lblSelectTable = new JLabel("Select table:");
    JLabel lblBill = new JLabel("Bill:                         ");

    JButton btnMenu = new JButton("Menu");
    JButton btnTip = new JButton("Give tip");
    JButton btnClearOrders = new JButton("Clear Orders");
    JButton btnOrder = new JButton("Order");
    JButton btnPay = new JButton("Pay");

    String tables[] = {"Table1", "Table2", "Table3", "Table4", "Table5", "Table6", "Table7", "Table8", "Table9"};
    JComboBox<String> cbTables = new JComboBox<>(tables);

    DefaultListModel dlmOrders = new DefaultListModel();
    JList listOrders = new JList(dlmOrders);
    JScrollPane spOrders = new JScrollPane(listOrders);

    JPanel pnlCenterRight = new JPanel(new GridLayout(3, 2,10,10));
    JPanel pnlCenterLeft = new JPanel();
    JPanel pnlCenter = new JPanel(new FlowLayout());
    JPanel pnlSouth = new JPanel(new FlowLayout());





    public CustomerPanel() {
        super("Customer Panel");

        setDesign();
        setListeners();
    }

    void setDesign() {

        setLayout(new BorderLayout());
        setSize(350,350);
        setLocation(600,240);

        pnlCenterRight.add(lblSelectTable);
        pnlCenterRight.add(cbTables);
        pnlCenterRight.add(btnMenu);
        pnlCenterRight.add(new JLabel(""));
        pnlCenterRight.add(btnTip);
        pnlCenterRight.add(btnClearOrders);

        pnlCenterLeft.add(spOrders);

        pnlCenter.add(pnlCenterLeft);
        pnlCenter.add(pnlCenterRight);

        add(pnlCenter, BorderLayout.CENTER);


        pnlSouth.add(lblBill);
        pnlSouth.add(btnPay);
        pnlSouth.add(btnOrder);

        add(pnlSouth, BorderLayout.SOUTH);

    }

    void setListeners() {

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerPanelMenu.setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        new CustomerPanel().setVisible(true);
    }
}
