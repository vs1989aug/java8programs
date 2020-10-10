package datastructure.custom;

public class NodeList {

	static Node last = new Node();
	Node emptyNode=new Node();
	static Node current = new Node();
	static int size = 0;

	public NodeList() {
	}

	Node add(Integer value) {
		Node newNode = new Node();
		newNode.data = value;
		if(size==0)
		newNode.next = emptyNode;
		else
			newNode.next=last;
		last = newNode;
		size++;
		return last;
	}

	void displayListData() {

		while(last.next!=null){
			System.out.println(last.data);
			last=last.next;
			}
	}
}
