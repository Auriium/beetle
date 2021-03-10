package me.aurium.beetle.api.nodes;

import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;

import java.util.Collection;
import java.util.Optional;

public interface Node<T extends Node<T>> {

    BlockPath getAbsolutePath();

    Block getShortPath();

    T getRoot();

    T getParent();

    Optional<T> getSpecificNode(BlockPath path);

    Collection<T> getLinkedNodes();

}
