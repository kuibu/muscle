package jacoTools.java;

import java.util.*;

/**
 * Created by Jaco on 15-11-15.
 */
public class CollectionTools {
    // distinctList  去除list中的重复元素，并保证其原有顺序。
    public  static <T> List<T> distinctList(List<T> list){

        Iterator<T> it = list.iterator();
        Set<T> set = new HashSet<T>();
        while (it.hasNext()){
            T elem = it.next();
            if(set.contains(elem)) it.remove();   // 必须调用迭代器中的remove  不能使用 list.remove(elem)  否则报错：ConcurrentModificationException
            else set.add(elem);
        }
        return list;

    }
}
