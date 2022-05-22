import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class NewCocktailPage extends JFrame {
    private String fileName = "Cocktails";
    File file = new File(fileName);
    BST_Cocktails bst_cocktails;

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
                    if (btnSubmit.getText().equals("Submit")) {
                        registerNewCocktail(newCocktail);

                        cocktailArrayList.add(newCocktail);
                        dlm.clear();

                        int cocktailArrayLength = cocktailArrayList.size();
                        Cocktail cocktailArray[] = new Cocktail[cocktailArrayLength];

                        for (int i = 0; i < cocktailArrayList.size(); i++) {
                            cocktailArray[i] = cocktailArrayList.get(i);
                        }


                        for (int i = 0; i < cocktailArray.length; i++) {
                            for (int j = 0; j < cocktailArray.length; j++) {

                                if (j < cocktailArray.length - 1) {

                                    if (cocktailArray[j].getName().compareTo(cocktailArray[j + 1].getName()) > 0) {
                                        Cocktail temp = cocktailArray[j];
                                        cocktailArray[j] = cocktailArray[j + 1];
                                        cocktailArray[j + 1] = temp;
                                    }
                                }
                            }
                        }

                        cocktailArrayList.clear();

                        for (int i = 0; i < cocktailArray.length; i++) {
                            cocktailArrayList.add(cocktailArray[i]);
                            dlm.addElement(cocktailArray[i]);
                        }


//                        dlm.addElement(newCocktail);
                    } else if (btnSubmit.getText().equals("Update")) {
                        String element = jlist.getSelectedValue().toString();
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

                        Cocktail cocktailToBeRemoved = new Cocktail(splitted[0],splitted[1].equals("true") ? true : false, Integer.parseInt(splitted[2]),fruitListForArrayList,flavor,Double.parseDouble(splitted[5]));


                        int index = 0;

                        for (int i = 0; i < cocktailArrayList.size(); i++) {
                            if (cocktailArrayList.get(i).toString().equals(cocktailToBeRemoved.toString())) {
                                index = i;
                            }
                        }

                        cocktailArrayList.remove(index);  // değiştirilen eleman çıkartılıyor
                        cocktailArrayList.add(newCocktail); // yeni eleman ekleniyor
                        System.out.println("burası: " + cocktailArrayList);

                        PrintWriter pw = null;  // dosyayı sıfırlayıp
                        try {
                            pw = new PrintWriter(fileName);
                        } catch (FileNotFoundException ex) {
                            System.out.println("exp");
                        }
                        pw.close();

                        for (int i = 0; i < cocktailArrayList.size(); i++) {
                            registerNewCocktail(cocktailArrayList.get(i));  // değiştirilmiş versiyonla birlikte dosyaya tekrar yazdırıyoruz
                        }
                        dlm.clear();


                        int cocktailArrayLength = cocktailArrayList.size();
                        Cocktail cocktailArray[] = new Cocktail[cocktailArrayLength];

                        for (int i = 0; i < cocktailArrayList.size(); i++) {
                            cocktailArray[i] = cocktailArrayList.get(i);
                        }


                        for (int i = 0; i < cocktailArray.length; i++) {
                            for (int j = 0; j < cocktailArray.length; j++) {

                                if (j < cocktailArray.length - 1) {

                                    if (cocktailArray[j].getName().compareTo(cocktailArray[j + 1].getName()) > 0) {
                                        Cocktail temp = cocktailArray[j];
                                        cocktailArray[j] = cocktailArray[j + 1];
                                        cocktailArray[j + 1] = temp;
                                    }
                                }
                            }
                        }

                        cocktailArrayList.clear();

                        for (int i = 0; i < cocktailArray.length; i++) {
                            cocktailArrayList.add(cocktailArray[i]);
                            dlm.addElement(cocktailArray[i]);
                        }

                        bst_cocktails.setCocktailArrayList(cocktailArrayList);

                        System.out.println("burası2: " + cocktailArrayList);
                        System.out.println("son bst hali: " + bst_cocktails.getCocktailArrayList());


                    }

                }


            }
        });

        txtAlcoholRate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (cbContainsAlcohol.getSelectedIndex() == 0) {
                    txtAlcoholRate.setEnabled(true);
                } else {
                    txtAlcoholRate.setText("0");
                    txtAlcoholRate.setEnabled(false);
                }
            }
        });
    }

    DefaultListModel<Cocktail> dlm;
    JList jlist;
    ArrayList<Cocktail> cocktailArrayList;
    public void transferDlmAndList(DefaultListModel<Cocktail> dlm, JList jlist, ArrayList<Cocktail> cocktailArrayList,BST_Cocktails bst_cocktails) {
        this.dlm = dlm;
        this.jlist = jlist;
        this.cocktailArrayList = cocktailArrayList;
        this.bst_cocktails = bst_cocktails;
    }

//    void addDlmElements() {
//
//        for (int i = 0; i < bst_cocktails.getCocktailArrayList().size(); i++) {
//            dlm.addElement(bst_cocktails.getCocktailArrayList().get(i));
//        }
//
//    }



//    public static void main(String[] args) {
//        new NewCocktailPage().setVisible(true);
//    }

    void clear() {
        txtName.setText("");
        cbContainsAlcohol.setSelectedIndex(0);
        txtAlcoholRate.setText("");
        txtFruits.setText("");
        cbFlavor.setSelectedIndex(0);
        txtPrice.setText("");

    }

    void registerNewCocktail(Cocktail newCocktail) {

          ObjectOutputStream oos;
//        AppendingObjectOutputStream aoos;
        try {
            if (file.length() != 0) {
                AppendingObjectOutputStream aoos;
                aoos = new AppendingObjectOutputStream(new FileOutputStream(fileName, true));
                aoos.writeObject(newCocktail);
//            System.out.println(newCocktail);
                aoos.close();
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fileName));
                oos.writeObject(newCocktail);
                oos.close();
            }
//
//            oos.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
