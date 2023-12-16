package Final_Project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TeacherWindow extends JFrame {
    private JPanel contentPane;
    private JButton btnManage;
    private JButton btnViewQuestions;
    private JButton btnSelectCategory;
    private JButton btnQuit;

    public TeacherWindow(QuestionCategories categoriesList, String path) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnManage = new JButton("Category Management");
        btnManage.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnManage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cateManage(categoriesList);
            }
        });
        btnManage.setBounds(94, 68, 271, 72);
        contentPane.add(btnManage);

        btnViewQuestions = new JButton("View Questions");
        btnViewQuestions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view(categoriesList);
            }
        });
        btnViewQuestions.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnViewQuestions.setBounds(94, 164, 271, 72);
        contentPane.add(btnViewQuestions);

        btnSelectCategory = new JButton("Select Category");
        btnSelectCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                select(categoriesList);
            }
        });
        btnSelectCategory.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnSelectCategory.setBounds(94, 263, 271, 72);
        contentPane.add(btnSelectCategory);

        btnQuit = new JButton("Save and Quit");
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save(path, categoriesList);
            }
        });
        btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnQuit.setBounds(94, 359, 271, 72);
        contentPane.add(btnQuit);
    }

    public void save(String path, QuestionCategories categoriesList){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            // 写入内容
            for(int a=0; a<categoriesList.Observer.size(); a++){
                QuestionList thisQuestionList = categoriesList.Observer.get(a);
                for(int i=0; i<thisQuestionList.Questions.size(); i++){
                    Question thisQuestion = thisQuestionList.Questions.get(i);
                    String title = thisQuestion.getTopic();
                    String name = thisQuestion.getName();
                    String category = thisQuestion.getCategory();
                    String content = thisQuestion.getContent();
                    writer.write(title);
                    writer.newLine();
                    writer.write(name);
                    writer.newLine();
                    writer.write(category);
                    writer.newLine();
                    writer.write(content);
                    writer.newLine();
                }
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
        System.exit(0);
    }

    public void cateManage(QuestionCategories categoriesList){
        CateManageWindow cateManage = new CateManageWindow(categoriesList);
        cateManage.setVisible(true);
    }

    public void view(QuestionCategories categoriesList){
        TeacherViewWindow viewWindow = new TeacherViewWindow(categoriesList);
        viewWindow.setVisible(true);
    }

    public void select(QuestionCategories categoriesList){
        SelectQuestion selectWindow = new SelectQuestion(categoriesList);
        selectWindow.setVisible(true);
    }
}

