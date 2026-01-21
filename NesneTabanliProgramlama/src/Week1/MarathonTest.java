package Week1;

public class MarathonTest {

    public static void main(String[] args) {
        String[] runners = {"Kadir", "Gökhan", "Hakan", "Suzan",
                "Pınar", "Mehmet", "Ali", "Emel", "Fırat", "James",
                "Jale", "Ersin", "Deniz", "Gözde", "Anıl", "Burak"};
        int[] degrees = {341, 273, 278, 329, 445, 402, 388, 270, 243, 334,
                412, 393, 299, 343, 317, 265};

        Marathon marathon = new Marathon(degrees, runners);
        marathon.sortRunners();
        marathon.firstRunner();
        marathon.secondRunner();
        marathon.thirdRunner();
        marathon.rankRunner();
    }
}


