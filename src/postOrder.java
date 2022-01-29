/**
 * 后序遍历：左-右-根
 * 后序遍历的非递归算法是三种顺序中最复杂的，
 * 原因在于，后序遍历是先访问左、右子树,再访问根节点，而在非递归算法中，利用栈回退到时，并不知道是从左子树回退到根节点，还是从右子树回退到根节点，
 * 如果从左子树回退到根节点，此时就应该去访问右子树，而如果从右子树回退到根节点，此时就应该访问根节点。
 * 所以相比前序和后序，必须得在压栈时添加信息，以便在退栈时可以知道是从左子树返回，还是从右子树返回进而决定下一步的操作。
 */


import java.util.Stack;
public class postOrder
{
    public static void main(String[] args)
    {
        TreeNode[] node = new TreeNode[10];//以数组形式生成一棵完全二叉树
        for(int i = 0; i < 10; i++)
        {
            node[i] = new TreeNode(i);
        }
        for(int i = 0; i < 10; i++)
        {
            if(i*2+1 < 10)
                node[i].left = node[i*2+1];
            if(i*2+2 < 10)
                node[i].right = node[i*2+2];
        }

        postOrderRe(node[0]);
        System.out.println("***");
        postOrder(node[0]);
    }



    public static void postOrderRe(TreeNode biTree)
    {//后序遍历递归实现
        if(biTree == null)
            return;
        else
        {
            postOrderRe(biTree.left);
            postOrderRe(biTree.right);
            System.out.println(biTree.value);
        }
    }

    public static void postOrder(TreeNode biTree)
    {//后序遍历非递归实现
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while(biTree != null || !stack.empty())
        {
            while(biTree != null)
            {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.left;
            }

            while(!stack.empty() && stack2.peek() == right)  // stack.peek()不删除栈顶元素
            {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().value);
            }

            if(!stack.empty() && stack2.peek() == left)
            {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().right;
            }

        }
    }
}

class TreeNode1//节点结构
{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode1(int value)
    {
        this.value = value;
    }
}