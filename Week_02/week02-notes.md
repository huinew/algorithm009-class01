学习笔记

题目：https://leetcode-cn.com/problems/valid-anagram/description/
解法一：用一个数组，26位，存储每个字母出现的次数，然后新字符串中每个字母出现一次就对应次数减一。时间复杂度O（n），空间复杂度O(n)
Most Votes1：（Java）
```
public boolean isAnagram(String s, String t) {
   char[] count = new char[26];
    
    for (int i = 0; i < s.length(); i++){
        count[s.charAt(i)-'a']++;    
    }
    for (int i = 0; i < t.length();i++){
        count[t.charAt(i) - 'a']--;
    }
    for (int i : count){
        if (i != 0){
            return false;
        }
    }
    return true;
}
```

内存使用比较少,超过100%；但运行时间相对慢些，24ms，超过50%多：(C++)
```
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        unordered_map<char, int> counts;
        for (int i = 0; i < n; i++) {
            counts[s[i]]++;
            counts[t[i]]--;
        }
        for (auto count : counts)
            if (count.second) return false;
        return true;
    }
```
解法二：直接对两个字符串排序，然后比对两个字符串是否相等即可
时间复杂度是O（nlogn），空间复杂度是O（n）

```
public isAnagram(string s, string t){
    char[] array1 = s.toCharArray();
    char[] array2 = t.toCharArray();

    Arrays.sort(array1);
    Arrays.sort(array2);

    return array1.equals(array2);
}
```

### 二叉树的前序遍历模板
```
preOrder(root);
if (root!=null){
    travsel(root);
    preOrder(root.left)
    preOrder(root.right)
}
```
### 中序遍历模板
```
inOrder(root);
if (root!=null){
    inOrder(root.left)
    travsel(root);
    inOrder(root.right)
}
```
### 后序遍历模板
```
PostOrder(root);
if (root!=null){
    PostOrder(root.left)
    PostOrder(root.right)
    travsel(root);
}
```

### N叉树层序遍历
层序遍历一般和广度优先比较接近，我们一般都会用队列来配合广度优先使用
```
List<List<Integer>> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
   
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return result;
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> val = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                val.add(node.val);
                queue.addAll(node.children);
            }
            result.add(val);
        }
        return result;
    }
```

简化版的广度优先算法，时间复杂度和空间复杂度都是O（n）
```
 List<List<Integer>> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
   
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return result;
        List<Node> preLayer = Arrays.asList(root);

        while(!preLayer.isEmpty()){
            List<Node> curLayer = new ArrayList<>();
            List<Integer> val = new ArrayList<>();
            for (Node child : preLayer){
                val.add(child.val);
                curLayer.addAll(child.children);
            }
            result.add(val);
            preLayer = curLayer;
        }
        return result;
    }
```

递归法：
```
 List<List<Integer>> result = new ArrayList<>();

    public void traverseNode(Node node, int level){
        if (result.size() <= level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);
        for (Node child : node.children)
            traverseNode(child, level + 1);
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null)
            traverseNode(root, 0);
        return result;    
    }
```
时间复杂度O(logN)，最坏情况O(n)，空间复杂度O（n）

