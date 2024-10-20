package ru.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Java-класс, который будет использовать API Jetty для запуска сервера.
 * Этот код создаёт Jetty-сервер, который будет слушать на порту 8080 и обрабатывать запросы на /hello
 */
public class JettyStart {

    public static void main(String[] args) throws Exception {
        // Создаем сервер на порту 8080
        Server server = new Server(8080);

        // Создаем контекст для сервлетов
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Добавляем сервлет
        context.addServlet(new ServletHolder(new HelloServlet()), "/hello");

        // Запускаем сервер
        server.start();
        server.join();
    }
}
