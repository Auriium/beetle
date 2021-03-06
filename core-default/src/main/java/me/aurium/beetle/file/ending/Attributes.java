package me.aurium.beetle.file.ending;

import me.aurium.beetle.file.extension.Extension;

import java.util.Set;

public class Attributes {

    private Set<Class<? extends Extension>> attributeSet;

    public Attributes(Set<Class<? extends Extension>> attributeSet) {
        this.attributeSet = attributeSet;
    }

    public boolean hasAttribute(Extension attribute) {
        return (attributeSet.contains(attribute.getClass()));
    }

}
