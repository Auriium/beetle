package xyz.auriium.beetle.file;

/**
 * represents a combination of an accessor and a provisioner that is typically backed by a FileProvider
 * @param <T> accessor
 * @param <C> provisioner
 */
public interface FileProvisioner<T, C extends ProvisionAccessor> {

    T access();
    C getAccessor();

}
