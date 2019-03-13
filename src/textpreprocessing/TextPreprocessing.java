/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textpreprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oddy
 */
public class TextPreprocessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();

        String kalimat = "";

        BufferedReader reader;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String fileName = listOfFiles[i].getName();
                if (fileName.startsWith("d")) {
                    try {
                        File f = new File(fileName);
                        reader = new BufferedReader(new FileReader(f));
                        
                        String line = reader.readLine();
                        while(line != null){
                            kalimat += " "+line;
                            line = reader.readLine();
                            
                        }
                        
                        reader.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(TextPreprocessing.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(TextPreprocessing.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }

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
