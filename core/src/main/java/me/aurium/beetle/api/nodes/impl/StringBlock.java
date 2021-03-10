package me.aurium.beetle.api.nodes.impl;

import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;

public class StringBlock implements Block {

    private final String identifier;

    public StringBlock(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public BlockPath asSingleBlockpath() {
        return StringBlockPath.of(this);
    }

    public static Block of(String string) {
        return new StringBlock(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringBlock that = (StringBlock) o;
        return identifier.equalsIgnoreCase(that.identifier);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
