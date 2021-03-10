package me.aurium.beetle.api.nodes.abstraction;

import me.aurium.beetle.api.nodes.path.Block;

public class SingleNode extends AbstractSingleNode<CommonNode> implements CommonNode {

    public SingleNode(CommonNode root, CommonNode parent, Block identifier) {
        super(root, parent, identifier);
    }

    @Override
    public String getCommon() {
        return "SCREAMING FOR HELP";
    }


}
