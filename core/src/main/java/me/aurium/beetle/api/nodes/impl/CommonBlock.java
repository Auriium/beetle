package me.aurium.beetle.api.nodes.impl;

import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;

import java.util.Objects;

public class CommonBlock implements Block {

    private final String identifier;

    public CommonBlock(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public BlockPath asSingleBlockpath() {
        return CommonBlockPath.of(this);
    }

    public static Block of(String string) {
        return new CommonBlock(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonBlock that = (CommonBlock) o;
        return identifier.equals(that.identifier);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
