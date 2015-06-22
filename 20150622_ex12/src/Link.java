/*	Uses: 鏈結串列的類別
 * 	Java JDK: 1.8
 */
public class Link {
	public Node root;	//鏈結串列的Root
	public Link(String v1, int v2){
		root = new Node(v1,v2);
	}
	public void addLast(String v1, int v2){
		addLast(v1, v2, root);
	}
	public void addLast(String v1, int v2, Node nod1){
		if(nod1.nextNode == null){
			nod1.nextNode = new Node(v1,v2);
		}else{
			addLast(v1, v2, nod1.nextNode);
		}
	}
	public void showData(){
		showData(root);
	}
	public void showData(Node nod2){
		System.out.println(nod2.name+"\t"+nod2.high);
		if(nod2.nextNode != null){
			showData(nod2.nextNode);
		}
	}
}
