package me.aurium.beetle.api.file.producer;

import java.util.Optional;

/**
 * represents a combination of an accessor and a provisioner that is typically backed by a FileProvider (TODO renane to provisioner
 * @param <T> accessor
 * @param <C> provisioner
 */
public interface FileProvisioner<T, C extends ProvisionAccessor> {

    Optional<T> access();
    C getProvisioner();

}
