package me.aurium.beetle.core.datacore;

/**
 * If only java 11 supported records...
 */
public final class SourceConfig {

    private final String pluginName;
    private final String databaseName;
    private final String databaseUser;
    private final String databasePassword;
    private final String databaseHostLocation;
    private final int databasePort;


    public SourceConfig(String pluginName, String databaseName, String databaseUser, String databasePassword, String databaseHostLocation, int databasePort) {
        this.pluginName = pluginName;
        this.databaseName = databaseName;
        this.databaseUser = databaseUser;
        this.databasePassword = databasePassword;
        this.databasePort = databasePort;
        this.databaseHostLocation = databaseHostLocation;
    }

    public String getPluginName() {
        return pluginName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public int getDatabasePort() {
        return databasePort;
    }

    public String getDatabaseHostLocation() {
        return databaseHostLocation;
    }

    public final static class Builder {

        private String pluginName;
        private String databaseName;
        private String databaseUser;
        private String databasePassword;
        private String databaseHostLocation;
        private int databasePort;

        public Builder() {
            pluginName = "defaultPluginName";
            databaseName = "defaultDatabaseName";
            databaseUser = "defaultDatabaseUser";
            databasePassword = "defaultDatabasePassword";
            databaseHostLocation = "defaultMyAdmin.panel.com";
            databasePort = 3306;
        }

        public Builder setPluginName(String value) {
            this.pluginName = value;
            return this;
        }

        public Builder setDatabaseName(String value) {
            this.databaseName = value;
            return this;
        }

        public Builder setDatabaseUser(String value) {
            this.databaseUser = value;
            return this;
        }

        public Builder setPassword(String value) {
            this.databasePassword = value;
            return this;
        }

        public Builder setHostLocation(String value) {
            this.databaseHostLocation = value;
            return this;
        }

        public Builder setPort(int value) {
            this.databasePort = value;
            return this;
        }

        public SourceConfig build() {
            return new SourceConfig(pluginName,databaseName,databaseUser,databasePassword,databaseHostLocation,databasePort);
        }

    }

}
