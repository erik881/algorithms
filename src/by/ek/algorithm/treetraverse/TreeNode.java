package by.ek.algorithm.treetraverse;

/**
 * @author Evgeni_Kisel
 */
public class TreeNode {

	private final String value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Value: ").append(value);
		sb.append(";Left: ");
		if (left == null) {
			sb.append("null");
		} else {
			sb.append("{ ").append(left.toString()).append(" }");
		}

		sb.append(";Right: ");
		if (right == null) {
			sb.append("null");
		} else {
			sb.append("{ ").append(right.toString()).append(" }");
		}

		return sb.toString();
	}
}
