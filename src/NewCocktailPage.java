import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;

public class NewCocktailPage extends JFrame {

    JPanel pnlCenter = new JPanel(new GridLayout(6, 2, 15, 10));
    JPanel pnlSouth = new JPanel(new FlowLayout());

    JLabel lblName = new JLabel("Name:");
    JLabel lblContainsAlcohol = new JLabel("Contains Alcohol:");
    JLabel lblAlcoholRate = new JLabel("Alcohol Rate:");
    JLabel lblFruits = new JLabel("Fruits: (fruit1-fruit2-fruit3) max3");
    JLabel lblFlavor = new JLabel("Flavor:");
    JLabel lblPrice = new JLabel("Price:");

    JTextField txtName = new JTextField();
    JTextField txtAlcoholRate = new JTextField();
    JTextField txtFruits = new JTextField();
    JTextField txtPrice = new JTextField();

    JButton btnCancel = new JButton("Cancel");
    JButton btnClear = new JButton("Clear");
    JButton btnSubmit = new JButton("Submit");

    static FLAVOR flavors[] = FLAVOR.values();
    JComboBox<FLAVOR> cbFlavor = new JComboBox<>(flavors);

    String containsAlcohol[] = {"true", "false"};
    JComboBox<String> cbContainsAlcohol = new JComboBox<>(containsAlcohol);

    String fruitsRule = "[A-Za-z]+(-[A-Za-z])*(-[A-Za-z])*";


    public NewCocktailPage() {
        super("New Cocktail");

        setDesign();
        setListeners();
    }

    void setDesign() {
        setSize(400, 320);
        setLayout(new BorderLayout());

        pnlCenter.add(lblName);
        pnlCenter.add(txtName);
        pnlCenter.add(lblContainsAlcohol);
        pnlCenter.add(cbContainsAlcohol);
        pnlCenter.add(lblAlcoholRate);
        pnlCenter.add(txtAlcoholRate);
        pnlCenter.add(lblFruits);
        pnlCenter.add(txtFruits);
        pnlCenter.add(lblFlavor);
        pnlCenter.add(cbFlavor);
        pnlCenter.add(lblPrice);
        pnlCenter.add(txtPrice);

        add(pnlCenter, BorderLayout.CENTER);

        pnlSouth.add(btnCancel);
        pnlSouth.add(btnClear);
        pnlSouth.add(btnSubmit);

        add(pnlSouth, BorderLayout.SOUTH);

    }

    void setListeners() {



        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
                setVisible(false);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(txtFruits.getText().matches("[A-Za-z]+") || txtFruits.getText().matches("[A-Za-z]+[-][A-Za-z]*") || txtFruits.getText().matches("[A-Za-z]+[-][A-Za-z]*[-][A-Za-z]*"))) {
                    txtFruits.setText("wrong");
                } else {
                    ArrayList fruitList = new ArrayList();
                    String fruitArray[] = txtFruits.getText().split("-");
                    boolean containsAlcohol = false;

                    for (int i = 0; i < fruitArray.length; i++) {
                        fruitList.add(fruitArray[i]);
                    }

                    if (cbContainsAlcohol.getSelectedItem().equals("false")) {
                        containsAlcohol = false;
                    } else if (cbContainsAlcohol.getSelectedItem().equals("true")){
                        containsAlcohol = true;
                    }

                    Cocktail newCocktail = new Cocktail(txtName.getText(), containsAlcohol, Integer.parseInt(txtAlcoholRate.getText()), fruitList, (FLAVOR) cbFlavor.getSelectedItem(),Double.parseDouble(txtPrice.getText()));

                    System.out.println(newCocktail);
                    registerNewCocktail(newCocktail);
                    fruitList.clear();
                }
            }
        });
    }



    public static void main(String[] args) {
        new NewCocktailPage().setVisible(true);
    }

    void clear() {
        txtName.setText("");
        cbContainsAlcohol.setSelectedIndex(0);
        txtAlcoholRate.setText("");
        txtFruits.setText("");
        cbFlavor.setSelectedIndex(0);
        txtPrice.setText("");

    }

    void registerNewCocktail(Cocktail newCocktail) {

        ObjectOutputStream oos = null;
        try {
            AppendingObjectOutputStream aoos;
            aoos = new AppendingObjectOutputStream(new FileOutputStream("Cocktails2",true));
            aoos.writeObject(newCocktail);
//            System.out.println(newCocktail);
            aoos.close();
//            oos.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

 class AppendingObjectOutputStream extends ObjectOutputStream {

    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }

}
