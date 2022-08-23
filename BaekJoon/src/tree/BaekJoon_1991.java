package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	Node parent, left, right;
	char data;
	
	Node(char data) {
		this.data = data;
	}
}

// 트리 순회
public class BaekJoon_1991 {
	static Node[] data;
	static StringBuilder answer;
	
	static void preOrder(Node curr) {
		answer.append(curr.data);
		if (curr.left != null) preOrder(curr.left);
		if (curr.right != null) preOrder(curr.right);
	}
	
	static void inOrder(Node curr) {
		if (curr.left != null) inOrder(curr.left);
		answer.append(curr.data);
		if (curr.right != null) inOrder(curr.right);
	}
	
	static void postOrder(Node curr) {
		if (curr.left != null) postOrder(curr.left);
		if (curr.right != null) postOrder(curr.right);
		answer.append(curr.data);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		data = new Node[26];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c1 = st.nextToken().charAt(0);
			char c2 = st.nextToken().charAt(0);
			char c3 = st.nextToken().charAt(0);
			
			Node node;
			if (data[c1 - 'A'] != null) {
				node = data[c1 - 'A'];
			} else {
				node = new Node(c1);
				data[c1 - 'A'] = node;
			}
			if (c2 != '.') {
				Node lNode;
				if (data[c2 - 'A'] != null) {
					lNode = data[c2 - 'A'];
				} else {
					lNode = new Node(c2);
					data[c2 - 'A'] = lNode;
				}
				node.left = lNode;
			}
			if (c3 != '.') {
				Node rNode;
				if (data[c3 - 'A'] != null) {
					rNode = data[c3 - 'A'];
				} else {
					rNode = new Node(c3);
					data[c3 - 'A'] = rNode;
				}
				node.right = rNode;
			}
		}
		
		Node root = data[0];
		preOrder(root);
		answer.append("\n");
		inOrder(root);
		answer.append("\n");
		postOrder(root);
		System.out.println(answer);
		br.close();
	}

}
