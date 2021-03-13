package me.aurium.beetle.defaults.datacore;

import me.aurium.beetle.api.datacore.Transact;
import me.aurium.beetle.api.util.NotImplementedException;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;

public class SQLTransact implements Transact {

    private final Connection connection;

    public SQLTransact(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public <T> T getProperty(Class<T> tClass) {
        if (tClass.equals(DSLContext.class)) {
            return (T) DSL.using(connection);
        } else if (tClass.equals(Connection.class)) {
            return (T) connection;
        } else {
            throw new NotImplementedException("This property is not implemented by SQLTransact!");
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
