
public class BinaryTree {
	public BinaryNode root;
	public BinaryTree(String n, int h){
		root = new BinaryNode(n,h);
	}
	public void addLast(String n,int h){
		addLast(n, h, root);
	}
	public void addLast(String n,int h,BinaryNode bNode){
		if(h < bNode.high){		//Left
			if(bNode.LeftNode == null){
				bNode.LeftNode = new BinaryNode(n,h);
			}else{
				addLast(n,h,bNode.LeftNode);
			}
		}else{	//Right
			if(bNode.RightNode == null){
				bNode.RightNode = new BinaryNode(n,h);
			}else{
				addLast(n,h,bNode.RightNode);
			}
		}
	}

}
