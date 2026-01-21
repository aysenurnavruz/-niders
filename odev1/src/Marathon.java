public class Marathon {
    private String[] runners;
    private int[] degrees;

    public Marathon(int[] degrees, String[] runners) {
        this.degrees = degrees;
        this.runners = runners;
    }

    public String[] getRunners() {
        return runners;
    }

    public void setRunners(String[] runners) {
        this.runners = runners;
    }

    public int[] getDegrees() {
        return degrees;
    }

    public void setDegrees(int[] degrees) {
        this.degrees = degrees;
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


    private void swapRunner(int j){
        String tempRunner;
        tempRunner = runners[j];
        runners[j] = runners[j + 1];
        runners[j + 1] = tempRunner;
    }

    private void swapDegree(int index){
        int tempDegree;
        tempDegree = degrees[index];
        degrees[index] = degrees[index + 1];
        degrees[index + 1] = tempDegree;

    }

    public void firstRunner(){
        System.out.println("Birinci: "+ runners[0] +" "+ degrees[0] );

    }

    public void secondRunner(){
        System.out.println("İkinci: "+ runners[1]+ " "+ degrees[1]);

    }

    public void thirdRunner(){
        System.out.println("Üçüncü: " + runners[2]+ " "+ degrees[2]);
    }

    public void rankRunners(){
        int A = 0;
        int B = 0;
        int C = 0;

        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i]<300){
                ++A;
            } else if (degrees[i]<400) {
                ++B;

            }
            else {
                ++C;
            }
        }
        System.out.println("A -> " +A);
        System.out.println("B -> " +B);
        System.out.println("C -> " +C);
    }



}

