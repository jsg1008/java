package 자료구조4장;
/*
 * 실습 4_5번 - 정수 배열 원형 큐
 * 교재 148 ~ 157 페이지
 * 교재 소스 코드를 보지 않고 구현 완성 연습 필요 
 * /*
 * num 변수를 사용하지 않고 front == rear 일 때 queue가 full인지 empty 인지를 판단
 * 큐에서는 예외 클래스를 만드는 연습
 */
 
import java.util.Random;

/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */
import java.util.Scanner;

//int형 고정 길이 큐

class IntQueue3 {
	private int[] que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	boolean isEmptyTag;
	private int num; 
	//private int num; // 현재 데이터 개수>> 삭제한 후에 queue가 full, empty를 구분하는 실습
	//enque 하기전에 갯수를 세어 front==rear 조건을 체크한다
	//deque도 마찬가지임 
	
public int getFront() {
		return front;
	}

	public int getRear() {
		return rear;
	}

	public int getNum() {
		return num;
	}

	//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyIntQueue3Exception extends RuntimeException {
		public EmptyIntQueue3Exception() {
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowIntQueue3Exception extends RuntimeException {
		public OverflowIntQueue3Exception() {
		}
	}

//--- 생성자(constructor) ---//
	public IntQueue3(int maxlen) {
		capacity = maxlen;
		que = new int [capacity];
		num = front = rear = 0;
		isEmptyTag = true;
	}

//--- 큐에 데이터를 인큐 ---//
	public  void enque(int x) throws OverflowIntQueue3Exception {
		//push할때는 rear 쪽으로 간다
		if (isFull()) {
			throw new OverflowIntQueue3Exception();
		}
		que[rear] = x;
		rear = (rear+1)%capacity;
		num++;
		isEmptyTag = false;
	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntQueue3Exception {
		if (front == rear && isEmptyTag) {
			throw new EmptyIntQueue3Exception();
		}
		int result = que[front];
		front = (front+1)%capacity;
		num--;
		if (front==rear) {
			isEmptyTag=true;
		}
		return result;
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntQueue3Exception {
		if (isEmpty()) {
			throw new EmptyIntQueue3Exception();
		}
		return que[front];
	}

//--- 큐를 비움 ---//
	public void clear() {
		front = rear = 0;
		isEmptyTag = true;
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		for (int i = 0 ; i < num; i++) {
			int idx = (i + front)%capacity;
			if( que[idx]==x) {
				return idx;
			}
		}
		return -1;
	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		if (rear > front) {
			return rear - front;
		} else {
			return capacity - front + rear;
		}
	}

//--- 큐가 비어있는가? ---//
// 큐가 비어 있는지 판단: front == rear이면서 isEmptyTag == true일 때
	public boolean isEmpty() {
		return isEmptyTag && front == rear;
	}

//--- 큐가 가득 찼는가? ---//
// 큐가 가득 찼는지 판단: front == rear이면서 isEmptyTag == false일 때
	public boolean isFull() {
		return !isEmptyTag && front == rear;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if (num <= 0) {
			System.out.println("큐가 비었습니다.");
		} else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[(i+front)%capacity]+" ");
			}
		}
	}
	
}
public class Train_실습4_3_2정수원형큐_배열 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue3 oq = new IntQueue3(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx +")");
				try {
					oq.enque(rndx);
				} catch(자료구조4장.IntQueue3.OverflowIntQueue3Exception e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (자료구조4장.IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (자료구조4장.IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				oq.dump();
				break;
			default:
				break;
			}
		}
	}

}