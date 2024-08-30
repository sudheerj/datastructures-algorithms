package java1.algorithms.stack.sortStack;
import java.util.Arrays;
import java.util.Stack;

public class SortStack {
    private static void sortStack(Stack<Integer> stack) {
        if(stack.size() < 1) return;
        Stack<Integer> tempStack = new Stack<>();

        while(stack.size() >0){
            int temp = stack.pop();

            while(tempStack.size() > 0 && tempStack.peek() > temp)  {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);

        }

        stack.clear();
        stack.addAll(tempStack);
    }
    public static void main(String[] args) {
        Stack<Integer> myStack1 = new Stack<>();
        myStack1.push(8);
        myStack1.push(2);
        myStack1.push(4);
        myStack1.push(1);
        myStack1.push(5);
        myStack1.push(3);
    
        Stack<Integer> myStack2 = new Stack<>();
        myStack2.push(6);
        myStack2.push(5);
        myStack2.push(4);
        myStack2.push(3);
        myStack2.push(2);
        myStack2.push(1);
      
    
        System.out.println(Arrays.toString(myStack1.toArray())); 
        sortStack(myStack1);  
        System.out.println(Arrays.toString(myStack1.toArray())); 
    
        System.out.println(Arrays.toString(myStack2.toArray())); 
        sortStack(myStack2);  
        System.out.println(Arrays.toString(myStack2.toArray())); 
    }
}
