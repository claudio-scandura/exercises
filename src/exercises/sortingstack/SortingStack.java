package exercises.sortingstack;

import java.util.Stack;

/**
 * Created by cls on 08/03/15.
 */
public class SortingStack {

    public static  void sortStack(Stack<Integer> in) {
        Stack<Integer> aux = new Stack<>();
        for (int i = 1; i < in.size(); i++) {
            for (int j = 1; j <= i; j++) aux.push(in.pop());
            Integer top = in.pop();
            while (!aux.isEmpty() && aux.peek() > top) in.push(aux.pop());
            in.push(top);
            while (!aux.isEmpty()) in.push(aux.pop());
        }
    }
}
