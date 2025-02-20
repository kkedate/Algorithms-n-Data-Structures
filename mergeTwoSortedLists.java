package lab1;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
public class mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Количество элементов в 1 списке: ");
        int num1 = scanner.nextInt();
        int[] arr1 = new int[num1];
        System.out.println("Элементы 1 списка: ");
        for (int i = 0; i < num1; i++) {
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Количество элементов во 2 списке: ");
        int num2 = scanner.nextInt();
        int[] arr2 = new int[num2];
        System.out.println("Элементы 2 списка: ");
        for (int i = 0; i < num2; i++) {
            arr2[i] = scanner.nextInt();
        }
        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);

        mergeTwoSortedLists mergeTwoSortedLists = new mergeTwoSortedLists();
        ListNode mergedList = mergeTwoSortedLists.mergeTwoLists(list1, list2);

        printList(mergedList);
        scanner.close();
    }
}
