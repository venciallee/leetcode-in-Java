leetcode-in-Java
=====

This is leetcode solution in Java with eplaination and generalization.

## LinkedList

| # | Title | Solution | Difficulty | Source Code |
|---| ----- | -------- | ---------- | ----------- |
| 2 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | math | Medium | [AddTwoNums.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/AddTwoNums.java) |
| 19 | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) |  | Medium | [RemoveNthNode.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/RemoveNthNode.java) |
| 21 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | loop and sort node | easy | [MergeTwoSortedLists.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/MergeTwoSortedLists.java) |
| 23 | [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | Divide and Conquer + mergeTwoSortedLists | Hard | [MergekSortedLists.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/MergekSortedLists.java) |
| 24 | [Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/) | recursive + swap node  | Medium | [SwapNodesInPairs.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/SwapNodesInPairs.java) |
| 61 | [Rotate List](https://leetcode.com/problems/rotate-list/) | connect tail and head & cut the right k places node  | Medium | [RotateList.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/RotateList.java) |
| 82 | [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) | find duplicate node and store duplicate state, update next pointer | Medium | [RemoveDuplicatesFromSortedListII.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/RemoveDuplicatesFromSortedListII.java) |
| 83 | [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) | find duplicate node and update pointer next to next.next | Medium | [RemoveDuplicatesFromSortedList.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/RemoveDuplicatesFromSortedList.java) |
| 86 | [Partition List](https://leetcode.com/problems/partition-list/) | Two Pointer | Medium | [PartitionList.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/PartitionList.java) |
| 92 | [Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/) | like Insertion Sort | Medium | [ReverseLinkedListII.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/ReverseLinkedListII.java) |
| 109 | [Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/) | pre-order traversal | Medium | [ConvertSortedListtoBST.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/ConvertSortedListtoBST.java) |
| 138 | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/) | recursive + hashmap | Medium | [CopyListwithRandomPointer.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/CopyListwithRandomPointer.java) |
| 141 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | two pointer | Easy | [LinkedListCycle.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/LinkedListCycle.java) |
| 142 | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | hashset | two pointer | Medium | [LinkedListCycleII.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/LinkedListCycleII.java) |
| 143 | [Reorder List](https://leetcode.com/problems/reorder-list/) | reverse + connect | Medium | [ReorderList.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/ReorderList.java) |
| 147 | [Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/) | insertion algorithm | Medium | [InsertionSortList.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/InsertionSortList.java) |
| 148 | [Sort List](https://leetcode.com/problems/sort-list/) | two pointer + merge sort algorithm | Medium | [SortList.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/linkedlist/SortList.java) |

## Design

| # | Title | Solution | Difficulty | Source Code |
|---| ----- | -------- | ---------- | ----------- |
| 146 | [LRU Cache](https://leetcode.com/problems/binary-search-tree-iterator/) | HashMap + Double LinkedNode  | Medium | [LRUCache.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/design/LRUCache.java) |
| 155 | [Min Stack](https://leetcode.com/problems/min-stack/) | Single LinkedNode or Stack(Java API)  | easy | [MinStack.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/design/MinStack.java) |
| 173 | [Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/) |  stack + preorder traversal | Medium | [BinarySearchTreeIterator.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/design/BinarySearchTreeIterator.java) |
| 208 | [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/) |  array | Medium | [ImplementTrie.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/design/ImplementTrie.java) |
| 211 | [Add and Search Word - Data structure design](https://leetcode.com/problems/add-and-search-word-data-structure-design/) |  | Medium | [AddAndSearchWord.java](https://github.com/venciallee/leetcode-in-Java/blob/master/algorithm/app/src/main/java/com/bytecode/leetcode/design/AddAndSearchWord.java) |
