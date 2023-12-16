package Final_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CateManageWindow extends JFrame {
    private JPanel contentPane;
    private JTextField txtDelete;
    private JTextField txtAdd;
    private JTextField txtAlert;
    private JTextArea textArea;
    private JButton btnQuit;
    private JButton btnDelete;
    private JButton btnAdd;

    /**
     * Create the frame.
     */
    public CateManageWindow(QuestionCategories categoriesList) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 510);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textArea.setBounds(10, 10, 468, 189);
        textArea.append("These are the categories that already exist:\n");
        for(int i=1; i< categoriesList.Categories.size(); i++){
            textArea.append("["+i + "] " + categoriesList.Categories.get(i)+"\n");
        }


        contentPane.add(textArea);

        JLabel lblDelete = new JLabel("Please enter the index of the category you want to delete:");
        lblDelete.setHorizontalAlignment(SwingConstants.LEFT);
        lblDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblDelete.setBounds(10, 209, 458, 24);
        contentPane.add(lblDelete);

        txtDelete = new JTextField();
        txtDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtDelete.setBounds(10, 243, 468, 24);
        contentPane.add(txtDelete);
        txtDelete.setColumns(10);

        JLabel lblAdd = new JLabel("Please enter the name of the category you want to add:");
        lblAdd.setHorizontalAlignment(SwingConstants.LEFT);
        lblAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblAdd.setBounds(10, 313, 458, 24);
        contentPane.add(lblAdd);

        txtAdd = new JTextField();
        txtAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtAdd.setColumns(10);
        txtAdd.setBounds(10, 346, 468, 24);
        contentPane.add(txtAdd);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete(categoriesList);
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDelete.setBounds(10, 277, 468, 26);
        contentPane.add(btnDelete);

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add(categoriesList);
            }
        });
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAdd.setBounds(10, 380, 468, 26);
        contentPane.add(btnAdd);

        txtAlert = new JTextField();
        txtAlert.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtAlert.setColumns(10);
        txtAlert.setBounds(10, 416, 468, 24);
        contentPane.add(txtAlert);

        btnQuit = new JButton("Quit");
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnQuit.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnQuit.setBounds(10, 445, 468, 26);
        contentPane.add(btnQuit);

    }

    public void delete(QuestionCategories categoriesList){
        int delete = Integer.parseInt(txtDelete.getText());
        if(delete <= 0 || delete >= categoriesList.Categories.size()){
            txtAlert.setText("There is not this category");
        } else {
            categoriesList.deleteCate(delete);
            textArea.setText("");
            textArea.append("These are the categories that already exist:\n");
            for(int i=1; i< categoriesList.Categories.size(); i++){
                textArea.append("["+i + "] " + categoriesList.Categories.get(i)+"\n");
            }
        }
    }

    public void add(QuestionCategories categoriesList){
        String cate = txtAdd.getText();
        if(cate.isEmpty()){
            txtAlert.setText("Your input is empty");
        } else {
            int same = categoriesList.checkCategory(cate);
            if(same != -1){
                txtAlert.setText("Category already exist");
            } else {
                categoriesList.addCategory(cate);
                txtAlert.setText("Success");
                textArea.setText("");
                textArea.append("These are the categories that already exist:\n");
                for(int i=1; i< categoriesList.Categories.size(); i++){
                    textArea.append("["+i + "] " + categoriesList.Categories.get(i)+"\n");
                }
            }

        }
    }
}

