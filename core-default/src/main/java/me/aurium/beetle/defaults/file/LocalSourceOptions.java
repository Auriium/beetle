package me.aurium.beetle.defaults.file;

import me.aurium.beetle.api.file.producer.CreationOptions;
import me.aurium.beetle.defaults.file.database.SourceableFileExtension;

import java.nio.file.Path;

public class LocalSourceOptions implements CreationOptions<LocalProvisioner> {

    private final SourceableFileExtension extensionType;
    private final String username;
    private final String password;
    private final Path fileShortName;
    private final int timeout;

    public LocalSourceOptions(String username, String password, SourceableFileExtension extensionType, String fileShortName) {
        this.username = username;
        this.password = password;
        this.extensionType = extensionType;
        this.fileShortName = Path.of(fileShortName);
        this.timeout = 60;
    }

    public LocalSourceOptions(String username, String password, SourceableFileExtension extensionType, String fileShortName, int timeout) {
        this.username = username;
        this.password = password;
        this.extensionType = extensionType;
        this.fileShortName = Path.of(fileShortName);
        this.timeout = timeout;
    }

    public SourceableFileExtension getExtensionType() {
        return extensionType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getTimeout() {
        return timeout;
    }

    @Override
    public LocalProvisioner newProducer(Path basePath) {
        Path finalPath = basePath.resolve(extensionType.of(fileShortName));

        return new LocalProvisioner(finalPath,this);
    }
}
