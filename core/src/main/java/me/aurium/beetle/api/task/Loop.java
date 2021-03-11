package me.aurium.beetle.api.task;

public interface Loop {

    void register(Loopable loopable);
    void unregister(Loopable loopable);

    void start();
    void stop();

}
