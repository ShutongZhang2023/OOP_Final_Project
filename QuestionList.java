package Final_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionList {
    public ArrayList<Question> Questions;
    public ArrayList<Integer> Printed;

    public QuestionList() {
        this.Questions = new ArrayList<Question>();
        this.Printed = new ArrayList<Integer>();
    }

    public void addQuestion(String title, String name, String category, String content){
        Question newQuestion = new Question(title, name, category, content);
        this.Printed.add(this.Printed.size());
        this.Questions.add(newQuestion);
    }

    public void addQuestion(Question thisQuestion){
        this.Printed.add(this.Printed.size());
        this.Questions.add(thisQuestion);
    }

    public void removeQuestion(Question thisQuestion){
        this.Printed.remove(this.Printed.size()-1);
        this.Questions.remove(thisQuestion);
    }

}
