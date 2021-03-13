package me.aurium.beetle.api.block;

import me.aurium.beetle.api.block.path.Block;
import me.aurium.beetle.api.block.path.BlockPath;

import java.util.Collection;
import java.util.Optional;

//idk why tis exists just delt it lol
public interface Nodular<T extends Nodular<T>> {

    BlockPath getAbsolutePath();

    Block getShortPath();

    Nodular<T> getParent();

    Nodular<T> getRoot();

    Optional<T> getSpecificNode(BlockPath path);

    Collection<T> getLinkedNodes();

}
