/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author AnhTu
 */
public class Unmodifiable_List {

    public static void main(String[] argv) throws Exception {
        List stuff = Arrays.asList(new String[]{"a", "b"});
        List list = new ArrayList(stuff);
        list = Collections.unmodifiableList(list);
        try {
            list.set(0, "new value");
        } catch (UnsupportedOperationException e) {
            System.out.println("Can't modify this list anymore");
        }
        Set set = new HashSet(stuff);
        set = Collections.unmodifiableSet(set);
        Map map = new HashMap();
        map = Collections.unmodifiableMap(map);
        System.out.println("Collection is read-only now.");
        
    }
}
