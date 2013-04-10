
public class StackWithSingleArray {
	int stacksize=100;
	int[] buffer=new int [stacksize*3];
	int[] pointer={0,0,0};
	void push(int stackNum, int value) throws Exception{
		if(pointer[stackNum]>=stacksize){
			throw new Exception("out of space");
		}
		int index=stackNum*stacksize+pointer[stackNum]+1;
		pointer[stackNum]++;
		buffer[index]=value;
	}
	int pop(int stackNum) throws Exception{
		if(pointer[stackNum]>=stacksize){
			throw new Exception("out of space");
		}
		int index=stackNum*stacksize+pointer[stackNum];
		pointer[stackNum]--;
		int value=buffer[index];
		buffer[index]=0;
		return value;
	}
	int peek(int stackNum){
		int index=stackNum*stacksize+pointer[stackNum];
		return buffer[index];
	}
	
}
