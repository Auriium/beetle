package me.aurium.beetle.api.nodes.path;

import java.util.Collection;
import java.util.List;

/**
 * Represents a Path that is composed of one or more Block
 */
public interface BlockPath {

    boolean isSevered();

    boolean endsWith(Block path);
    boolean startsWith(Block path);

    BlockPath getRoot();
    BlockPath getParent();

    BlockPath resolve(BlockPath path);
    BlockPath resolve(Block block);
    BlockPath resolve(String string);

    /**
     * Returns an ordered set of blocks
     * @return ordered set of blocks
     */
    List<Block> getAllBlocks();

    String asString();

}
