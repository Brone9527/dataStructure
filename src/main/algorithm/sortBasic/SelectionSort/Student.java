package sortBasic.SelectionSort;

/**
 * @Author zeroback13
 * @Date 2022/1/24 21:24
 * @Version 1.0
 */
public class Student implements Comparable<Student>{

    private int score;
    private String name;

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }


    @Override
    public int compareTo(Student that) {
        if(this.score < that.score)
            return  -1;
        else if(this.score > that.score)
            return 1;
        else
            return this.name.compareTo(that.name);
    }

    @Override
    public String toString() {
        return "Student: " + this.name + " " + Integer.toString(this.score);
    }
}
