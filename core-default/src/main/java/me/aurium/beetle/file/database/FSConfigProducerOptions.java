package me.aurium.beetle.file.database;

import me.aurium.beetle.file.ProducerOptions;

public class FSConfigProducerOptions implements ProducerOptions { //i wish i had records...

    private final String user;
    private final String password;

    public FSConfigProducerOptions(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }





}
