package me.aurium.beetle.core.datacore;

import javax.sql.DataSource;

/**
 * Helper factory that produces CoreSources
 */
public interface CoreSourceFactory {

    CoreSource getCoreSource();

}
