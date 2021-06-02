package xyz.auriium.beetle.task.model;

import java.util.concurrent.CompletionStage;

public interface ConvertiblePromise<T> {

    CompletionStage<T> convert();

}
