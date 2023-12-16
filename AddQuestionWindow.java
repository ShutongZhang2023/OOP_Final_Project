package Final_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddQuestionWindow extends JFrame {
    private JPanel contentPane;
    private JTextField txtTitle;
    private JTextField txtName;
    private JTextField txtAlert;
    private JButton btnPost;
    private JButton btnReset;
    private JButton btnCancle;
    private JTextArea textArea;


    public AddQuestionWindow(QuestionCategories categoriesList) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTitle.setBounds(30, 41, 49, 21);
        contentPane.add(lblTitle);

        txtTitle = new JTextField();
        txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTitle.setBounds(77, 41, 387, 22);
        contentPane.add(txtTitle);
        txtTitle.setColumns(10);

        JLabel lblPoser = new JLabel("Name:");
        lblPoser.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPoser.setBounds(30, 72, 60, 21);
        contentPane.add(lblPoser);

        txtName = new JTextField();
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtName.setColumns(10);
        txtName.setBounds(87, 73, 377, 22);
        contentPane.add(txtName);

        JLabel lblQuestion = new JLabel("Your Question:");
        lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblQuestion.setBounds(30, 103, 126, 21);
        contentPane.add(lblQuestion);

        textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(30, 134, 434, 268);
        contentPane.add(scrollPane);

        btnPost = new JButton("Post");
        btnPost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = txtTitle.getText();
                String name = txtName.getText();
                String content = textArea.getText();
                QuestionList noneList = categoriesList.Observer.get(0);
                int flag = post(title, name, content, noneList);
                if(flag == 1){
                    txtTitle.setText("");
                    txtName.setText("");
                    textArea.setText("");
                }
            }
        });
        btnPost.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnPost.setBounds(30, 412, 126, 21);
        contentPane.add(btnPost);

        btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtTitle.setText("");
                txtName.setText("");
                textArea.setText("");
            }
        });
        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnReset.setBounds(184, 414, 126, 21);
        contentPane.add(btnReset);

        btnCancle = new JButton("Cancel");
        btnCancle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancle.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCancle.setBounds(338, 412, 126, 21);
        contentPane.add(btnCancle);

        txtAlert = new JTextField();
        txtAlert.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtAlert.setBounds(30, 441, 434, 22);
        contentPane.add(txtAlert);
        txtAlert.setColumns(10);
    }

    public int post(String title, String name, String content, QuestionList thisList) {
        int returnValue = 0;
        if(title.isEmpty()){
            txtAlert.setText("Your title is empty, please enter again");
            return returnValue;
        }
        if(name.isEmpty()){
            txtAlert.setText("Your name is empty, please enter again");
            return returnValue;
        }
        if(content.isEmpty()){
            txtAlert.setText("Your content is empty, please enter again");
            return returnValue;
        }
        Question newQuestion = new Question(title, name, content);
        thisList.addQuestion(newQuestion);
        txtAlert.setText("Success!");
        returnValue = 1;
        return returnValue;

    }
}
