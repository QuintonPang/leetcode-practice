/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
     serializeHelper(root, s);
    return s.toString();
    }
    
    void serializeHelper(TreeNode node, StringBuilder s){
        if(node==null)  s.append("null,");else{
            
        
        s.append(node.val).append(",");
        serializeHelper(node.left,s);
        serializeHelper(node.right,s);
        
        }}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> strings = new ArrayDeque<>(Arrays.asList(data.split(",")));
       
        return deserializeHelper(strings);
        
    }
    
    TreeNode deserializeHelper(Queue<String> values){
        String value = (values.poll());
        if (value.equals("null"))return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(values);
        node.right = deserializeHelper(values);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));