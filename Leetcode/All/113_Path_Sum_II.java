public class Solution {
    // TODO: space complexity and time complexity
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(root == null)    return ret;
        List<Integer> path = new LinkedList<Integer>();
        path.add(root.val);
        doDFS(root, sum-root.val, path, ret);
        return ret;
    }
    
    private void doDFS(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ret){
        if(root.left == null && root.right == null && sum == 0){
            List<Integer> list = new LinkedList<Integer>(path);
            ret.add(list);
            return;
        }
        if(root.left != null){
            path.add(root.left.val);
            doDFS(root.left, sum - root.left.val, path, ret);
            path.remove(path.size()-1);
            
        }
        if(root.right != null){
            path.add(root.right.val);
            doDFS(root.right, sum - root.right.val, path, ret);
            path.remove(path.size()-1);
        }
    }

    //精简版本:
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        helper(root, ret, path, sum);
        return ret;
    }
    
    private void helper(TreeNode root, List<List<Integer>> ret, List<Integer> path, int sum){
        if(root == null)    return;
        path.add(root.val);
        if(root.left == null && root.right == null && sum - root.val == 0){
            List<Integer> sol = new LinkedList<Integer>(path);
            ret.add(sol);
        }
        helper(root.left, ret, path, sum - root.val);
        helper(root.right, ret, path, sum - root.val);
        path.remove(path.size() - 1);
    }
}