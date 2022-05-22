import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPanelMenu extends JFrame {

    SeeInformationPanel seeInformationPanel = new SeeInformationPanel();
//    ArrayList<Cocktail> cocktailArrayList = new ArrayList<>();
//    File file = new File("Cocktails");

//    BST_Cocktails bst_cocktails = new BST_Cocktails();

    JPanel pnlSeeInformation = new JPanel(new FlowLayout());
    JPanel pnlAddToBasket = new JPanel(new FlowLayout());
    JPanel pnlSeeInformationBtn = new JPanel(new FlowLayout());
    JPanel pnlSouth = new JPanel(new FlowLayout());

    JButton btnSeeInformation = new JButton("See Information");
    JButton btnAddToOrderList = new JButton("Add to order list");
    DefaultListModel dlm = new DefaultListModel();
    JList list = new JList(dlm);
    JScrollPane sp = new JScrollPane(list);


    public CustomerPanelMenu() {
        super("Customer Panel Menu");

        setDesign();
        setListeners();
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
                seeInformationPanel.setVisible(true);
            }
        });
    }

//    public static void main(String[] args) {
//        new CustomerPanelMenu().setVisible(true);
//    }
}
