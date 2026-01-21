package Week1;

public class Marathon {


    private int[] degrees;
    private String[] runners;

    public Marathon(int[] degress, String[] names) {
        this.degrees = degress;
        this.runners = names;
    }

    public int[] getDegrees() {
        return degrees;
    }

    public void setDegrees(int[] degrees) {
        this.degrees = degrees;
    }

    public String[] getRunners() {
        return runners;
    }

    public void setRunners(String[] runners) {
        this.runners = runners;
    }

    public void sortRunners() {
        for (int i = 0; i < degrees.length - 1; i++) {
            for (int j = 0; j < degrees.length - i - 1; j++) {
                if (degrees[j] > degrees[j + 1]) {
                    swapDegree(j);
                    swapRunner(j);
                }
            }
        }

    }

    public void swapDegree(int index) {
        int tempDegree;
        tempDegree = degrees[index];
        degrees[index] = degrees[index + 1];
        degrees[index + 1] = tempDegree;
    }

    public void swapRunner(int j) {
        String tempRunner;
        tempRunner = runners[j];
        runners[j] = runners[j + 1];
        runners[j + 1] = tempRunner;

    }

    public void firstRunner() {
        System.out.println("Birinci: " + runners[0] + " " + degrees[0]);
    }

    public void secondRunner() {
        System.out.println("İkinci: " + runners[1] + " " + degrees[1]);
    }

    public void thirdRunner() {
        System.out.println("Üçüncü: " + runners[2] + " " + degrees[2]);
    }

    public void rankRunner() {
        int A = 0;
        int B = 0;
        int C = 0;
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] < 300)
                ++A;
            else if (degrees[i] < 400)
                ++B;
            else
                ++C;
        }
        System.out.println("A-->" + A + "\nB-->" + B + "\nC-->" + C);
    }
}


