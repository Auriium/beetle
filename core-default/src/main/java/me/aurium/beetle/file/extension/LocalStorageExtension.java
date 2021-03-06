package me.aurium.beetle.file.extension;

import me.aurium.beetle.datacore.LocalDBType;

public interface LocalStorageExtension extends Extension {

    LocalDBType getCorrespondingCoreSource();

}
