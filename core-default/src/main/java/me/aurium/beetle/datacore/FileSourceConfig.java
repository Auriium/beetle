package me.aurium.beetle.datacore;

import java.io.File;

public final class FileSourceConfig {

    private final File file;
    private final String username;
    private final String password;

    public FileSourceConfig(File file, String username, String password) {
        this.file = file;
        this.username = username;
        this.password = password;
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

    public final static class Builder {

        private final File file;
        private String username;
        private String password;

        public Builder(File file) {
            this.file = file;
            this.username = "username";
            this.password = "password";
        }

        public Builder password(String password) {
            this.password = password;

            return this;
        }

        public Builder username(String username) {
            this.username = username;

            return this;
        }

        public FileSourceConfig build() {
            return new FileSourceConfig(file,username,password);
        }
    }

}
