package me.aurium.beetle.api.nodes.abstraction;

import me.aurium.beetle.api.nodes.Node;
import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class AbstractBaseNode<T extends Node<T>> implements Node<T> {

    private final Block identifier;
    private final Set<T> nodes;

    protected AbstractBaseNode(Set<T> nodes, Block identifier) {
        this.nodes = nodes;
        this.identifier = identifier;
    }

    public BlockPath getAbsolutePath() {
        return identifier.asSingleBlockpath();
    }

    public Block getShortPath() {
        return identifier;
    }

    public T getRoot() {
        return (T) this;
    }

    public T getParent() {
        return (T) this;
    }

    public Optional<T> getSpecificNode(BlockPath path) {
        return (Optional<T>) Optional.of(this);
    }

    public Collection<T> getLinkedNodes() {
        return nodes;
    }
}
