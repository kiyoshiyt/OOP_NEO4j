package CreateRelationship;
/**
 * Tao quan he giua cac thuc the
 * @author tt
 *
 */
public abstract class CreateRelationship {
	
	protected int maxNode1;//so luong node toi da cua tap thuc the 1
	protected int maxNode2;//so luong node toi da cua tap thuc the 2

	
	public CreateRelationship(int maxNode1, int maxNode2){
		this.maxNode1=maxNode1;
		this.maxNode2= maxNode2;
	}
	
	public abstract void CreateRelationship(int numRelationship);//ghi quan he sinh ngau nhien ra file .csv theo cau truc da quy uoc 
																// xem chi tiet tai https://neo4j.com/docs/operations-manual/current/tools/import/file-header-format/
	
	
}
