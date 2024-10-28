package thread;

public class Example2 {
    public static void main(String[] args) {
        Thread tic = new Thread(new TicTac("["));
        Thread tac = new Thread(new TicTac("]"));
        //        tic.setDaemon(true);
        //        tac.setDaemon(true);
        tic.start();
        tac.start();
    }
}