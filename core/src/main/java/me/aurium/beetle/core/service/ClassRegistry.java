package me.aurium.beetle.core.service;

import java.util.Optional;

/**
 * An interface representing something that can have services registered to it as well as provide them.
 */
public interface ClassRegistry {

    /**
     * Registers a Service to a Class-Type.
     *
     * @param clazz the type to register the service to
     * @param object The service
     * @param <T> Type of the service
     * @throws me.aurium.beetle.core.utility.exception.DuplicateServiceException if something already exists in that service's location.
     */
    <T> void registerService(Class<T> clazz, T object);

    /**
     * Unregisters a service based on class type.
     * @param clazz the type of service
     * @throws me.aurium.beetle.core.utility.exception.MissingServiceException if no service was present mapped to that class.
     */
    void unregisterService(Class<?> clazz);

    /**
     * Gets a service from the registry if it is present.
     *
     * @param clazz
     * @param <T>
     * @return
     */
    <T> Optional<T> getService(Class<T> clazz);

}
