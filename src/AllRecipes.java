import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class AllRecipes extends JFrame {

    BST_Cocktails bst_cocktails = new BST_Cocktails();

    JPanel pnlEdit = new JPanel(new FlowLayout());
    JPanel pnlDelete = new JPanel(new FlowLayout());
    JPanel pnlButtons = new JPanel(new FlowLayout());

    JButton btnEdit = new JButton("Edit");
    JButton btnDelete = new JButton("Delete");

    DefaultListModel dlm = new DefaultListModel();
    JList list = new JList(dlm);
    JScrollPane sp = new JScrollPane(list);


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

    }

    void additionalFunctions() {
        addDlmElements();
    }

    void createBST() {


        ObjectInputStream ois = null;
        try {
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
