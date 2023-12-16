package Final_Project;

import java.io.*;
/**Due to the program involving file reading and writing, user need to modify the path
and passwordPath in the mainProgram according to the location of their file. Please
set them to the paths of the files question.txt and Password.txt.**/

/**
 The question.txt and Password.txt should be already in
 this package, just ensure the path is correct.

 To login as teacher, you can only use:
 Username: teacher1
 Password: teacher001

 To login as student, you can use:
 Username: student1
 Password: student001
 There are more options in the Password.txt
 **/

public class mainProgram {
    public static void main(String[] args) {
        String path = "idea_test_module/OOP/src/Final_Project/questions.txt";
        String passwordPath = "idea_test_module/OOP/src/Final_Project/Password.txt";
        LoginWindow loginWindow = new LoginWindow(passwordPath, path);
        loginWindow.setVisible(true);

    }
}
