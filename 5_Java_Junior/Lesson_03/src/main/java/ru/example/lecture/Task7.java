package ru.example.lecture;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Task7 {

    /**
     * Java NIO (Non-blocking IO) построен на каналах (channels) и, в отличие от потоков, каналы являются двусторонними.
     * Они позволяют одновременно выполнять чтение и запись в файл, устраняя ограничения потоков. В представленном
     * примере мы создаем объект "файл" в режиме чтения/записи и получаем доступ к каналу с помощью метода getChannel.
     * После этого мы используем метод read для чтения данных в заранее подготовленный буфер. Заметим, что Java
     * автоматически следит за тем, чтобы количество данных, прочитанных из файла, не превышало размер буфера. Далее в
     * цикле мы проверяем, был ли файл дочитан до конца, и выводим его содержимое в консоль. Это возможно благодаря
     * буферу. ByteBuffer, который является наследником класса Buffer, предназначен для побайтного чтения и удобной
     * манипуляции данными, прочитанными из файла.
     */
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("file.txt", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(100);
            int bytesRead = channel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = channel.read(buf);
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}