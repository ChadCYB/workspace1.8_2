/*	Uses: 鏈結串列類別(失敗作品)
 * 	Java JDK: 1.8
 */
public class Linking {
	public int root;
	public Linking nLink;
	public Linking(int data, Linking theLink){
		root = data;
		nLink = theLink;
	}
	public void setNextLink(Linking theLink){
		nLink = theLink;
	}
	public void setNextData(int data){
		nLink = new Linking(data,null);
	}
	public Linking getNextLink(){
		return nLink;
	}
	public int getCurData(){
		return root;
	}
	public void addLast(int data, Linking nextLink){
		if(nLink == null){
			System.out.println("<setNextLink>");
			setNextData(data);
		}else{
//			System.out.println("<addLink>");
			addLast(data,nLink);
		}
	}
	public void addLink(Linking theLink, Linking nextLink){
		if(nLink == null){
			System.out.println("<setNextLink>");
			setNextLink(theLink);
		}else{
//			System.out.println("<addLink>");
			addLink(theLink,nLink);
		}
	}
}
