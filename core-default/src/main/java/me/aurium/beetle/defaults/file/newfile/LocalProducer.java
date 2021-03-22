package me.aurium.beetle.defaults.file.newfile;

import me.aurium.beetle.api.datacore.CoreSource;
import me.aurium.beetle.api.file.producer.FileProducer;
import me.aurium.beetle.defaults.file.StateHolder;

import java.nio.file.Path;
import java.util.Optional;

public class LocalProducer implements FileProducer<CoreSource,LocalSourceProvisioner> {

    private final StateHolder<CoreSource> coreSourceHolder;
    private final LocalSourceProvisioner provisioner;

    public LocalProducer(Path fullPathToObject, LocalSourceOptions options) {
        this.coreSourceHolder = new StateHolder<>();

        this.provisioner = new LocalSourceProvisioner(coreSourceHolder, fullPathToObject, options);
    }

    @Override
    public Optional<CoreSource> access() {
        return coreSourceHolder.getHeld();
    }

    @Override
    public LocalSourceProvisioner getProvisioner() {
        return provisioner;
    }
}
