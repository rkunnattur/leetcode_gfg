/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Node{
        int r;
        int c;
        TreeNode n;
        Node(int x,int y,TreeNode t){
            r=x;
            c=y;
            n=t;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> q=new LinkedList<>();
        Map<Integer,List<Node>> map=new HashMap<>();
        List<List<Integer>> res=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        q.add(new Node(0,0,root));
        
        while(!q.isEmpty()){
            Node t=q.remove();
            min=Math.min(min,t.c);
            max=Math.max(max,t.c);
            
            List<Node> temp=map.getOrDefault(t.c,new ArrayList<>());
            temp.add(t);
            map.put(t.c,temp);
            if(t.n.left!=null){
                q.add(new Node(t.r+1,t.c-1,t.n.left));
            }
            
            if(t.n.right!=null){
                q.add(new Node(t.r+1,t.c+1,t.n.right));
            }
        }
        
        for(int i=min;i<=max;i++){
            List<Integer> a=new ArrayList<>();
            List<Node> l=map.get(i);
            Collections.sort(l,(x,y)->{
                if(x.r==y.r)
                    return x.n.val-y.n.val;
                return x.r-y.r;
            });
            
            for(Node node:l){
                a.add(node.n.val);
            }
            res.add(a);
        }
        return res;
    }
}