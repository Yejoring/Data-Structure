package linkedlist;
import java.util.Scanner;
public class Ex6_1 {
	final static int INSERT=1;
	final static int DELETE=2;
	final static int SEARCH=3;
	final static int REVERSE=4;
	final static int EXIT=0;
	public static void main(String args[]) {
		String x="";
		String value="";
		LinkedList l1=new LinkedList();
		Scanner sc=new Scanner(System.in);
		LinkedListMenu menu=new LinkedListMenu();
		boolean bIterate=true;
		while(bIterate) {
			menu.displayMenu();
			int select=sc.nextInt();
			switch(select){
			case INSERT:
				menu.displayInsertMenu();
				select=sc.nextInt();
				switch(select) {
				case 1:
					menu.displayValue();
					value=sc.next();
					l1.insertNodeFirst(value);
					l1.printList();
					break;
				case 2:
					menu.displayIndexAndValue();
					int index=sc.nextInt();
					value=sc.next();
					l1.insertNodebyIndex(index, value);
					l1.printList();
					break;
				case 3:
					menu.displayValue();
					value=sc.next();
					l1.insertNodeLast(value);
					l1.printList();
					break;
				case 0:
					System.out.println("상위메뉴료 돌아갑니다.");
					break;
				default:
					System.out.println("잘못된 번호를 입력하셨습니다. 상위메뉴료 돌아갑니다.");
					break;
					
				}
				break;
			case DELETE:
				menu.displayDeleteMenu();
				select=sc.nextInt();
				switch(select) {
				case 1:
					l1.deleteFirstNode();
					l1.printList();
					break;
				case 2:
					menu.displayValue();
					value=sc.next();
					l1.deleteNodeByValue(value);
					l1.printList();
					break;
				case 3:
					menu.displayIndex();
					int index=sc.nextInt();
					l1.deleteNodeByIndex(index);
					l1.printList();
					break;
				case 4:
					l1.deleteLastNode();
					l1.printList();
					break;
				default:
					System.out.println("잘못된 번호를 입력하셨습니다. 상위메뉴료 돌아갑니다.");
					break;
					
				
				}
				break;
			case SEARCH:
				menu.displayValue();
				value=sc.next();
				l1.searchNode(value);
				break;
			case REVERSE:
				
				break;
			case EXIT:
				System.out.println("Bye Bye~!");
				bIterate=false;
				break;
			default:
				System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
				break;
				
			}
			
		}
	}
}
