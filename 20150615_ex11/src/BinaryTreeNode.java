
public class BinaryTreeNode {
	Object element;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	
	public BinaryTreeNode(){}
	public BinaryTreeNode(Object theElement){
		element = theElement;
	}
	public BinaryTreeNode(Object theElement, BinaryTreeNode leftChild, BinaryTreeNode rightChild){
		element = theElement;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
}
