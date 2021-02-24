package me.aurium.beetle.core.datacore;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//TODO: make this not mysql specific: e.g. mariadb, postgretard
public class HikariCoreSourceFactory implements CoreSourceFactory {

    private final WebSourceConfig config;
    private final boolean useSSL;

    public HikariCoreSourceFactory(WebSourceConfig config, boolean useSSL) {
        this.config = config;
        this.useSSL = useSSL;
    }

    @Override
    public CoreSource getCoreSource() {
        HikariConfig hikari = new HikariConfig();

        hikari.setJdbcUrl(String.format(useSSL ? "jdbc:mysql://%s:%d/%s" : "jdbc:mysql://%s:%d/%s?useSSL=false",
                config.getDatabaseHostLocation(),
                config.getDatabasePort(),
                config.getDatabaseName()));
        hikari.setUsername(config.getDatabaseUser());
        hikari.setPassword(config.getDatabasePassword());
        hikari.setPoolName(config.getPluginName() + "-datakore-hikari");

        return new DatasourceCoreSource(new HikariDataSource(hikari));
    }

}
