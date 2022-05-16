import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class AllRecipes extends JFrame {


    NewCocktailPage newCocktailPage;
    File file = new File("Cocktails");


    BST_Cocktails bst_cocktails = new BST_Cocktails();

    JPanel pnlEdit = new JPanel(new FlowLayout());
    JPanel pnlDelete = new JPanel(new FlowLayout());
    JPanel pnlButtons = new JPanel(new FlowLayout());

    JButton btnEdit = new JButton("Edit");
    JButton btnDelete = new JButton("Delete");

    DefaultListModel dlm = new DefaultListModel();
    JList list = new JList(dlm);
    JScrollPane sp = new JScrollPane(list);



    public AllRecipes(NewCocktailPage newCocktailPage) {
        super("All Recipes");
        this.newCocktailPage = newCocktailPage;

    public AllRecipes() {
        super("All Recipes");

        createBST();
//        outputBST();

        bst_cocktails.inorderCreatingArrayList(bst_cocktails.getRoot());
        System.out.println(bst_cocktails.getCocktailArrayList());

        setDesign();
        setListeners();
        additionalFunctions();
    }

    void setDesign() {
        setLayout(new BorderLayout());
        setSize(400, 500);


        pnlEdit.add(btnEdit);
        pnlDelete.add(btnDelete);

        pnlButtons.add(pnlEdit);
        pnlButtons.add(pnlDelete);

        add(sp, BorderLayout.CENTER);
        add(pnlButtons, BorderLayout.SOUTH);
    }

    void setListeners() {


        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (list.getSelectedIndex() == -1) {
                    return;
                }
                newCocktailPage.clear();
                newCocktailPage.setVisible(true);
                newCocktailPage.btnSubmit.setText("Update");

                String element = list.getSelectedValue().toString();
                String splitted[] = element.split(" ");

                newCocktailPage.txtName.setText(splitted[0]);

                if (splitted[1].equals("true")) {
                    newCocktailPage.cbContainsAlcohol.setSelectedIndex(0);
                } else {
                    newCocktailPage.cbContainsAlcohol.setSelectedIndex(1);
                }

                newCocktailPage.txtAlcoholRate.setText(splitted[2]);
                newCocktailPage.txtFruits.setText(splitted[3]);

                String flavor = splitted[4];

                switch (flavor) {
                    case "Sweet":
                        newCocktailPage.cbFlavor.setSelectedIndex(0);
                        break;
                    case "Sour":
                        newCocktailPage.cbFlavor.setSelectedIndex(1);
                        break;
                    case "Bitter":
                        newCocktailPage.cbFlavor.setSelectedIndex(2);
                        break;
                    case "Salty":
                        newCocktailPage.cbFlavor.setSelectedIndex(3);
                        break;
                    case "Spicy":
                        newCocktailPage.cbFlavor.setSelectedIndex(4);
                        break;
                    case "Boozy":
                        newCocktailPage.cbFlavor.setSelectedIndex(5);
                        break;
                    case "Umami":
                        newCocktailPage.cbFlavor.setSelectedIndex(6);
                        break;
                    case "Astringent":
                        newCocktailPage.cbFlavor.setSelectedIndex(7);
                        break;
                }

                newCocktailPage.txtPrice.setText(splitted[5]);


            }
        });


    }

    void additionalFunctions() {
        addDlmElements();
    }

    void createBST() {


        ObjectInputStream ois = null;
        try {

            if (file.length() != 0) {
                ois = new ObjectInputStream(new FileInputStream("Cocktails"));
                while (true) {
                    Cocktail cocktail = (Cocktail) ois.readObject();
//                ois.close();
//                System.out.println(cocktail);
                    bst_cocktails.insert(cocktail);
                }
            }



            ois = new ObjectInputStream(new FileInputStream("Cocktails2"));
            while (true) {
                Cocktail cocktail = (Cocktail) ois.readObject();
//                ois.close();
//                System.out.println(cocktail);
                bst_cocktails.insert(cocktail);
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

    void outputBST() {
        bst_cocktails.inorder(bst_cocktails.getRoot());
    }

    void addDlmElements() {

        for (int i = 0; i < bst_cocktails.getCocktailArrayList().size(); i++) {
            dlm.addElement(bst_cocktails.getCocktailArrayList().get(i));
        }

    }








//    public static void main(String[] args) {
//        new AllRecipes().setVisible(true);
//    }

}
