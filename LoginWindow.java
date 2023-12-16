package Final_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginWindow extends JFrame {
    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtPassword;
    private JTextField txtAlert;

    public LoginWindow(String path, String filePath) {
        QuestionCategories categoriesList = new QuestionCategories();
        categoriesList.readFile(filePath);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("User Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblName.setBounds(47, 31, 119, 23);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPassword.setBounds(47, 64, 119, 23);
        contentPane.add(lblPassword);

        txtName = new JTextField();
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtName.setBounds(162, 31, 241, 23);
        contentPane.add(txtName);
        txtName.setColumns(10);

        txtPassword = new JTextField();
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtPassword.setColumns(10);
        txtPassword.setBounds(162, 64, 241, 23);
        contentPane.add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = txtName.getText();
                String passWord = txtPassword.getText();
                int authority = valid(userName, passWord, path);
                if(authority == 0){
                    txtAlert.setText("Invalid input.");
                } else if(authority == 1){
                    TeacherWindow teacherWindow = new TeacherWindow(categoriesList, filePath);
                    teacherWindow.setVisible(true);
                    dispose();
                } else{
                    StudentWindow studentWindow = new StudentWindow(categoriesList, filePath);
                    studentWindow.setVisible(true);
                    dispose();
                }
            }
        });
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnLogin.setBounds(47, 97, 172, 23);
        contentPane.add(btnLogin);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCancel.setBounds(229, 97, 174, 23);
        contentPane.add(btnCancel);

        txtAlert = new JTextField();
        txtAlert.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtAlert.setColumns(10);
        txtAlert.setBounds(47, 130, 356, 23);
        contentPane.add(txtAlert);
    }

    public int valid(String userName, String passWord, String path){
        int success = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String Name = in.readLine();
            String Pass = in.readLine();
            if(Name.equals(userName) && Pass.equals(passWord)){
                success = 1;
            } else {
                Name = in.readLine();
                Pass = in.readLine();
                while (Name != null){
                    if(Name.equals(userName) && Pass.equals(passWord)) {
                        success = 2;
                    }
                    Name = in.readLine();
                    Pass = in.readLine();
                }
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
        return success;
    }

}