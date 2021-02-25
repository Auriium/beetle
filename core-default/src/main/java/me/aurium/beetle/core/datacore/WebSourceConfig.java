package me.aurium.beetle.core.datacore;

/**
 * If only java 11 supported records...
 */
public final class WebSourceConfig {

    private final String pluginName;
    private final String databaseName;
    private final String databaseUser;
    private final String databasePassword;
    private final String databaseHostLocation;
    private final String databaseDialect;
    private final int databasePort;


    public WebSourceConfig(String pluginName, String databaseName, String databaseUser, String databasePassword, String databaseHostLocation, String databaseDialect, int databasePort) {
        this.pluginName = pluginName;
        this.databaseName = databaseName;
        this.databaseUser = databaseUser;
        this.databasePassword = databasePassword;
        this.databasePort = databasePort;
        this.databaseDialect = databaseDialect;
        this.databaseHostLocation = databaseHostLocation;
    }

    public String getDatabaseDialect() {
        return this.databaseDialect;
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
        private String databaseDialect;
        private int databasePort;

        public Builder() {
            pluginName = "defaultPluginName";
            databaseName = "defaultDatabaseName";
            databaseUser = "defaultDatabaseUser";
            databasePassword = "defaultDatabasePassword";
            databaseHostLocation = "defaultMyAdmin.panel.com";
            databasePort = 3306;
            this.databaseDialect = "mysql";
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

        public Builder setDialect(String dialect) {
            this.databaseDialect = dialect;
            return this;
        }

        public WebSourceConfig build() {
            return new WebSourceConfig(pluginName,databaseName,databaseUser,databasePassword,databaseHostLocation,databaseDialect,databasePort);
        }

    }

}
