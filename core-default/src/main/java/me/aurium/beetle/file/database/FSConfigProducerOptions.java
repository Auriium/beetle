package me.aurium.beetle.file.database;

import me.aurium.beetle.file.ProducerOptions;

public class FSConfigProducerOptions implements ProducerOptions { //i wish i had records...

    private final String user;
    private final String password;
    private final String dbname;

    public FSConfigProducerOptions(String user, String password, String dbname) {
        this.user = user;
        this.password = password;
        this.dbname = dbname;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDbname() {
        return dbname;
    }


}
