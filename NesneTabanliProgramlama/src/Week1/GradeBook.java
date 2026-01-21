package Week1;

public class GradeBook {

    private int[] grades;

    private String courseName;

    public GradeBook(int[] gradesArray, String courseName) {
        this.grades = gradesArray;
        this.courseName = courseName;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void displayMessage() {
        System.out.println("Welcome to the grade for: " + getCourseName());

    }

    public void outputGrades() {
        System.out.println("The grades are:");
        for (int i = 0; i < grades.length; i++) {
            System.out.printf("Student%d : %d%n", (i + 1), grades[i]);
        }
    }

    public double getAverage() {
        int toplam = 0;
        for (int grade : grades) {
            toplam += grade;
        }
        return (double) toplam / grades.length;
    }

    public int getMaximum() {
        int max = grades[0];
        for (int i = 0; i < grades.length; i++) {
            if (max < grades[i])
                max = grades[i];
        }
        return max;
    }

    public int getMinimum() {
        int min = grades[0];
        for (int i = 0; i < grades.length; i++) {
            if (min > grades[i])
                min = grades[i];
        }
        return min;
    }

    public void outputBarChart() {
        int[] frequency = new int[11];

        System.out.println("Grade Distribution : ");

        for (int grade : grades) {
            ++frequency[grade / 10];

        }
        for (int count = 0; count < frequency.length; count++) {
            if (count == 10) {
                System.out.printf("%5d: ", 100);
            } else
                System.out.printf("%02d-%02d:", count * 10, count * 10 + 9);
            for (int stars = 0; stars < frequency[count]; stars++)
                System.out.print("*");
            System.out.println();

        }

    }

    public void processGrades() {
        outputGrades();

        System.out.println("Class average is: " + getAverage());
        System.out.printf("Lowest grade is %d Highest grade is %d%n", getMinimum(), getMaximum());
        outputBarChart();
    }


}


