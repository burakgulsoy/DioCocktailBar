import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class CustomerPanelMenu extends JFrame {

    SeeInformationPanel seeInformationPanel = new SeeInformationPanel();
//    ArrayList<Cocktail> cocktailArrayList = new ArrayList<>();
//    File file = new File("Cocktails");

//    BST_Cocktails bst_cocktails = new BST_Cocktails();

    JPanel pnlEdit = new JPanel(new FlowLayout());
    JPanel pnlDelete = new JPanel(new FlowLayout());
    JPanel pnlSeeInformationBtn = new JPanel(new FlowLayout());

    JButton btnSeeInformation = new JButton("See Information");

    DefaultListModel dlm = new DefaultListModel();
    JList list = new JList(dlm);
    JScrollPane sp = new JScrollPane(list);


    public CustomerPanelMenu() {

        setDesign();
        setListeners();
    }


    void setDesign() {
        setLayout(new BorderLayout());
        setSize(400, 500);


        pnlEdit.add(btnSeeInformation);

        pnlSeeInformationBtn.add(pnlEdit);

        add(sp, BorderLayout.CENTER);
        add(pnlSeeInformationBtn, BorderLayout.SOUTH);
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
