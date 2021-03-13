package me.aurium.beetle.defaults.datacore;

import java.io.File;

public final class FileSourceConfig {

    private final File file;
    private final String username;
    private final String password;
    private final int timeout;

    public FileSourceConfig(File file, String username, String password, int timeout) {
        this.file = file;
        this.username = username;
        this.password = password;
        this.timeout = timeout;
    }

    public File getFile() {
        return file;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getTimeout() {
        return timeout;
    }

    public final static class Builder {

        private final File file;
        private String username;
        private String password;
        private int timeout;

        public Builder(File file) {
            this.file = file;
            this.username = "username";
            this.password = "password";
            this.timeout = 60;
        }

        public Builder password(String password) {
            this.password = password;

            return this;
        }

        public Builder username(String username) {
            this.username = username;

            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;

            return this;
        }

        public FileSourceConfig build() {
            return new FileSourceConfig(file,username,password,timeout);
        }
    }

}
