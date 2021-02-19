package me.aurium.beetle.core.datacore;

public class SQLiteCoreSourceFactory implements CoreSourceFactory {

    private final SourceConfig config;

    public SQLiteCoreSourceFactory(SourceConfig config) {
        this.config = config;
    }

    @Override
    public CoreSource getCoreSource() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("SQLite Driver is missing from the plugin that a CoreSource as built on!");
        }

        String address = String.format("jdbc:sqlite://%s:%d/%s",
                config.getDatabaseHostLocation(),
                config.getDatabasePort(),
                config.getDatabaseName());

        String username = config.getDatabaseUser();
        String password = config.getDatabasePassword();

        return new AddressCoreSource(address,username,password);
    }
}
