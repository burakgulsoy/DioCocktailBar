import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuManagement extends JFrame {

    NewCocktailPage newCocktailPage = new NewCocktailPage();

    AllRecipes allRecipes = new AllRecipes(newCocktailPage);
=======
    AllRecipes allRecipes = new AllRecipes();


    JPanel pnlButtons = new JPanel(new GridLayout(1, 2, 10, 10));
    JButton btnNew = new JButton("New");
    JButton btnSeeAll = new JButton("See All");


    public MenuManagement() {
        super("Menu Management");


        setDesign();
        setListeners();
    }


    void setDesign() {
        setLayout(new FlowLayout());
        setSize(350, 125);
        setLocation(500, 300);

        pnlButtons.add(btnNew);
        pnlButtons.add(btnSeeAll);

        add(pnlButtons);
    }

    void setListeners() {

        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newCocktailPage.btnSubmit.setText("Submit");
                newCocktailPage.setVisible(true);
                setVisible(false);
            }
        });

        btnSeeAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allRecipes.setVisible(true);
                setVisible(false);
            }
        });
    }



//    public static void main(String[] args) {
//        new MenuManagement().setVisible(true);
//    }

}
