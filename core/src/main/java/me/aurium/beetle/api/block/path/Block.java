package me.aurium.beetle.api.block.path;

/**
 * Block. You can think of it as an identifier.
 *
 * BLOCKS ARE CASE SENSTIIVE.
 */
public interface Block {

    String getIdentifier();
    BlockPath asSingleBlockpath();

}
