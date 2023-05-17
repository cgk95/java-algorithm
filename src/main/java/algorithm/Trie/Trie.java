package algorithm.Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    static class Node {
        Map<Character, Node> childNode;
        boolean endOfWord;

        public Node() {
            this.childNode = new HashMap<>();
            this.endOfWord = false;
        }
    }


    Node root;

    public Trie() {
        this.root = new Node();
    }

    void insert(String word) {
        // 트라이 구조는 항상 root 노드부터 시작
        Node curr = this.root;
        // 대상 단어를 하나하나 뜯어가며 자식 노드에 있는지 확인 :: 없으면 자식노드로 추가
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 현재 노드 기준 c 문자에 해당하는 노드가 없으면 추가
            curr.childNode.putIfAbsent(c, new Node());
            // 이어서 추가하기 위해 다음 문자로 이동
            curr = curr.childNode.get(c);

            // word의 끝일 경우 표시후 반환
            if (i == word.length() - 1) {
                curr.endOfWord = true;
                return;
            }
        }

    }

    public boolean search(String word) {
        Node curr = this.root;
        // 문자열의 각 알파벳마다 노드가 존재하는지 체크
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 해당 단어가 있으면 해당 노드로 이동, 없으면 false 리턴
            if (curr.childNode.containsKey(c)) {
                curr = curr.childNode.get(c);
            } else {
                return false;
            }
            // 문자열의 마지막 단어까지 매핑된 노드가 존재한다고해서 무조건 문자열어 존재하는게 아님
            // curr의 terminal이 true가 아니라면 해당 단어가 들어 있는 것이 아니므로 false
            if (i == word.length() - 1) {
                if (!curr.endOfWord) {
                    return false;
                }
            }
        }
        return true;
    }

    public void delete(String word) {
        boolean ret = this.delete(this.root, word, 0);
        if (ret) {
            System.out.println(word + " : 삭제 완료");
        } else {
            System.out.println(word + " : 단어가 없습니닷");
        }
    }

    public boolean delete(Node node, String word, int idx) {
        char c = word.charAt(idx);
        // 없는 단어일 경우
        if (!node.childNode.containsKey(c)) {
            return false;
        }

        Node curr = node.childNode.get(c);
        idx++;

        // 단어의 가장 끝에 도달 후 삭제를 결정
        if (idx == word.length()) {
            // 끝에 도달했어도 단어의 종점이 아닌 경우
            // 해당 단어와 일치하는 것이 아니므로 false
            if (!curr.endOfWord) {
                return false;
            }

            // 해당 단어와 일치할경우 eow를 false로 변경
            curr.endOfWord = false;
            // 이제 문제 없이 삭제
            if (curr.childNode.isEmpty()) {
                node.childNode.remove(c);
            }
        } else {
            if (!this.delete(curr, word, idx)) {
                return false;
            }

            // 끝 문자를 삭제후 앞의 문자들에서 파생되는 단어들이 없으면 함꼐 삭제하기
            if (!curr.endOfWord && curr.childNode.isEmpty()) {
                node.childNode.remove(c);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // Trie 자료구조 생성
        Trie trie= new Trie();
        trie.insert("apple");
        trie.insert("april");
        trie.insert("app");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("app"));      // true
        System.out.println(trie.search("ace"));     // true
        System.out.println(trie.search("bear"));    // true
        System.out.println(trie.search("best"));    // true
        System.out.println(trie.search("abc"));     // false

        System.out.println();
        trie.delete("apple");
        System.out.println(trie.search("apple"));   // false
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("appl"));    // false
        trie.delete("apple");

    }

}
