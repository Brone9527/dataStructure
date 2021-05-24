package set;

import java.util.ArrayList;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/5/15 13:07
 */
 
public class Main {
    public static void main(String[] args) {
        System.out.println( "Pride and Prejudice");

        ArrayList<String> words1= new ArrayList<>();

        if (FileOperation.readFile("C:\\Users\\Nicholas\\IdeaProjects\\dataStructure\\src\\main\\java\\set\\pride-and-prejudice.txt", words1)){
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word:words1) {
                set1.add(word);

            }
            System.out.println("Total different words: " + set1.getSize());
        }
        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("C:\\Users\\Nicholas\\IdeaProjects\\dataStructure\\src\\main\\java\\set\\a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word:words2) {
                set2.add(word);
            }
            System.out.println("Total diferent words: " + set2.getSize());
        }
    }
}
