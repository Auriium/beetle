package me.aurium.beetle.service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class CommonRegistry implements ServiceRegistry {

    private final ConcurrentHashMap<Class<?>,Service<?>> serviceMappings = new ConcurrentHashMap<>();

    @Override
    public <T> void registerService(Class<T> clazz, T object) {
        if (serviceMappings.putIfAbsent(clazz,new Service<>(object)) == null) throw new DuplicateServiceException(clazz.getName() + " already has a service registered to it's class name! Your'e a bitch");
    }

    public <T> void registerServiceIfAbsent(Class<T> clazz, T object) {
        serviceMappings.put(clazz, new Service<>(object));
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
