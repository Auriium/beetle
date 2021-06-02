package xyz.auriium.beetle.task.model;

import java.util.concurrent.Future;

public interface AccessiblePromise<T> extends StageablePromise<T>, Future<T> {

    T join();

}
