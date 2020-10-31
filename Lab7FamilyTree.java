import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab7FamilyTree {

	/**
	 * Lab Problem 7 -> on 03 March - 09 March
	 * 
	 * Sample Input 1:
	 * 8
	 * Motilal Jawahar
	 * Jawahar Indira
	 * Motilal Kamala
	 * Indira Sanjay
	 * Sanjay Varun
	 * Indira Rajiv
	 * Rajiv Priyanka
	 * Rajiv Rahul
	 * 6
	 * Motilal child Jawahar
	 * Varun descendant Indira
	 * Priyanka sibling Varun
	 * Sanjay child Indira
	 * Sanjay ancestor Varun
	 * Kamala ancestor Rahul
	 * 
	 * 
	 * 
	 * Sample Input 2:
	 * 9
	 * Prithviraj Raj
	 * Shashi Sanjana
	 * Prithviraj Shashi
	 * Raj Randhir
	 * Rishi Ranveer
	 * Randhir Bebo
	 * Randhir Lolo
	 * Raj Rishi
	 * Rishi Ridhima
	 * 7
	 * Bebo descendant Shashi
	 * Raj sibling Shashi
	 * Prithviraj ancestor Ridhima
	 * Lolo sibling Ridhima
	 * Bebo ancestor Shashi
	 * Prithviraj ancestor Raj
	 * Rishi descendant Raj
	 * 
	 * 
	 * @param args
	 */
	
	public static String output = "";
	
	public static void main(String[] args) {
		
		Scanner fin = null;
		
		try {
				
			fin = new Scanner(System.in);
			int n = Integer.valueOf(fin.nextLine());
		
			List<String> data = new ArrayList<>();
			for(int i=0; i< n; i++) {				
				data.add(fin.nextLine());
			}
				
			int m = Integer.valueOf(fin.nextLine());
			List<String> relation = new ArrayList<>();
			relation = new ArrayList<>();
			for(int i=0; i< m; i++) {				
				relation.add(fin.nextLine());
			}
			
			Node root = build(data);			
			
			StringBuffer buf = new StringBuffer();
			for(String r : relation) {
				boolean result = validateRelation(root, r);
				if(result) {
					buf.append("T ");
				} else {
					buf.append("F ");
				}
			}
			
			System.out.println(buf.toString().trim());
			printPreOrder(root);
			System.out.println(output.trim());			
			
		} catch(Exception e) {
			
			if(fin != null) {
				fin.close();
			}
			
		}
		
	}
	
	public static boolean validate(int n, String m, List<String> data, List<String> relation) {
		
		if(n<0 && n>99) {
			return false;
		}
		Integer mi = Integer.valueOf(m);
		if(mi<0 && mi>99) {
			return false;
		}
		
		if(data.size() != n) {
			return false;
		}
		
		if(relation.size() != mi) {
			return false;
		}
		
		return true;
	}
	
	public static boolean validateRelation(Node root, String relationInput) {
		boolean result = false;
		
		String[] values =  relationInput.split(" ");
		String p1 = values[0];
		String relation = values[1];
		String p2 = values[2];
		
		switch (relation) {
			case "child":
				result = isChild(root, p1, p2);
				break;
			case "descendant":
				result = isDescendant(root, p1, p2);
				break;
			case "sibling":
				result = isSibling(root, p1, p2);
				break;
			case "ancestor":
				result = isAncestor(root, p1, p2);
				break;
			case "parent":
				result = isParent(root, p1, p2);
				break;
			default:
				break;
		}
		
		
		return result;
	}
	
	public static void printPreOrder(Node root) {
		
		if(root.getValue() != null) {
			output = output + root.getValue() + " ";
		}
		
		if(root.getLeft() != null) {
			printPreOrder(root.getLeft());
		}
		
		if(root.getRight() != null) {
			printPreOrder(root.getRight());
		}
	}
	
	public static Node build(List<String> data) {
		Node root = null;
		for(String f : data) {
			String[] x = f.split(" ");
			root = insertNode(root, x[0], x[1]);
		}
		return root;
	}
	
	public static Node insertNode(Node node, String parent, String child) {
		
		if(node == null) {
			node = new Node(parent);
		} 
		
		Node result = searchNode(node, parent);
		
		if(result == null) {
			return node;
		}
		
		if(result.getLeft() == null) {
			Node temp = new Node(child);
			result.setLeft(temp);
		} else {
			Node temp = new Node(child);
			result.setRight(temp);
		}
		
		return node;
	}
	
	
	public static boolean isSibling(Node root, String p1, String p2) {
		boolean r = false;
		
		Node result1 = searchParent(root, p1);
		Node result2 = searchParent(root, p2);
		if(result1 != null && result2 != null) {
			if(result1.getValue().equalsIgnoreCase(result2.getValue())) {
				r = true;
			}	
		}
		
		return r;
	}
	
	public static boolean isAncestor(Node root, String p1, String p2) {
		boolean r = false;
		
		Node result = searchNode(root, p1);
		if(result != null) {
			Node temp = searchNode(result, p2);
			if(temp != null) {
				r = true;
			}
		}
		
		return r;
	}
	
	public static boolean isDescendant(Node root, String p1, String p2) {
		boolean r = false;
		
		Node result = searchNode(root, p2);
		if(result != null) {
			Node temp = searchNode(result, p1);
			if(temp != null) {
				r = true;
			}
		}
		
		return r;
	}
	
	public static boolean isParent(Node root, String p1, String p2) {
		boolean r = false;
		
		Node result = searchNode(root, p1);
		if(result != null) {
			if(result.getLeft() != null && result.getLeft().getValue().equalsIgnoreCase(p2)) {
				r = true;
			}
			if(result.getRight() != null && result.getRight().getValue().equalsIgnoreCase(p2)) {
				r = true;
			}
		}
		
		return r;
	}
	
	public static boolean isChild(Node root, String p1, String p2) {
		boolean r = false;
		
		Node result = searchNode(root, p2);
		if(result != null) {
			if(result.getLeft() != null && result.getLeft().getValue().equalsIgnoreCase(p1)) {
				r = true;
			}
			if(result.getRight() != null && result.getRight().getValue().equalsIgnoreCase(p1)) {
				r = true;
			}
		}
		
		return r;
	}
	
	public static Node searchParent(Node root, String element) {
		
		if(root.getLeft() != null && root.getLeft().getValue().equalsIgnoreCase(element)) {
			return root;
		}
		
		if(root.getRight() != null && root.getRight().getValue().equalsIgnoreCase(element)) {
			return root;
		}
		
		if(root.getLeft() != null) {
			Node result = searchParent(root.getLeft(), element);	
			if(result != null) {
				return result;
			}
		}
		if(root.getRight() != null) {
			Node result = searchParent(root.getRight(), element);
			if(result != null) {
				return result;
			}
		}
		
		return null;
	}

	
	public static Node searchNode(Node root, String element) {
		
		if(root.getValue().equalsIgnoreCase(element)) {
			return root;
		} 
		if(root.getLeft() != null) {
			Node result = searchNode(root.getLeft(), element);	
			if(result != null) {
				return result;
			}
		}
		if(root.getRight() != null) {
			Node result = searchNode(root.getRight(), element);
			if(result != null) {
				return result;
			}
		}
		
		return null;
	}
	
}
