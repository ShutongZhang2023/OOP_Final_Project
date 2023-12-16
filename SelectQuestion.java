package Final_Project;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.util.Random;
import java.awt.Dimension;

public class SelectQuestion extends JFrame {
    private JPanel contentPane;
    private JTextField titleField;
    private JTextField nameField;
    private JTextField cateField;
    private JTextArea textArea;
    private JTextField txtAlert;

    public SelectQuestion(QuestionCategories categoriesList) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        setContentPane(contentPane);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(0,1));
        for (int i=0; i< categoriesList.Categories.size(); i++) {
            final int index = i;
            JButton btnCate = new JButton(categoriesList.Categories.get(i));
            btnCate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    select(categoriesList, index);
                }
            });
            btnCate.setFont(new Font("Tahoma", Font.PLAIN, 15));
            btnPanel.add(btnCate);
        }
        contentPane.add(btnPanel);

        txtAlert = new JTextField();
        txtAlert.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtAlert.setColumns(35);
        txtAlert.setPreferredSize(new Dimension(txtAlert.getPreferredSize().width, 10));
        contentPane.add(txtAlert);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel row1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1Panel.add(new JLabel("Title:"));
        titleField = new JTextField(43);
        row1Panel.add(titleField);
        mainPanel.add(row1Panel);

        JPanel row2Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row2Panel.add(new JLabel("Poster:"));
        nameField = new JTextField(42);
        row2Panel.add(nameField);
        mainPanel.add(row2Panel);

        JPanel row3Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row3Panel.add(new JLabel("Category:"));
        cateField = new JTextField(40);
        row3Panel.add(cateField);
        mainPanel.add(row3Panel);


        textArea = new JTextArea(10, 0);
        textArea.setLineWrap(true); // 自动换行
        textArea.setWrapStyleWord(true); // 按单词换行
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane);

        contentPane.add(mainPanel);

        JButton btnQuit = new JButton("Quit");
        btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnQuit);


    }

    public void select(QuestionCategories categoriesList, int index){
        txtAlert.setText("");
        QuestionList thisList = categoriesList.Observer.get(index);
        Random generate = new Random();
        if(thisList.Printed.size() == 0){
            txtAlert.setText("There is no more question in this category");
        } else {
            int chooseIndex = generate.nextInt(thisList.Printed.size());
            int realIndex = thisList.Printed.get(chooseIndex);
            Question thisQuestion = thisList.Questions.get(realIndex);
            //set
            titleField.setText(thisQuestion.getTopic());
            nameField.setText(thisQuestion.getName());
            cateField.setText(thisQuestion.getCategory());
            textArea.setText(thisQuestion.getContent());
            thisList.Printed.remove(chooseIndex);
        }
    }


}

