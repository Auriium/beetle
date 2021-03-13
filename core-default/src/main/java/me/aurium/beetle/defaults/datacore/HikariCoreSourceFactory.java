package me.aurium.beetle.defaults.datacore;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.datacore.CoreSourceFactory;

import javax.sql.DataSource;

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

        hikari.setJdbcUrl(String.format(useSSL ? "jdbc:%s://%s:%d/%s" : "jdbc:%s://%s:%d/%s?useSSL=false",
                config.getDatabaseDialect(),
                config.getDatabaseHostLocation(),
                config.getDatabasePort(),
                config.getDatabaseName()));
        hikari.setUsername(config.getDatabaseUser());
        hikari.setPassword(config.getDatabasePassword());
        hikari.setPoolName(config.getPluginName() + "-datakore-hikari");

        return new DatasourceCoreSource(new HikariDataSource(hikari));
    }

}
