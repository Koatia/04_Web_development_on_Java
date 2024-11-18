package jdk_server.repository;

public interface InterfaceRepository<T> {

    void save(T text);

    T read();
}