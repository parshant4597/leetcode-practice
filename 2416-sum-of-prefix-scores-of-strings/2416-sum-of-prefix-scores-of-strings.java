class Node {
    Node node[] = new Node[26];
    int prefix = 0;

    public Node get(char ch) {
        return node[ch - 'a'];
    }

    public void put(char ch, Node nodi) {
        node[ch - 'a'] = nodi;
    }

    public boolean containsKey(char ch) {
        return node[ch - 'a'] != null;
    }

    public void inc() {
        prefix++;
    }

    public void dec() {
        prefix--;
    }

    public int getpre() {
        return prefix;
    }

}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.inc();
        }

    }

    public int getprefixscore(String word, String[] words) {

        int count = 0;
        Node node = root;
        String res = "";
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                break;
            }
            node = node.get(ch);
            count += node.getpre();  
        }
        return count;
    }

}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int[] ans = new int[words.length];
        int i = 0;
        for (String word : words) {
            ans[i++] = trie.getprefixscore(word, words);
        }
        return ans;

    }
}