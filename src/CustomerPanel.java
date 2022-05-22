import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerPanel extends JFrame {

    CustomerPanelMenu customerPanelMenu = new CustomerPanelMenu();

    JLabel lblSelectTable = new JLabel("Select table:");
    JLabel lblBill = new JLabel("Bill:                         ");

    JButton btnMenu = new JButton("Menu");
    JButton btnTip = new JButton("Give tip (5.0)");
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

    ArrayList<Cocktail> cocktailArrayListForQueue = new ArrayList<>();
    private double bill = 0;
    private int givenTip = 0;





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

        btnOrder.setEnabled(false); // they need to pay first
    }

    void setListeners() {

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerPanelMenu.setVisible(true);
            }
        });

        customerPanelMenu.btnAddToOrderList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customerPanelMenu.list.getSelectedIndex() == -1) {
                    return;
                }

                String element = customerPanelMenu.list.getSelectedValue().toString();
                String splitted[] = element.split(" ");

                FLAVOR flavor = null;

                switch (splitted[4]) {
                    case "Sweet":
                        flavor = FLAVOR.SWEET;
                        break;
                    case "Sour":
                        flavor = FLAVOR.SOUR;
                        break;
                    case "Bitter":
                        flavor = FLAVOR.BITTER;
                        break;
                    case "Salty":
                        flavor = FLAVOR.SALTY;
                        break;
                    case "Spicy":
                        flavor = FLAVOR.SPICY;
                        break;
                    case "Boozy":
                        flavor = FLAVOR.BOOZY;
                        break;
                    case "Umami":
                        flavor = FLAVOR.UMAMI;
                        break;
                    case "Astringent":
                        flavor = FLAVOR.ASTRINGENT;
                        break;
                }

                String fruitArrayForArrayList[] = splitted[3].split("-");
                ArrayList fruitListForArrayList = new ArrayList();

                for (int i = 0; i < fruitArrayForArrayList.length; i++) {
                    fruitListForArrayList.add(fruitArrayForArrayList[i]);
                }

                Cocktail cocktailToBeAddedToOrderList = new Cocktail(splitted[0],splitted[1].equals("true") ? true : false, Integer.parseInt(splitted[2]),fruitListForArrayList,flavor,Double.parseDouble(splitted[5]));

                bill += cocktailToBeAddedToOrderList.getPrice();
                dlmOrders.addElement(cocktailToBeAddedToOrderList);
                cocktailArrayListForQueue.add(cocktailToBeAddedToOrderList);
                lblBill.setText("Bill:         " + bill);
            }
        });

        btnClearOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        btnTip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bill +=5;
                givenTip += 5;
                lblBill.setText("Bill:         " + bill);
            }
        });

        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bill > 0) {
                    btnOrder.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(btnPay,
                            "Add something to your order list or give tip.");
                }

            }
        });

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String successfulOperationMessage = cbTables.getSelectedItem().toString() + "\n";

                successfulOperationMessage += "Successful operation:\n";

                for (int i = 0; i < cocktailArrayListForQueue.size(); i++) {
                    successfulOperationMessage += (i + 1) + ":";
                    successfulOperationMessage += cocktailArrayListForQueue.get(i);
                    successfulOperationMessage += "\n";
                }

                successfulOperationMessage += "Given tip: " + givenTip + "\n";
                successfulOperationMessage += "Total bill: " + bill;

                JOptionPane.showMessageDialog(btnPay,
                        successfulOperationMessage);



                // QUEUE İŞLEMLERİ



                clear();
            }
        });
    }


    void clear() {
        dlmOrders.clear();
        bill = 0;
        givenTip = 0;
        lblBill.setText("Bill:                         ");
        btnOrder.setEnabled(false);
        cocktailArrayListForQueue.clear();
    }

    public static void main(String[] args) {
        new CustomerPanel().setVisible(true);
    }
}
