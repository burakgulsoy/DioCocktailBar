import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class UserSelection extends JFrame {
    BST_Cocktails bst = new BST_Cocktails();
    JLabel lblTitle = new JLabel("Cocktail Bar System User Selection");

    JButton btnStaff = new JButton("Staff");
    JButton btnCustomer = new JButton("Customer");

    JPanel pnlAll = new JPanel(new GridLayout(2, 1));
    JPanel pnlBtnStaff = new JPanel(new FlowLayout());
    JPanel pnlBtnCustomer = new JPanel(new FlowLayout());
    JPanel pnlTitle = new JPanel(new BorderLayout());
    JPanel pnlButtons = new JPanel(new GridLayout(1,2));

    LoginWindow lw = new LoginWindow();
    CustomerPanelMenu customerPanelMenu = new CustomerPanelMenu();

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
                lw.setVisible(true);
            }
        });

        btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerPanelMenu.setVisible(true);
            }
        });
    }

//    void createBST() {
//
//
//        ObjectInputStream ois = null;
//        try {
//            ois = new ObjectInputStream(new FileInputStream("Cocktails2"));
//            while (true) {
//                Cocktail cocktail = (Cocktail) ois.readObject();
////                ois.close();
////                System.out.println(cocktail);
//                bst.insert(cocktail);
//            }
//
//        } catch (FileNotFoundException e) { // IOException is enough
//            e.printStackTrace();
//        } catch (EOFException e) { // IOException is enough
//            return;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

//    void outputBST() {
//        bst.inorder(bst.getRoot());
//    }

    public static void main(String[] args) {
        new UserSelection().setVisible(true);
    }



}
