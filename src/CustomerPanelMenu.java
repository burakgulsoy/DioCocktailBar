import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class CustomerPanelMenu extends JFrame {

    SeeInformationPanel seeInformationPanel = new SeeInformationPanel();
//    ArrayList<Cocktail> cocktailArrayListCustomer = new ArrayList<>();   // aslında BST içindeki arraylist kullanılabilir buna gerek yok
    File file = new File("Cocktails");

    BST_Cocktails bst_cocktailsCustomer = new BST_Cocktails();

    JPanel pnlSeeInformation = new JPanel(new FlowLayout());
    JPanel pnlAddToBasket = new JPanel(new FlowLayout());
    JPanel pnlSouth = new JPanel(new FlowLayout());

    JButton btnSeeInformation = new JButton("See Information");
    JButton btnAddToOrderList = new JButton("Add to order list");
    DefaultListModel dlm = new DefaultListModel();
    JList list = new JList(dlm);
    JScrollPane sp = new JScrollPane(list);



    public CustomerPanelMenu() {
        super("Customer Panel Menu");
        createBST();
        bst_cocktailsCustomer.inorderCreatingArrayList(bst_cocktailsCustomer.getRoot()); // sorted arraylist is created inside BST

        setDesign();
        setListeners();
        addDlmElements();
    }


    void setDesign() {
        setLayout(new BorderLayout());
        setSize(400, 500);


        pnlSeeInformation.add(btnSeeInformation);
        pnlAddToBasket.add(btnAddToOrderList);


        add(sp, BorderLayout.CENTER);

        pnlSouth.add(pnlSeeInformation);
        pnlSouth.add(pnlAddToBasket);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    void setListeners() {

        btnSeeInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.getSelectedIndex() == -1) {
                    return;
                }

                String element = list.getSelectedValue().toString();
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


                seeInformationPanel.lblNameInfo.setText(splitted[0]);
                seeInformationPanel.lblContainsAlcoholInfo.setText(splitted[1]);
                seeInformationPanel.lblAlcoholRateInfo.setText(splitted[2]);
                seeInformationPanel.lblFruitsInfo.setText(fruitListForArrayList.toString());
                seeInformationPanel.lblFlavorInfo.setText(flavor.toString());
                seeInformationPanel.lblPriceInfo.setText(splitted[5]);



                seeInformationPanel.setVisible(true);
            }
        });
    }

    public void createBST() {


        ObjectInputStream ois = null;
        try {
            if (file.length() != 0) {
                ois = new ObjectInputStream(new FileInputStream("Cocktails"));
                while (true) {
                    Cocktail cocktail = (Cocktail) ois.readObject();
                    bst_cocktailsCustomer.insert(cocktail);
                }
            }


        } catch (FileNotFoundException e) { // IOException is enough
            e.printStackTrace();
        } catch (EOFException e) { // IOException is enough
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void addDlmElements() {

        for (int i = 0; i < bst_cocktailsCustomer.getCocktailArrayList().size(); i++) {
            dlm.addElement(bst_cocktailsCustomer.getCocktailArrayList().get(i));
        }

    }


}
