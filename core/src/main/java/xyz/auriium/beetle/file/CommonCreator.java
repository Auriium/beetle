package xyz.auriium.beetle.file;

import java.nio.file.Path;

/**
 * Really simple creator
 */
public class CommonCreator implements FileCreator {

    private final Path basePath;

    public CommonCreator(Path basePath) {
        this.basePath = basePath;
    }

    @Override
    public <T extends FileProvisioner<?, ?>> T createAndLoad(CreationOptions<T> options) {
        T provisioner = options.newProducer(basePath);

        provisioner.getAccessor().load();

        return provisioner;
    }

    @Override
    public <T extends FileProvisioner<E, ?>, E> E createAndAccess(CreationOptions<T> options) throws IllegalAccessError {
        T provisioner = options.newProducer(basePath);

        provisioner.getAccessor().load();

        return provisioner.access();
    }
}
