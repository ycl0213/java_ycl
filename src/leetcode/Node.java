package leetcode;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


//  Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }
class Node {
    private int postRootIndex = 0;

    private int[] gInorder;

    private int[] gPostorder;

    private List<TreeNode> res = new ArrayList<>();

    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 中序遍历的顺序是：左根右
        // 后序遍历的顺序是：左右根
        // 所以后序序列的最后一个元素为根节点元素，且左边最靠近根节点的元素为右子树的根节点的元素
        // 所以从后序序列中拿到根节点元素，然后在中序序列中找个根节点的索引，
        // 然后创建根节点，
        // 然后以相同的方式，使用从根索引的位置到序列末尾的位置的序列创建右子树
        // 使用从序列开始的索引到根索引的位置创建左子树

        gInorder = inorder;
        gPostorder = postorder;
        int length = gPostorder.length;
        postRootIndex = length - 1;
        for(int i=0;i<length;i++) {
            map.put(gInorder[i], i);
        }
        return createNode(0, length-1);
    }

    private TreeNode createNode(int inLeft, int inRight) {
        if(inLeft > inRight) {
            return null;
        }
        int rootValue = gPostorder[postRootIndex];
        postRootIndex --;
        TreeNode node = new TreeNode(rootValue);
        int inRootIndex = map.get(rootValue);
        node.right = createNode(inRootIndex+1, inRight);
        node.left = createNode(inLeft, inRootIndex-1);
        res.add(node);
        return node;
    }


    public static void main(String[] args) {
        Node node = new Node();
        int [] inorder =new int[]{9,3,15,20,7};
        int [] Postorder = new int[]{9,15,7,20,3};
        node.buildTree(inorder,Postorder);
        Collections.reverse(node.res);
        for (int i = 0; i < node.res.size() ; i++) {
            System.out.print(node.res.get(i).val + " ");
        }

    }
}

