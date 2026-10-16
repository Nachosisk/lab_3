class ChickenVsEgg {

    static class Speaker implements Runnable {
        private final String word;

        public Speaker(String word) {
            this.word = word;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(word);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread chicken = new Thread(new Speaker("Курица"), "Курица");
        Thread egg = new Thread(new Speaker("Яйцо"), "Яйцо");

        chicken.start();
        egg.start();

        try {
            chicken.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Спор окончен.");

        if (!chicken.isAlive() && !egg.isAlive()) {
            if (chicken.getId() > egg.getId()) {
                System.out.println("Победила Курица");
            } else {
                System.out.println("Победило Яйцо");
            }
        }
    }
}