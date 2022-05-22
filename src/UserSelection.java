import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserSelection extends JFrame {
    JLabel lblTitle = new JLabel("Cocktail Bar System User Selection");

    JButton btnStaff = new JButton("Staff");
    JButton btnCustomer = new JButton("Customer");

    JPanel pnlAll = new JPanel(new GridLayout(2, 1));
    JPanel pnlBtnStaff = new JPanel(new FlowLayout());
    JPanel pnlBtnCustomer = new JPanel(new FlowLayout());
    JPanel pnlTitle = new JPanel(new BorderLayout());
    JPanel pnlButtons = new JPanel(new GridLayout(1,2));

//    LoginWindow lw = new LoginWindow();
    StaffPanel staffpanel = new StaffPanel();
    CustomerPanel customerPanel = new CustomerPanel();

    TableObject table1 = new TableObject();
    TableObject table2 = new TableObject();
    TableObject table3 = new TableObject();
    TableObject table4 = new TableObject();
    TableObject table5 = new TableObject();
    TableObject table6 = new TableObject();
    TableObject table7 = new TableObject();
    TableObject table8 = new TableObject();
    TableObject table9 = new TableObject();

    public UserSelection(){
        super("User Selection Page");

        setDesign();
        setListeners();

//        createBST();
//        outputBST();
    }


    void setDesign() {

        setLayout(new BorderLayout());
        setSize(430,250);

        pnlBtnStaff.add(btnStaff);
        pnlBtnCustomer.add(btnCustomer);


        pnlButtons.add(pnlBtnStaff);
        pnlButtons.add(pnlBtnCustomer);

        pnlTitle.add(lblTitle, BorderLayout.CENTER);

        pnlAll.add(pnlTitle);
        pnlAll.add(pnlButtons);

        add(pnlAll, BorderLayout.CENTER);

        pnlTitle.setBorder(BorderFactory.createEmptyBorder(0,35,20,0));
        lblTitle.setFont(new Font("Dialog.bold",Font.PLAIN,20));


    }

    void setListeners() {
        btnStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                lw.setVisible(true);
//                lw.txtUsername.setText("admin");
//                lw.txtPassword.setText("password");
                staffpanel.setVisible(true);
            }
        });

        btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerPanel.setVisible(true);
            }
        });

        customerPanel.btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String successfulOperationMessage = customerPanel.cbTables.getSelectedItem().toString() + "\n";

                successfulOperationMessage += "Successful operation:\n";

                for (int i = 0; i < customerPanel.cocktailArrayListForQueue.size(); i++) {
                    successfulOperationMessage += (i + 1) + ":";
                    successfulOperationMessage += customerPanel.cocktailArrayListForQueue.get(i);
                    successfulOperationMessage += "\n";
                }

                successfulOperationMessage += "Given tip: " + customerPanel.getGivenTip() + "\n";
                successfulOperationMessage += "Total bill: " + customerPanel.getBill();

                JOptionPane.showMessageDialog(customerPanel.btnPay,
                        successfulOperationMessage);

                // QUEUE İŞLEMLERİ
                // burada arraylist'i sıfırlayınca table içindeki arraylist'i de sıfırlar mı emin değilim

                ArrayList<Cocktail> cocktailArrayListforTableObject = new ArrayList<>();

                for (int i = 0; i < customerPanel.cocktailArrayListForQueue.size(); i++) {
                    cocktailArrayListforTableObject.add(customerPanel.cocktailArrayListForQueue.get(i));
                }

                TableObject table = new TableObject(customerPanel.cbTables.getSelectedItem().toString(), cocktailArrayListforTableObject);

                switch (table.getTableName()) {
                    case "Table1":
                        table1 = table;
                        changeButtonColorForNewOrder(staffpanel.btnTable1,table1);
                        break;
                    case "Table2":
                        table2 = table;
                        changeButtonColorForNewOrder(staffpanel.btnTable2,table2);
                        break;
                    case "Table3":
                        table3 = table;
                        changeButtonColorForNewOrder(staffpanel.btnTable3,table3);
                        break;
                    case "Table4":
                        table4 = table;
                        changeButtonColorForNewOrder(staffpanel.btnTable4,table4);
                        break;
                    case "Table5":
                        table5 = table;
                        changeButtonColorForNewOrder(staffpanel.btnTable5,table5);
                        break;
                    case "Table6":
                        table6 = table;
                        changeButtonColorForNewOrder(staffpanel.btnTable6,table6);
                        break;
                    case "Table7":
                        table7 = table;
                        changeButtonColorForNewOrder(staffpanel.btnTable7,table7);
                        break;
                    case "Table8":
                        table8 = table;
                        changeButtonColorForNewOrder(staffpanel.btnTable8,table8);
                        break;
                    case "Table9":
                        table9 = table;
                        changeButtonColorForNewOrder(staffpanel.btnTable9,table9);
                        break;
                }

                System.out.println(staffpanel.btnTable2.getBackground());
