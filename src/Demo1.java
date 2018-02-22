public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {

//        new Test();
        for (int i = 0; i < 3; i++) {

            Class.forName("Test3");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        Test.id=12;
    }
}