package me.aurium.beetle.file.extension;

import me.aurium.beetle.datacore.LocalDBType;

public interface LocalDataExtension extends CustomExtension{

    LocalDBType getType();

}
