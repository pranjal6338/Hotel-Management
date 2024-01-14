import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel Booking System");
        JLabel namelb, emaillb, mobilelb, genderlb, checkinlb, checkoutlb, paymentlb, addresslb, bookingid;
        JTextField nametf, emailtf, mobiletf, gendertf, checkintf, checkouttf, paymenttf, addresstf;
        JButton bookbtn, clearbtn, exitbtn;
        namelb = new JLabel("name");
        mobilelb = new JLabel("mobile no");
        emaillb = new JLabel("email");
        genderlb = new JLabel("gender");
        checkinlb = new JLabel("checkin");
        checkoutlb = new JLabel("checkout");
        paymentlb = new JLabel("payment");
        addresslb = new JLabel("address");
        bookingid = new JLabel();
        nametf = new JTextField();
        mobiletf = new JTextField();
        emailtf = new JTextField();
        gendertf = new JTextField();
        checkintf = new JTextField();
        checkouttf = new JTextField();
        paymenttf = new JTextField();
        addresstf = new JTextField();
        bookbtn = new JButton("book");
        clearbtn = new JButton("clear");
        exitbtn = new JButton("exit");
        namelb.setBounds(20, 30, 100, 40);
        emaillb.setBounds(20, 80, 100, 40);
        mobilelb.setBounds(20, 130, 100, 40);
        addresslb.setBounds(20, 180, 100, 40);
        genderlb.setBounds(280, 30, 100, 40);
        checkinlb.setBounds(280, 80, 100, 40);
        checkoutlb.setBounds(280, 130, 100, 40);
        paymentlb.setBounds(280, 180, 100, 40);
        bookingid.setBounds(50, 350, 300, 45);
        nametf.setBounds(120, 30, 150, 40);
        emailtf.setBounds(120, 80, 150, 40);
        mobiletf.setBounds(120, 130, 150, 40);
        addresstf.setBounds(120, 180, 150, 40);
        gendertf.setBounds(400, 30, 150, 40);
        checkintf.setBounds(400, 80, 150, 40);
        checkouttf.setBounds(400, 130, 150, 40);
        paymenttf.setBounds(400, 180, 150, 40);
        bookbtn.setBounds(50, 300, 100, 45);
        clearbtn.setBounds(250, 300, 100, 45);
        exitbtn.setBounds(400, 300, 100, 45);
        frame.add(bookbtn);
        frame.add(clearbtn);
        frame.add(exitbtn);
        frame.add(namelb);
        frame.add(emaillb);
        frame.add(mobilelb);
        frame.add(addresslb);
        frame.add(genderlb);
        frame.add(checkinlb);
        frame.add(checkoutlb);
        frame.add(paymentlb);
        frame.add(nametf);
        frame.add(emailtf);
        frame.add(mobiletf);
        frame.add(addresstf);
        frame.add(gendertf);
        frame.add(checkintf);
        frame.add(checkouttf);
        frame.add(paymenttf);
        frame.add(bookingid);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(700, 600);
        frame.setVisible(true);
        clearbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // to clear the data enter in form
                nametf.setText("");
                emailtf.setText("");
                addresslb.setText("");
                mobiletf.setText("");
                checkintf.setText("");
                checkouttf.setText("");
                paymenttf.setText("");
                addresstf.setText("");
                gendertf.setText("");
            }
        });
        bookbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nametf.getText().isEmpty() ||
                        emailtf.getText().isEmpty() ||
                        addresstf.getText().isEmpty() ||
                        gendertf.getText().isEmpty() ||
                        checkintf.getText().isEmpty() ||
                        checkouttf.getText().isEmpty() ||
                        paymenttf.getText().isEmpty() ||
                        mobiletf.getText().isEmpty()) {
                    bookingid.setText("Please enter all the details");
                } else {
                    String url = "jdbc:mysql://localhost:3306/hotel management";
                    String username = "root";
                    String password = "";

                    try {
                        Connection connection = DriverManager.getConnection(url, username, password);
                        String sql = "insert into booking" + " values(null,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement preparedStmt = connection.prepareStatement(sql);
                        preparedStmt.setString(1, nametf.getText());
                        preparedStmt.setString(2, mobiletf.getText());
                        preparedStmt.setString(3, emailtf.getText());
                        preparedStmt.setString(4, addresstf.getText());
                        preparedStmt.setString(5, gendertf.getText());
                        preparedStmt.setString(6, checkintf.getText());
                        preparedStmt.setString(7, checkouttf.getText());
                        preparedStmt.setString(8, paymenttf.getText());
                        preparedStmt.setString(9, bookingid.getText().toString());
                        preparedStmt.execute();
                        System.out.println("Database connected");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex + " Database not connected");
                    }
                    Random random = new Random();
                    int id = random.nextInt(99);
                    bookingid.setText("Your booking is confirmed and booking id is " + id);
                }

            }
        });
    }
}