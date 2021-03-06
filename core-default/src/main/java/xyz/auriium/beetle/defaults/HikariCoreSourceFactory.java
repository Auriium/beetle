package xyz.auriium.beetle.defaults;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import xyz.auriium.beetle.datacore.CoreSource;
import xyz.auriium.beetle.datacore.CoreSourceFactory;
import xyz.auriium.beetle.datacore.impl.DatasourceCoreSource;
import xyz.auriium.beetle.datacore.impl.WebSourceConfig;

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
