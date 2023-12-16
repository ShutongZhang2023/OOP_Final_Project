package Final_Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionCategories {
    public ArrayList<String> Categories;
    public ArrayList<QuestionList> Observer;


    public QuestionCategories(){
        this.Categories = new ArrayList<String>();
        this.Categories.add("NONE");
        this.Observer = new ArrayList<QuestionList>();
        QuestionList NoneCategory = new QuestionList();
        this.Observer.add(NoneCategory);
    }

    public void addCategory (String category){
        this.Categories.add(category);
        QuestionList ThisCategory = new QuestionList();
        this.Observer.add(ThisCategory);
    }

    public int checkCategory (String category){
        for(int i=0; i < this.Categories.size(); i++){
            if(this.Categories.get(i).equals(category)){
                return i;
            }
        }
        return -1;
    }

    public void deleteCate(int deleteIndex){
        QuestionList deleteList = this.Observer.get(deleteIndex);
        QuestionList noneList = this.Observer.get(0);
        for(int i=0; i<deleteList.Questions.size(); i++){
            Question thisQuestion = deleteList.Questions.get(i);
            thisQuestion.setCategory("NONE");
            noneList.addQuestion(thisQuestion);
        }
        this.Observer.remove(deleteIndex);
        this.Categories.remove(deleteIndex);
    }

     public void readFile(String filePath){
         try {
             BufferedReader in = new BufferedReader(new FileReader(filePath));
             String str = in.readLine();
             while (str != null) {
                 String title = str;
                 String name = in.readLine();
                 String category = in.readLine();
                 String content = in.readLine();
                 int existCate = this.checkCategory(category);
                 if(existCate == -1){
                     this.addCategory(category);
                     existCate = this.Categories.size()-1;
                 }
                 QuestionList thatQuestionList = this.Observer.get(existCate);
                 thatQuestionList.addQuestion(title, name, category, content);
                 str = in.readLine();
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

}
