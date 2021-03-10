package me.aurium.beetle.api.nodes.abstraction;

import me.aurium.beetle.api.nodes.Node;
import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractSectionNode<T extends Node<T>> implements Node<T> {

    private final Set<T> nodes;
    private final T root;
    private final T parent;
    private final Block path;

    protected AbstractSectionNode(Set<T> nodes, T root, T parent, Block path) {
        this.nodes = nodes;
        this.root = root;
        this.parent = parent;
        this.path = path;
    }

    public BlockPath getAbsolutePath() {
        return parent.getAbsolutePath().resolve(path);
    }

    public Block getShortPath() {
        return path;
    }

    public T getRoot() {
        return root;
    }

    public T getParent() {
        return parent;
    }


    public Optional<T> getSpecificNode(BlockPath path) {
        for (T node : this.getLinkedNodes()) {
            if (path.startsWith(node.getShortPath())) {
                return node.getSpecificNode(path);
            }
        }
        return Optional.empty();
    }

    public Collection<T> getLinkedNodes() {
        return nodes;
    }
}
