/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textpreprocessing;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author oddy
 */
public class TextPreprocessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String kalimat1 = "I love the movie";
        String kalimat2 = "I hated the movie";
        String kalimat3 = "a great movie good movie";
        String kalimat4 = "poor acting";
        String kalimat5 = "great acting a good movie";

        String kalimat = kalimat1 + " " + kalimat2 + " " + kalimat3 + " " + kalimat4 + " " + kalimat5;

        System.out.println(kalimat);

        StringTokenizer st = new StringTokenizer(kalimat);

        List<String> listKata = new ArrayList<String>();
        int[] frekuensi = new int[st.countTokens()];
        List<String> listKataSemua = new ArrayList<String>();

        while (st.hasMoreTokens()) {
            String s = st.nextToken().toLowerCase();
            listKataSemua.add(s);
        }

        int isVisited = -1;

        for (int i = 0; i < listKataSemua.size(); i++) {

            String s = listKataSemua.get(i);
            int counter = 1;

            for (int j = i + 1; j < listKataSemua.size(); j++) {
                String s2 = listKataSemua.get(j);

                if (s.equals(s2)) {
                    counter++;
                    frekuensi[j] = isVisited;
                }
            }

            if (frekuensi[i] != isVisited) {
                frekuensi[i] = counter;
            }

        }

        int num = 0;
        for (int i = 0; i < frekuensi.length; i++) {
            if (frekuensi[i] != isVisited) {
                num++;
                System.out.println(num + ": " + listKataSemua.get(i) + " : " + frekuensi[i]);
            }
        }
    }

}
