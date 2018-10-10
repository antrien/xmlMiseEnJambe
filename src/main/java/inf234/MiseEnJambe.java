package inf234;

import java.io.*;

/**
 * Classe mise en jambe dont le but est d'illustrer la définition de jeux de tests en JUnit.
 */
public class MiseEnJambe {
    public String texte;

    public MiseEnJambe(String texte) {
        this.texte = texte;
    }

    public MiseEnJambe(File f) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        this.texte = fileData.toString();
    }

    /**
     * Vrai ssi texte contient la sous chaîne s.
     * @param s la sous chaîne à rechercher.
     * @return
     */
    public boolean contient(String s) {
        return false;
    }

    /**
     * Vrai ssi texte contient la balise de nom b.
     * Rappel, on devra prendre en compte les cas simples (ex :"<b>") et les cas complexes
     * (ex: "<b attr="..."> 
     * @param b le nom de la balise à rechercher.
     * @return
     */
    public boolean contientBalise(String b) {
        return false;
    }

    /**
     * Vrai ssi texte contient le contenu c (en ignorant les éléments contenus à l'intérieur d'une balise).
     * (ex: texte = "<a>b</a>" contient le contenu b, mais pas le contenu a).
     * @param c le contenu à rechercher.
     * @return contenance de c dans le texte
     */
    public boolean contientContenu(String c) {
        String container = ""; //Variable de stockage avec remise a zero a chaque passage sur balise
        boolean isIn = false; //Varbiable de verification d'appartennance
        for(int i=0; i < this.texte.length(); i++){ //Schema de parcours du texte
            if(this.texte.charAt(i) != '<'){  //Supression des balises et reset de la variable container
                while(this.texte.charAt(i) != '>'){
                    container = "";
                    i++;
                }
            }

            container += this.texte.charAt(i);

            if (stringContient(container,c)){ //Verification de l'apartenance du contenu c au container
                isIn = true; 
                i = this.texte.length();
            }

            i++;
        }
        return isIn;
    }

    /**
     * Renvoie une version sans commentaire XML de texte.
     * @return
     */
    public String sansCommentaire() {
        return null;
    }

    /**
     * Renvoie une version de texte où toutes les données contenues à l'intérieur d'une balise b on été supprimées.
     * ex: texte = "<a>x<b></b>z</a>" : filtere("b") renvoie "<a>xz</a>"
     * @return
     */
    public String filtrer(String b) {
        return null;
    }

}
