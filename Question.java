package Final_Project;

public class Question {
    private String Topic;
    private String Name;
    private String Content;
    private String Category;

    public Question(String topic, String name, String content) {
        this.Topic = topic;
        this.Name = name;
        this.Content = content;
        this.Category = "NONE";
    }

    public Question(String topic, String name, String category, String content) {
        this.Topic = topic;
        this.Name = name;
        this.Content = content;
        this.Category = category;
    }

    public String getTopic() {
        return Topic;
    }


    public String getName() {
        return Name;
    }


    public String getContent() {
        return Content;
    }


    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

}