//                System.out.println(table);
                customerPanel.clear();
                System.out.println(table);

            }
        });

        staffpanel.orderPanel.btnCompleteOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lblInformationContent[] = staffpanel.orderPanel.lblOrderInformation.getText().split(" ");
                String tableName = lblInformationContent[2];

                staffpanel.orderPanel.dlmOrderInformation.clear();

                switch (tableName) {
                    case "Table1":
                        changeButtonColorToDefault(staffpanel.btnTable1);
                        table1.getTableCocktailArraylist().clear();
                        break;
                    case "Table2":
                        changeButtonColorToDefault(staffpanel.btnTable2);
                        table2.getTableCocktailArraylist().clear();
                        break;
                    case "Table3":
                        changeButtonColorToDefault(staffpanel.btnTable3);
                        table3.getTableCocktailArraylist().clear();
                        break;
                    case "Table4":
                        changeButtonColorToDefault(staffpanel.btnTable4);
                        table4.getTableCocktailArraylist().clear();
                        break;
                    case "Table5":
                        changeButtonColorToDefault(staffpanel.btnTable5);
                        table5.getTableCocktailArraylist().clear();
                        break;
                    case "Table6":
                        changeButtonColorToDefault(staffpanel.btnTable6);
                        table6.getTableCocktailArraylist().clear();
                        break;
                    case "Table7":
                        changeButtonColorToDefault(staffpanel.btnTable7);
                        table7.getTableCocktailArraylist().clear();
                        break;
                    case "Table8":
                        changeButtonColorToDefault(staffpanel.btnTable8);
                        table8.getTableCocktailArraylist().clear();
                        break;
                    case "Table9":
                        changeButtonColorToDefault(staffpanel.btnTable9);
                        table9.getTableCocktailArraylist().clear();
                        break;
                }

            }
        });

        setActionListenersForButtons();
    }

    void setActionListenersForButtons() {

        staffpanel.btnTable1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLblOrderInformation(staffpanel.btnTable1);
                staffpanel.orderPanel.dlmOrderInformation.clear();
                addElementsToOrderPanel(table1);
                staffpanel.orderPanel.setVisible(true);

            }
        });

        staffpanel.btnTable2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLblOrderInformation(staffpanel.btnTable2);
                staffpanel.orderPanel.dlmOrderInformation.clear();
                addElementsToOrderPanel(table2);
                staffpanel.orderPanel.setVisible(true);
            }
        });

        staffpanel.btnTable3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLblOrderInformation(staffpanel.btnTable3);
                staffpanel.orderPanel.dlmOrderInformation.clear();
                addElementsToOrderPanel(table3);
                staffpanel.orderPanel.setVisible(true);
            }
        });

        staffpanel.btnTable4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLblOrderInformation(staffpanel.btnTable4);
                staffpanel.orderPanel.dlmOrderInformation.clear();
                addElementsToOrderPanel(table4);
                staffpanel.orderPanel.setVisible(true);
            }
        });

        staffpanel.btnTable5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLblOrderInformation(staffpanel.btnTable5);
                staffpanel.orderPanel.dlmOrderInformation.clear();
                addElementsToOrderPanel(table5);
                staffpanel.orderPanel.setVisible(true);
            }
        });

        staffpanel.btnTable6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLblOrderInformation(staffpanel.btnTable6);
                staffpanel.orderPanel.dlmOrderInformation.clear();
                addElementsToOrderPanel(table6);
                staffpanel.orderPanel.setVisible(true);
            }
        });

        staffpanel.btnTable7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLblOrderInformation(staffpanel.btnTable7);
                staffpanel.orderPanel.dlmOrderInformation.clear();
                addElementsToOrderPanel(table7);
                staffpanel.orderPanel.setVisible(true);
            }
        });

        staffpanel.btnTable8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLblOrderInformation(staffpanel.btnTable8);
                staffpanel.orderPanel.dlmOrderInformation.clear();
                addElementsToOrderPanel(table8);
                staffpanel.orderPanel.setVisible(true);
            }
        });

        staffpanel.btnTable9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeLblOrderInformation(staffpanel.btnTable9);
                staffpanel.orderPanel.dlmOrderInformation.clear();
                addElementsToOrderPanel(table9);
                staffpanel.orderPanel.setVisible(true);
            }
        });
    }

    void changeLblOrderInformation(JButton button) {
        staffpanel.orderPanel.lblOrderInformation.setText("Order Information " + button.getText());
    }

    void addElementsToOrderPanel(TableObject tableX) {

        for (int i = 0; i < tableX.getTableCocktailArraylist().size(); i++) {
            staffpanel.orderPanel.dlmOrderInformation.addElement(tableX.getTableCocktailArraylist().get(i));
        }

    }

    void changeButtonColorForNewOrder(JButton button, TableObject tableX) {
        if (tableX.getTableCocktailArraylist().size() != 0) {
            button.setBackground(Color.RED);
        } else {
            button.setBackground(new Color(241, 180, 6));
        }

    }

    void changeButtonColorToDefault(JButton button) {
        button.setBackground(null);
    }

    public static void main(String[] args) {
        new UserSelection().setVisible(true);
    }



}
