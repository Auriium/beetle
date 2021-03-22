package me.aurium.beetle.api.task;

import me.aurium.beetle.api.task.sync.MainThreadDetection;

import java.util.concurrent.CompletableFuture;

public abstract class TaskFuture<T> extends CompletableFuture<T> {
}
