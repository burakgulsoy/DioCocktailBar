import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JFrame {

    JPanel pnlNorth = new JPanel();
    JPanel pnlCenter = new JPanel();
    JPanel pnlSouth = new JPanel(new FlowLayout());
    JPanel pnlSend = new JPanel();

    JLabel lblOrderInformation = new JLabel("Order Information Table #");

    DefaultListModel dlmOrderInformation = new DefaultListModel();
    JList listOrderInformation = new JList(dlmOrderInformation);
    JScrollPane spOrderInformation = new JScrollPane(listOrderInformation);

    JButton btnCompleteOrder = new JButton("Complete Order");


    public OrderPanel() {
        super("Order Information Page");
        setLayout(new BorderLayout());
        setSize(350,270);

        setDesign();
        setListeners();
    }

    void setDesign() {
        pnlNorth.add(lblOrderInformation);

        add(pnlNorth, BorderLayout.NORTH);

        pnlCenter.add(spOrderInformation);

        add(pnlCenter, BorderLayout.CENTER);

        pnlSend.add(btnCompleteOrder);

        pnlSouth.add(pnlSend);

        add(pnlSouth, BorderLayout.SOUTH);
    }

    void setListeners() {

    }

    public static void main(String[] args) {
        new OrderPanel().setVisible(true);
    }
}
