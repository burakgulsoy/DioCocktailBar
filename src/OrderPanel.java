import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JFrame {

    JPanel pnlNorth = new JPanel();
    JPanel pnlCenter = new JPanel();
    JPanel pnlSouth = new JPanel(new GridLayout(2,2,5,5));
    JPanel pnlClearTable = new JPanel();
    JPanel pnlSend = new JPanel();

    JLabel lblOrderInformation = new JLabel("Order Information Table #");
    JLabel lblNote = new JLabel("Note:");

    JTextArea txtOrderInformation = new JTextArea();
    JTextArea txtNote = new JTextArea();

    JButton btnClearTable = new JButton("Clear Table");
    JButton btnCompleteOrder = new JButton("Complete Order");


    public OrderPanel() {
        setLayout(new BorderLayout());
        setSize(300,400);

        setDesign();
        setListeners();
    }

    void setDesign() {
        pnlNorth.add(lblOrderInformation);

        add(pnlNorth, BorderLayout.NORTH);

        pnlCenter.add(txtOrderInformation);

        add(pnlCenter, BorderLayout.CENTER);

        pnlClearTable.add(btnClearTable);
        pnlSend.add(btnCompleteOrder);

        pnlSouth.add(lblNote);
        pnlSouth.add(txtNote);
        pnlSouth.add(pnlClearTable);
        pnlSouth.add(pnlSend);

        add(pnlSouth, BorderLayout.SOUTH);

        txtOrderInformation.setEditable(false);
        txtOrderInformation.setLineWrap(true);
//        txtNote.setEditable(false);
        txtNote.setLineWrap(true);
    }

    void setListeners() {

    }

//    public static void main(String[] args) {
//        new OrderPanel().setVisible(true);
//    }
}
