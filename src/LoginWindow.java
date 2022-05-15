import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginWindow extends JFrame {

    private String username = "admin";
    private String password = "password";
    JLabel lblUsername = new JLabel("Username:");
    JLabel lblPassword = new JLabel("Password:");

    JTextField txtUsername = new JTextField();
    JPasswordField txtPassword = new JPasswordField();

    JButton btnCancel = new JButton("Cancel");
    JButton btnSubmit = new JButton("Submit");

    JPanel pnlCenter = new JPanel(new GridLayout(2,2,0,10));
    JPanel pnlSouth = new JPanel(new FlowLayout());
    JPanel pnlBtnCancel = new JPanel(new FlowLayout());
    JPanel pnlBtnSubmit = new JPanel(new FlowLayout());

    public LoginWindow() {
        super("Login Window");

        setDesign();
        setListeners();

    }
    StaffPanel staffpanel = new StaffPanel();

    void setDesign() {

        setSize(300,200);
        setLocation(610,250);

        pnlCenter.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
        pnlCenter.add(lblUsername);
        pnlCenter.add(txtUsername);
        pnlCenter.add(lblPassword);
        pnlCenter.add(txtPassword);

        add(pnlCenter, BorderLayout.CENTER);

        pnlBtnCancel.add(btnCancel);
        pnlBtnSubmit.add(btnSubmit);

        pnlSouth.add(pnlBtnCancel);
        pnlSouth.add(pnlBtnSubmit);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    void setListeners() {
        btnCancel.addActionListener(new ActionListener() { // to clear login panel after clicking cancel button
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                txtUsername.setText("");
                txtPassword.setText("");
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtUsername.getText().equals(username) && String.valueOf(txtPassword.getPassword()).equals(password)) {
                    setVisible(false);
                    staffpanel.setVisible(true);
                }

            }
        });

        this.addWindowListener(new WindowAdapter() { // to clear login panel after window's closed by clicking X button at right top
            @Override
            public void windowDeactivated(WindowEvent e) {
                txtUsername.setText("");
                txtPassword.setText("");
            }
        });

    }



}
