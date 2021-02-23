package me.aurium.beetle.core.registry;

import me.aurium.beetle.core.service.ServiceRegistry;
import me.aurium.beetle.core.utility.exception.DuplicateServiceException;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleRegistry implements ServiceRegistry {

    private final ConcurrentHashMap<Class<?>,Service<?>> serviceMappings;

    //Not sure how to feel about these - probably clean this up later
    public SimpleRegistry() {
        this.serviceMappings = new ConcurrentHashMap<>();
    }

    public SimpleRegistry(ConcurrentHashMap<Class<?>,Service<?>> map) {
        this.serviceMappings = map;
    }

    public SimpleRegistry(Class<?> clz, Object t) {
        ConcurrentHashMap<Class<?>,Service<?>> map = new ConcurrentHashMap<>();

        map.put(clz,new Service<>(t));

        this.serviceMappings = map;
    }

    @Override
    public <T> void registerService(Class<T> clazz, T object) {
        if (serviceMappings.containsKey(clazz)) throw new DuplicateServiceException(clazz.getName() + " already has a service registered to it's class name! Your'e a bitch");

        serviceMappings.put(clazz,new Service<>(object));
    }

    @Override
    public void unregisterService(Class<?> clazz) {
        serviceMappings.remove(clazz);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Optional<T> getService(Class<T> clazz) {

        Service<T> service = (Service<T>) serviceMappings.get(clazz);

        if (service == null) return Optional.empty();

        return Optional.of(service.getService());
    }
}
