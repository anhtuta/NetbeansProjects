/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import basic_data_structures.StackListGeneric;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class HTMLTagCheck {
    public static void checkTag(String str) {
        StackListGeneric<String> st = new StackListGeneric<>();
        StringTokenizer token = new StringTokenizer(str);
        while(token.hasMoreTokens()) {
            String element = token.nextToken();
            
            if(element.contains("</")) {  //nếu gặp dấu đóng tag, các trường hợp của element có thể là: vidu</p>, </p>, <p>vidu</p>
                if(element.startsWith("<") && element.endsWith(">") && !element.startsWith("</")) { //trường hợp <p>vidu</p>: do nothing
                    System.out.println(element) ;
                }
                else if(!st.isEmpty()) {
                    st.pop();
                } else {
                    System.out.println("Error at...: there's a redundant tag"); 
                    System.out.println(element);
                    return;
                }
            } else if(element.startsWith("<")) { //nếu là dấu mở tag thì đưa 1 dấu < vào stack, thực ra đưa cái j vào cũng đc, khi pop mà thấy stack rỗng thì chứng tỏ file thiếu tag
                if(!element.contains("</")) st.push("<"); //ví dụ gặp tag này: <p>This_is_a_table</p> thì rõ ràng element là cả cục ý, và nó có cả thẻ đóng rồi nên ko pop vào nữa
            } else if(element.endsWith("/>")) {
                if(!st.isEmpty()) st.pop();
                else {
                    System.out.println("Error at...: there's a redundant tag");
                    System.out.println(element);
                    return;
                }
                
            }
        }
        if(st.isEmpty()) System.out.println("There's no error");
        else {
            System.out.println("There's some mistakes: missing a/some tag(s) at the end");
            System.out.println("stack = ");
            st.printStack();
        }
    }
    
    public static void main(String[] args) {
        File f = new File("sample.html");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String line = null;
            StringBuilder strBuider = new StringBuilder();
            while((line = br.readLine()) != null) { 
                //System.out.println(line);  //in ra từng dòng của file. line là dữ liệu trên từng dòng
                strBuider.append(line);
                strBuider.append("\n");
            }
            
            br.close();
            fr.close();
            
            String str = strBuider.toString();
            
            HTMLTagCheck.checkTag(str);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HTMLTagCheck.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HTMLTagCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
