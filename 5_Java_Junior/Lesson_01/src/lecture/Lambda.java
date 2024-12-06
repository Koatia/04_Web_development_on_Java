package lecture;

public class Lambda {
    public static void main(String[] args) {
        //        PlainInterface plainInterface = new PlainInterface() {
        //            @Override
        //            public int action(int x, int y) {
        //                return (x + y);
        //            }
        //        };
        //        PlainInterface plainInterface = (x, y) -> (x + y);
        //        PlainInterface plainInterface1 = (x, y) -> (Integer.compare(x, y));

        PlainInterface plainInterface = Integer::sum;
        PlainInterface plainInterface1 = Integer::compare;


        System.out.println(plainInterface.action(3, 5));
        System.out.println(plainInterface1.action(3, 5));
    }

}