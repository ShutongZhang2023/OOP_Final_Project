package Final_Project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TeacherViewWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panel;

    public TeacherViewWindow(QuestionCategories categoriesList) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        for (int i=0; i< categoriesList.Categories.size(); i++) {
            final int listIndex = i;
            QuestionList questionList = categoriesList.Observer.get(listIndex);
            for(int a =0; a < questionList.Questions.size(); a++) {
                final int questionIndex = a;
                Question question = questionList.Questions.get(questionIndex);
                JPanel block = createQuestionBlock(question, categoriesList, listIndex);
                panel.add(block);
            }
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    private JPanel createQuestionBlock(Question question,QuestionCategories categoriesList, int listIndex) {

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
        JButton btnChangeCate = new JButton("Change Category");
        btnChangeCate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangeCate changecate = new ChangeCate(question, categoriesList, listIndex);
                changecate.setVisible(true);
                dispose();
            }
        });
        row3Panel.add(btnChangeCate);
        mainPanel.add(row3Panel);

        JTextArea textArea = new JTextArea(0, 0);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(question.getContent());
        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane);

        block.add(mainPanel);
        return block;
    }

}

