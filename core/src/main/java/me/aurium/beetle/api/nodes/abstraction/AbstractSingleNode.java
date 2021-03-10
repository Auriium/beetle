package me.aurium.beetle.api.nodes.abstraction;

import me.aurium.beetle.api.nodes.Node;
import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public abstract class AbstractSingleNode<T extends Node<T>> implements Node<T>{

    private final T root;
    private final T parent;
    private final Block identifier;

    protected AbstractSingleNode(T root, T parent, Block identifier) {
        this.root = root;
        this.parent = parent;
        this.identifier = identifier;
    }

    public BlockPath getAbsolutePath() {
        return parent.getAbsolutePath().resolve(identifier);
    }

    public Optional<T> getSpecificNode(BlockPath path) {
        return (Optional<T>) Optional.of(this);
    }

    public Block getShortPath() {
        return identifier;
    }

    public T getRoot() {
        return root;
    }

    public T getParent() {
        return parent;
    }

    public Collection<T> getLinkedNodes() {
        return Collections.emptySet();
    }
}
