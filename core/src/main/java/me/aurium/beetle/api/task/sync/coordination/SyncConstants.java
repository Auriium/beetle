package me.aurium.beetle.api.task.sync.coordination;

import java.util.concurrent.CompletableFuture;

public class SyncConstants {

    private static final Object EMPTY = new Object();

    public static <T> T CONSTANT() {
        return (T) EMPTY;
    }

    public void cringe(CompletableFuture<Integer> future) {

        future.thenRun(() -> {
            //lol
        }).thenRun(() -> {
            //AAAAAA
        }).thenRun(() -> {

        }); //example of how taskfutures can be used to run shit

        future.thenCompose(integer -> {
            System.out.println("cringe!!!");

            return getUserInfo(integer);
        }).thenCompose(string -> {
            System.out.println("Info is: " + string);

            return getUserRating(string);
        }).whenComplete((hope,failure) -> {
            if (failure != null) {
                //log
            }

            //do something
        });
    };

    public CompletableFuture<String> getUserInfo(int id) {
        return null;//example
    }

    public CompletableFuture<Integer> getUserRating(String info) {
        return null; //example
    }



}
