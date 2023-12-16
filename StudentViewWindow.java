package Final_Project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class StudentViewWindow extends JFrame {
    private JPanel panel;
    //private JScrollPane scrollPane;

    public StudentViewWindow(QuestionCategories categoriesList) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        for (QuestionList questionList : categoriesList.Observer) {
            for(Question question: questionList.Questions) {
                JPanel block = createQuestionBlock(question);
                panel.add(block);
            }
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane);



    }

    private JPanel createQuestionBlock(Question question) {

        JPanel block = new JPanel();
        block.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        block.setLayout(new BoxLayout(block, BoxLayout.Y_AXIS));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel row1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1Panel.add(new JLabel("Title:"));
        JTextField titleField = new JTextField(0);
        titleField.setText(question.getTopic());
        row1Panel.add(titleField);
        mainPanel.add(row1Panel);

        JPanel row2Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row2Panel.add(new JLabel("Poster:"));
        JTextField nameField = new JTextField(0);
        nameField.setText(question.getName());
        row2Panel.add(nameField);
        mainPanel.add(row2Panel);

        JPanel row3Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row3Panel.add(new JLabel("Category:"));
        JTextField cateField = new JTextField(0);
        cateField.setText(question.getCategory());
        row3Panel.add(cateField);
        mainPanel.add(row3Panel);

        JTextArea textArea = new JTextArea(0, 0);
        textArea.setLineWrap(true); // 自动换行
        textArea.setWrapStyleWord(true); // 按单词换行
        textArea.setText(question.getContent());
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane);

        block.add(mainPanel);
        return block;
    }

}

