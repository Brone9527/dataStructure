package recursion;
/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/17 11:00
 */


 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      //链表节点的构造函数，使用arr为参数，创建一个链表，当前的ListNode为链表接口
    public ListNode(int[] arr){
          if (arr == null || arr.length == 0 )
              throw  new IllegalArgumentException("arr can not be empty");
          this.val = arr[0];
          ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    //以当前接口为头节点的链表信息字符
    @Override
    public String toString(){
          StringBuilder s  = new StringBuilder();
          ListNode cur = this;
          while (cur != null){
              s.append(cur.val + "->");
              cur = cur.next;
          }
          s.append("NULL");
          return s.toString();
    }

  }
