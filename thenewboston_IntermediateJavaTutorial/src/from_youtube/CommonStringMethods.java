/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

public class CommonStringMethods {

    public static void main(String[] args) {
        String[] words = {"funk", "chunk", "banana", "bank"};
        for (String w : words) {
            if (w.startsWith("fu")) {
                System.out.println(w + " starts with fu");
            }
        }

        for (String v : words) {
            if (v.endsWith("unk")) {
                System.out.println(v + " ends with unk");
            }
        }
        System.out.println();

        String s = "taanhtudhbkhn_nickname is tu toc xu";
        System.out.println(s.indexOf("n"));
        System.out.println(s.indexOf("n", 5)); //bỏ qua 6 ký đầu tiên từ 0-5 rồi mới bắt đầu tìm kiếm
        System.out.println(s.indexOf("x"));  //kq: -1
        System.out.println(s.indexOf("tu"));
        System.out.println(s.indexOf("tu", 7));
        System.out.println();

        String a = "anhtu";
        String b = " dtvt shit";
        System.out.println(a + b);
        System.out.println(a.concat(b));
        System.out.println(a.replace("a", "A"));
        System.out.println(b.toUpperCase().trim());
    }

}
