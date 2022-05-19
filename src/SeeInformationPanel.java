import javax.swing.*;
import java.awt.*;

public class SeeInformationPanel extends JFrame {

    JLabel lblName = new JLabel("Name:");
    JLabel lblNameInfo = new JLabel();
    JLabel lblContainsAlcohol = new JLabel("Contains Alcohol:");
    JLabel lblContainsAlcoholInfo = new JLabel();
    JLabel lblAlcoholRate = new JLabel("Alcohol Rate:");
    JLabel lblAlcoholRateInfo = new JLabel();
    JLabel lblFruits = new JLabel("Fruits:");
    JLabel lblFruitsInfo = new JLabel();
    JLabel lblFlavor = new JLabel("Flavor:");
    JLabel lblFlavorInfo = new JLabel();
    JLabel lblPrice = new JLabel("Price:");
    JLabel lblPriceInfo = new JLabel();


    JButton btnAddToBasket = new JButton("Add to basket");

    JPanel pnlCenter = new JPanel(new GridLayout(6, 2, 15, 10));
    JPanel pnlSouth = new JPanel(new FlowLayout());




    public SeeInformationPanel() {

        setDesign();
        setListeners();
    }

    void setDesign() {
        setSize(400, 320);
        setLayout(new BorderLayout());

        pnlCenter.add(lblName);
        pnlCenter.add(lblNameInfo);
        pnlCenter.add(lblContainsAlcohol);
        pnlCenter.add(lblContainsAlcoholInfo);
        pnlCenter.add(lblAlcoholRate);
        pnlCenter.add(lblAlcoholRateInfo);
        pnlCenter.add(lblFruits);
        pnlCenter.add(lblFruitsInfo);
        pnlCenter.add(lblFlavor);
        pnlCenter.add(lblFlavorInfo);
        pnlCenter.add(lblPrice);
        pnlCenter.add(lblPriceInfo);

        add(pnlCenter, BorderLayout.CENTER);

        pnlSouth.add(btnAddToBasket);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    void setListeners() {

    }


}
