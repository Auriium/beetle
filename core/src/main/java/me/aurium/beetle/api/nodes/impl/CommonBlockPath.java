package me.aurium.beetle.api.nodes.impl;

import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommonBlockPath implements BlockPath {

    public final static String SPLITTER = "\\.";

    private final BlockPath root;
    private final BlockPath parent;
    private final LinkedList<Block> blocks;
    private final boolean isSevered;

    public CommonBlockPath(BlockPath root, BlockPath parent, LinkedList<Block> blocks, boolean isSevered) {
        this.root = root;
        this.parent = parent;
        this.blocks = blocks;
        this.isSevered = isSevered;
    }

    public CommonBlockPath(LinkedList<Block> list, boolean isSevered) {
        this.root = this;
        this.parent = this;
        this.blocks = list;
        this.isSevered = isSevered;
    }

    public CommonBlockPath() {
        this.root = this;
        this.parent = this;
        this.blocks = new LinkedList<>();
        this.isSevered = true;
    }

    @Override
    public boolean isSevered() {
        return isSevered;
    }

    @Override
    public boolean endsWith(Block path) {
        return blocks.getLast().equals(path);
    }

    @Override
    public boolean startsWith(Block path) {
        return blocks.getFirst().equals(path);
    }

    @Override
    public BlockPath getRoot() {
        return root;
    }

    @Override
    public BlockPath getParent() {
        return parent;
    }

    @Override
    public BlockPath resolve(BlockPath path) {

        LinkedList<Block> pathblocks = this.blocks;

        for (Block block : path.getAllBlocks()) {
            pathblocks.addLast(block);
        }

        return new CommonBlockPath(root,this,pathblocks,false);
    }

    @Override
    public BlockPath resolve(Block block) {

        LinkedList<Block> pathBlocks = this.blocks;

        pathBlocks.addLast(block);

        return new CommonBlockPath(root,this,pathBlocks,false);
    }

    @Override
    public BlockPath resolve(String string) {
        return resolve(CommonBlock.of(string));
    }

    @Override
    public List<Block> getAllBlocks() {
        return this.blocks;
    }

    @Override
    public String asString() {

        StringBuilder base = new StringBuilder();

        for (Block block : this.blocks) {
            base.append(SPLITTER).append(block.getIdentifier());
        }

        return base.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonBlockPath that = (CommonBlockPath) o;
        return blocks.equals(that.blocks);
    }

    @Override
    public int hashCode() {
        return blocks.hashCode();
    }

    public static CommonBlockPath of(String string) {
        String[] subparts = string.split(SPLITTER);
        LinkedList<Block> blocklist = new LinkedList<>();

        for (String s : subparts) {
            blocklist.addLast(CommonBlock.of(s));
        }

        return new CommonBlockPath(blocklist,subparts.length > 1);
    }

    public static CommonBlockPath of(Block block) {
        LinkedList<Block> send = new LinkedList<>();
        send.addLast(block);
        return new CommonBlockPath(send,true);
    }
}
