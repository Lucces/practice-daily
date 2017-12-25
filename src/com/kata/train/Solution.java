package com.kata.train;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 2017/6/29.
 */
public class Solution {


    public static void main(String[] args) {
    }

    public boolean palindromeNumber(int num) {
        // Write your code here
        char[] ints = Integer.toString(num).toCharArray();
        return false;
    }


    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (nums.length < k || nums.length == 0 || k == 0) {
            return result;
        }
        int[] tempArray = new int[k];
        for (int i = 0; i < nums.length - k + 1; i++) {

            if (i == 0) {

                for (int j = 0; j < k; j++) {
                    tempArray[j] = nums[i + j];
                }
                Arrays.sort(tempArray);
            } else {

                int index = binarySearch(nums[i-1], tempArray);
                System.out.println(index);
                tempArray[index] = nums[i+k-1];
                for (int m = 0; m < tempArray.length; m++) {
                    if (tempArray[index] > tempArray[m]) {
                        int temp = tempArray[index];
                        tempArray[index] = tempArray[m];
                        tempArray[m] = temp;
                    }
                }
            }

            for (Integer integer : tempArray) {
                System.out.print(integer + " ");
            }
            System.out.println("...");

            if (k%2 ==0) {
                result.add(tempArray[k/2 -1]);
            } else {
                result.add(tempArray[k/2]);
            }
        }

        return result;
    }

    public int binarySearch(int target, int[] array){
        int low = 0;
        int hight = array.length -1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 2);
            if (array[mid] < target) {
                low = mid +1;
            } else if (array[mid] > target) {
                hight = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public DoublyListNode bstToDoublyList(TreeNode root) {

        List<DoublyListNode> nodes = new ArrayList<>();
        pack(root, nodes);
        if (nodes.isEmpty()) {
            return null;
        }
        return nodes.get(0);
    }

    private void pack(TreeNode node, List<DoublyListNode> list) {
        if (node == null) {
            return;
        }
        pack(node.left, list);
        DoublyListNode doublyListNode = new DoublyListNode(node.val);
        if (!list.isEmpty()) {
            doublyListNode.prev = list.get(list.size()-1);
            list.get(list.size()-1).next = doublyListNode;
        }
        list.add(new DoublyListNode(node.val));
        pack(node.right, list);

    }

    private DoublyListNode getDoublyListNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        DoublyListNode doubleList = new DoublyListNode(node.val);
        getDoublyListNode(node.right).prev = doubleList;
        getDoublyListNode(node.left).next = doubleList;
        return doubleList;
    }


    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here


        getNum(root, 0, target,  new ArrayList<Integer>());

        return lists;
    }

    public int triangleCount(int[] S) {
        int result = 0;
        if (S.length < 3) {
            return result;
        }
        Arrays.sort(S);
        for (int i = 0; i < S.length -2; i++) {
            for (int m = i+1; m < S.length-1; m++) {

                int ab = S[i] + S[m];
                for (int j = m + 1; j < S.length; j++) {
                    if (ab > S[j]) {
                        result = result + 1;
                    }
                }
            }
        }

        return result;
    }

    private void getNum(TreeNode node, int nowNum, int target, ArrayList<Integer> list) {

        if (target == (nowNum + node.val) && node.right == null && node.left == null) {

            ArrayList<Integer> newList = new ArrayList<>();
            for (Integer i : list) {
                newList.add(i);
            }
            newList.add(node.val);
            lists.add(newList);
        }
        if (node.right != null) {
            ArrayList<Integer> newList = new ArrayList<>();
            for (Integer i : list) {
                newList.add(i);
            }
            newList.add(node.val);
            getNum(node.right, nowNum + node.val, target, newList);
        }
        if (node.left != null) {
            ArrayList<Integer> newList = new ArrayList<>();
            for (Integer i : list) {
                newList.add(i);
            }
            newList.add(node.val);
            getNum(node.left, nowNum + node.val, target, newList);
        }
    }
}