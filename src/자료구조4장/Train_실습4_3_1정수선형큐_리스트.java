package 자료구조4장;
/*
 * 실습 4_4번 - 정수 선형 큐를 리스트로 구현
 * 교재 148 페이지는 원형큐를 배열로 구현한 코드 실습 4번에 활용
 */

/*
* Queue of ArrayList
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Queue4 {
	private List<Integer> que;//원형큐로 구현하지 않는다 
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; //front값과 rear값이 같을때 큐가 아예 빈건지, 아예 가득 찬건지를 구별하게 만드는 변수
	
	public Queue4(List<Integer> que, int capacity, int front, int rear, int num) {
		this.que = que;
		this.capacity = capacity;
		this.front = front;
		this.rear = rear;
		this.num = num;
	}
	
	public List<Integer> getQue() {
		return que;
	}

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
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException(String message) {
			super(message);
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException(String message) {
			super(message);
		}
	}

//--- 생성자(constructor) ---//
	public Queue4(int maxlen) {
		num = front = rear = 0; 
		capacity = maxlen;
		que = new ArrayList<>(); 
	}

//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowQueueException {
		if (num >= capacity) {
			throw new OverflowQueueException("가득 찼습니다.");
		}
		que.add(x);
		rear++;
		num++;
		if (rear==capacity) {
			rear=0;
		}
		return x;
	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyQueueException {
		if (num<= 0) {
			throw new EmptyQueueException("비어 있습니다.");
		}
		int x = que.remove(front);
		if (front == capacity -1) {
			front = 0;
		} else {
			front++; //1개를 뺏으니 남아있는 front자리는 하나 더 뒤임
		}
		num--;//1개를 뺐으니 1개 줄어듬
		return x; 
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("비어 있습니다.");
		}
		return que.get(front);//List이므로 que[front]를 쓰지 않음.
	}

//--- 큐를 비움 ---//
	public void clear() {
		num = front = rear = 0;
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
//		return que.indexOf(x);
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que.get(idx)==x) {
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
		return num;
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if (num <=0) {
			System.out.println("큐가 비어 있습니다.");
		} else {
			for (int i=0; i < num ; i++) {
				System.out.println(que.get((i+front)%capacity) + " ");
				System.out.println();
			}
		}
	}
}
public class Train_실습4_3_1정수선형큐_리스트 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Queue4 oq = new Queue4(64); // 최대 64개를 인큐할 수 있는 큐
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
				} catch(Queue4.OverflowQueueException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (Queue4.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (Queue4.EmptyQueueException e) {
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