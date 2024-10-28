package thread;

public class Example6 {
    public static void main(String[] args) {
        Thread tic = new Thread(new TicTac2("["));
        Thread tac = new Thread(new TicTac2("]"));
        //        tic.setDaemon(true);
        //        tac.setDaemon(true);
        tic.start();
        tac.start();
    }
}