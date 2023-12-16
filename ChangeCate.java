package Final_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeCate extends JFrame {

    private JPanel contentPane;
    private JTextField txtChange;
    private JTextField txtAlert;
    private JButton btnSave;
    private JButton btnQuit;

    public ChangeCate(Question question, QuestionCategories categoriesList, int listIndex) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 410);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea infoArea = new JTextArea();
        infoArea.setBounds(10, 10, 416, 210);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.append("These are the categories you can change to:\n");
        for(int i=0; i< categoriesList.Categories.size(); i++){
            infoArea.append("["+i + "] " + categoriesList.Categories.get(i)+"\n");
        }
        contentPane.add(infoArea);

        JLabel lblNewLabel = new JLabel("Please enter the index of the category you want to change to");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(10, 232, 416, 29);
        contentPane.add(lblNewLabel);

        txtChange = new JTextField();
        txtChange.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtChange.setBounds(10, 260, 416, 29);
        contentPane.add(txtChange);
        txtChange.setColumns(10);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                change(question, categoriesList, listIndex);
            }
        });
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSave.setBounds(10, 299, 196, 29);
        contentPane.add(btnSave);

        btnQuit = new JButton("Quit");
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnQuit.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnQuit.setBounds(230, 299, 196, 29);
        contentPane.add(btnQuit);

        txtAlert = new JTextField();
        txtAlert.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtAlert.setColumns(10);
        txtAlert.setBounds(10, 338, 416, 29);
        contentPane.add(txtAlert);
    }

    public void change(Question question, QuestionCategories categoriesList, int listIndex){
        try {
            int changeTo = Integer.parseInt(txtChange.getText());
            if(changeTo < 0 || changeTo >= categoriesList.Categories.size()){
                txtAlert.setText("Invalid input. Out of range.");
            } else {
                question.setCategory(categoriesList.Categories.get(changeTo));
                QuestionList addToList = categoriesList.Observer.get(changeTo);
                addToList.addQuestion(question);
                QuestionList deleteList = categoriesList.Observer.get(listIndex);
                deleteList.removeQuestion(question);
                dispose();
            }
        } catch (NumberFormatException error) {
            txtAlert.setText("Invalid input. Please input an index.");
        }
    }
}

