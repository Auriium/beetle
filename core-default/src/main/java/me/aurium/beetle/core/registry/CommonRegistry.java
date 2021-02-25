package me.aurium.beetle.core.registry;

import me.aurium.beetle.core.service.ServiceRegistry;
import me.aurium.beetle.core.service.DuplicateServiceException;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class CommonRegistry implements ServiceRegistry {

    private final ConcurrentHashMap<Class<?>,Service<?>> serviceMappings;

    //Not sure how to feel about these - probably clean this up later
    public CommonRegistry() {
        this.serviceMappings = new ConcurrentHashMap<>();
    }

    public CommonRegistry(Class<?> clz, Object t) {
        ConcurrentHashMap<Class<?>,Service<?>> map = new ConcurrentHashMap<>();

        map.put(clz,new Service<>(t));

        this.serviceMappings = map;
    }

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
