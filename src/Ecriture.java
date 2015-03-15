import java.io.*;

/**
 * La classe Ecriture, g�rant l'�criture � l'�cran ou dans un fichier
 */
public class Ecriture {
	/**
	 * Ouvrir un fichier
	 * @param String nomFichier  Nom du fichier � ouvrir
	 * @return OutputStream		 Flux du fichier ouvert
	 */
    public static OutputStream ouvrir(String nomFichier) {
    	OutputStream f;
    	
    	try {
    		f = new DataOutputStream(new FileOutputStream(nomFichier));
    	} catch (IOException e) {
    		f = null;
    	}
    	
    	return f;
    }
    
    /**
	 * Fermer un fichier
	 * @param OutputStream f  Flux du fichier � fermer
	 */
    public static void fermer(OutputStream f) {                                     
    	try {
    		f.close();
    	} catch (IOException e) {
    		Ecriture.erreur(e);
    	}
    }
    
    /**
	 * G�rer les erreurs li�es � l'ouverture, � l'�criture et � la fermeture de fichiers
	 * @param IOException e  Exception d�clench�e par l'erreur
	 */
	private static void erreur(IOException e) {
        System.out.println(e.getMessage());
        System.out.println("Erreur fatale");
        System.exit(1);
    }
    
	
	/**
	 * Ecrire un caract�re dans le flux
	 * @param OutputStream f  Flux d'entr�e
	 * @param char c		  Caract�re � �crire
	 */
    public static void ecrireChar(OutputStream f, char c) {
    	try {
    		f.write(c);
    	} catch(IOException e) {
    		Ecriture.erreur(e);
        }
    }
    
    /**
	 * Ecrire un caract�re � l'�cran
	 * @param char c  Caract�re � �crire
	 */
    public static void ecrireChar(char c) {
    	Ecriture.ecrireChar(System.out, c);
    }
    
    
    /**
	 * Ecrire une chaine de caract�res dans le flux (sans passage � la ligne)
	 * @param OutputStream f  Flux d'entr�e
	 * @param String s		  Chaine de caract�res � �crire
	 */
    public static void ecrireString(OutputStream f, String s) {
    	try {
    		for (int i = 0 ; i < s.length() ; i++) {
    			f.write(s.charAt(i));
    		}
    	} catch(IOException e) {
    		Ecriture.erreur(e);
        }
    }
    
    /**
	 * Ecrire une chaine de caract�res � l'�cran (sans passage � la ligne)
	 * @param String s  Chaine de caract�res � �crire
	 */
    public static void ecrireString(String s) {
    	Ecriture.ecrireString(System.out, s);
    }
    
    /**
	 * Ecrire une chaine de caract�res dans le flux (avec passage � la ligne)
	 * @param OutputStream f  Flux d'entr�e
	 * @param String s		  Chaine de caract�res � �crire
	 */
    public static void ecrireStringln(OutputStream f, String s) {
    	Ecriture.ecrireString(f, s + "\r\n");
    }
    
    /**
	 * Ecrire une chaine de caract�res � l'�cran (avec passage � la ligne)
	 * @param String s  Chaine de caract�res � �crire
	 */
    public static void ecrireStringln(String s) {
    	Ecriture.ecrireStringln(System.out, s);
    }
    
    
    /**
	 * Ecrire un entier dans le flux (sans formatage)
	 * @param OutputStream f  Flux d'entr�e
	 * @param int x		  	  Entier � �crire
	 */
    public static void ecrireInt(OutputStream f, int x) {
    	Ecriture.ecrireString(f, Integer.toString(x));
    }
    
    /**
	 * Ecrire un entier � l'�cran (sans formatage)
	 * @param int x  Entier � �crire
	 */
    public static void ecrireInt(int x) {
    	Ecriture.ecrireInt(System.out, x);
    }
    
    /**
	 * Ecrire un entier dans le flux (avec formatage)
	 * @param OutputStream f  Flux d'entr�e
	 * @param int x		  	  Entier � �crire
	 * @param int longueur	  Nombre de colonnes sur lequel on affiche l'entier
	 */
    public static void ecrireInt(OutputStream f, int x, int longueur) {
    	String s = Integer.toString(x);
    	int k = longueur - s.length();
    	
    	for (int i = 0 ; i < k ; i++) {
    		Ecriture.ecrireChar(f, ' ');
    	}
    	
    	Ecriture.ecrireString(f, s);
    }
    
    /**
	 * Ecrire un entier � l'�cran (avec formatage)
	 * @param int x		  	  Entier � �crire
	 * @param int longueur	  Nombre de colonnes sur lequel on affiche l'entier
	 */
    public static void ecrireInt(int x, int longueur) {
    	Ecriture.ecrireInt(System.out, x, longueur);
    }
    
    
    /**
	 * Ecrire un r�el dans le flux (sans formatage)
	 * @param OutputStream f  Flux d'entr�e
	 * @param double d		  R�el � �crire
	 */
    public static void ecrireDouble(OutputStream f, double d) {
    	Ecriture.ecrireString(f, Double.toString(d));
    }
    
    /**
	 * Ecrire un r�el � l'�cran (sans formatage)
	 * @param double d  R�el � �crire
	 */
    public static void ecrireDouble(double d) {
    	Ecriture.ecrireDouble(System.out, d);
    }
    
    /**
	 * Ecrire un r�el dans le flux (avec formatage)
	 * @param OutputStream f  Flux d'entr�e
	 * @param double d		  R�el � �crire
	 * @param int longueur	  Nombre de colonnes sur lequel on affiche le r�el
	 */
    public static void ecrireDouble(OutputStream f, double d, int longueur) {
    	String s = Double.toString(d);
    	int k = longueur - s.length();
    	
    	for (int i = 0 ; i < k ; i++) {
    		Ecriture.ecrireChar(f, ' ');
    	}
    	
    	Ecriture.ecrireString(f, s);
    }
    
    /**
	 * Ecrire un r�el � l'�cran (avec formatage)
	 * @param double d		  R�el � �crire
	 * @param int longueur	  Nombre de colonnes sur lequel on affiche le r�el
	 */
    public static void ecrireDouble(double d, int longueur) {
    	Ecriture.ecrireDouble(System.out, d, longueur);
    }
}