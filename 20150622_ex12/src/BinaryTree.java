
public class BinaryTree {
	public BinaryNode root;
	public BinaryTree(String n, int h){
		root = new BinaryNode(n,h);
	}
	public void addLast(String n,int h){
		addLast(n, h, root);
	}
	public void addLast(String n,int h,BinaryNode bNode){
		if(h < bNode.height){		//Left
			if(bNode.LeftNode == null){
				bNode.LeftNode = new BinaryNode(n,h);
			}else{
				addLast(n,h,bNode.LeftNode);
			}
		}else{					//Right
			if(bNode.RightNode == null){
				bNode.RightNode = new BinaryNode(n,h);
			}else{
				addLast(n,h,bNode.RightNode);
			}
		}
	}
	public void vInOrder(){		//¤¤§Ç°lÂÜ
		vInOrder(root);
	}
	public void vInOrder(BinaryNode bNode){
		if(bNode.LeftNode != null) vInOrder(bNode.LeftNode);	//Left
		System.out.println(bNode.name+"\t"+bNode.height); 		//Center
		if(bNode.RightNode != null)	vInOrder(bNode.RightNode);	//Right
	}
}
