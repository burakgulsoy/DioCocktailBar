import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeeAllOrdersPanel extends JFrame {

    Queue cocktailLinkedQueue = new Queue();

    JPanel pnlNorth = new JPanel();
    JPanel pnlCenter = new JPanel();
    JPanel pnlSouth = new JPanel(new FlowLayout());
    JPanel pnlSendOrderAtTheTop = new JPanel();

    JLabel lblTitle = new JLabel("All Orders");

    JButton btnSendOrderAtTheTop = new JButton("Send Order At The Top");

    DefaultListModel dlmQueue = new DefaultListModel();
    JList listOrderQueue = new JList(dlmQueue);
    JScrollPane spOrderQueueInformation = new JScrollPane(listOrderQueue);


    public SeeAllOrdersPanel() {
        super("See All Orders Panel");
        setLayout(new BorderLayout());
        setSize(400,290);

        setDesign();
        setListeners();
    }

    void setDesign() {
        pnlNorth.add(lblTitle);

        add(pnlNorth, BorderLayout.NORTH);

        pnlCenter.add(spOrderQueueInformation);

        add(pnlCenter, BorderLayout.CENTER);

        pnlSendOrderAtTheTop.add(btnSendOrderAtTheTop);

        pnlSouth.add(pnlSendOrderAtTheTop);

        add(pnlSouth, BorderLayout.SOUTH);
    }

    void setListeners() {

        btnSendOrderAtTheTop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cocktailLinkedQueue.isEmpty() == false) {
                    dlmQueue.remove(0);
                    cocktailLinkedQueue.deleteQueue();
                } else {
                    return;
                }
            }
        });
    }


}
