import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> currlst=new ArrayList<>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currnode = q.poll();
                currlst.add(currnode.val);
                if(currnode.left !=null)
                    q.add(currnode.left);
                if(currnode.right !=null)
                    q.add(currnode.right);
            }
            result.add(currlst);
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
