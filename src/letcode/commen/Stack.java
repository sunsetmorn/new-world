package letcode.commen;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    List<Integer> list = new ArrayList<Integer>();
    int index = 0;

    //ÈëÕ»
    public void push(int n){
        list.add(n);
        index++;
    }

    //³öÕ»
    public int pop(){
        if(!list.isEmpty()){
            index--;
            return list.remove(index);
        }
        return -1;
    }

}
