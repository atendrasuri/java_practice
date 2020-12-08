package com.suri.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 28/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class TrieDemo {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("Atendra");

        System.out.println(""+trie.search("Atendr"));

    }
}


class Trie{


    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {

            children = new HashMap<>();
            endOfWord = false;
        }
    }


    TrieNode root;

    Trie() {
        root = new TrieNode();
    }



    public void insert(String word){

        TrieNode curent=root;

        for(int i=0;i<word.length();i++){


            char ch= word.charAt(i);

            TrieNode node = curent.children.get(ch);

            if(node==null){
                node= new TrieNode();
                curent.children.put(ch,node);
            }

            curent= node;
        }

        curent.endOfWord=true;

    }


    /**
     * insert recursive
     */

    public void insertRecursive(String word){
        insertRecursive(root,word,0);
    }

    public void insertRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            current.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            node = new TrieNode();
            node.children.put(ch, node);
        }

        insertRecursive(node, word, index + 1);
    }


    /**
     * serch operation in Trie datastructure
     */


    public boolean search(String word){


        TrieNode curent = root;

        for(int i=0;i<word.length();i++){

            char ch = word.charAt(i);

            TrieNode node=curent.children.get(ch);

            if(node==null){
                return false;
            }
            curent=node;

        }
        return curent.endOfWord;
    }


    /**
     *
     * serach Recursive
     */

    public boolean serchRecursive(String word){
        return serchRecursive(root,word,0);
    }

    public boolean serchRecursive(TrieNode current, String word, int index) {


        if (index == word.length()) {
            return current.endOfWord;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        if (node == null) {
            return false;
        }
        return serchRecursive(node, word, index + 1);

    }

}