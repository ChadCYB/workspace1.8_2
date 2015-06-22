/*	Uses: 單個鏈結的類別
 * 	Java JDK: 1.8
 */
public class Node {
	public String name;		//選手姓名
	public int high;		//選手身高
	public Node nextNode;	//下一個Node指標
	public Node(String v1, int v2){
		name = v1;
		high = v2;
		nextNode = null;
	}
}
