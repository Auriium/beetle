package me.aurium.beetle.api.file.producer;

/**
 * Represents something that can control the data provided by the producer
 */
public interface ProvisionAccessor {

    void load(); //all provisioners have a load method no matter what.

}
