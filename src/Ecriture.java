import java.io.*;

/**
 * La classe Ecriture, gérant l'écriture à l'écran ou dans un fichier
 */
public class Ecriture {
	/**
	 * Ouvrir un fichier
	 * @param String nomFichier  Nom du fichier à ouvrir
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
	 * @param OutputStream f  Flux du fichier à fermer
	 */
    public static void fermer(OutputStream f) {                                     
    	try {
    		f.close();
    	} catch (IOException e) {
    		Ecriture.erreur(e);
    	}
    }
    
    /**
	 * Gérer les erreurs liées à l'ouverture, à l'écriture et à la fermeture de fichiers
	 * @param IOException e  Exception déclenchée par l'erreur
	 */
	private static void erreur(IOException e) {
        System.out.println(e.getMessage());
        System.out.println("Erreur fatale");
        System.exit(1);
    }
    
	
	/**
	 * Ecrire un caractère dans le flux
	 * @param OutputStream f  Flux d'entrée
	 * @param char c		  Caractère à écrire
	 */
    public static void ecrireChar(OutputStream f, char c) {
    	try {
    		f.write(c);
    	} catch(IOException e) {
    		Ecriture.erreur(e);
        }
    }
    
    /**
	 * Ecrire un caractère à l'écran
	 * @param char c  Caractère à écrire
	 */
    public static void ecrireChar(char c) {
    	Ecriture.ecrireChar(System.out, c);
    }
    
    
    /**
	 * Ecrire une chaine de caractères dans le flux (sans passage à la ligne)
	 * @param OutputStream f  Flux d'entrée
	 * @param String s		  Chaine de caractères à écrire
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
	 * Ecrire une chaine de caractères à l'écran (sans passage à la ligne)
	 * @param String s  Chaine de caractères à écrire
	 */
    public static void ecrireString(String s) {
    	Ecriture.ecrireString(System.out, s);
    }
    
    /**
	 * Ecrire une chaine de caractères dans le flux (avec passage à la ligne)
	 * @param OutputStream f  Flux d'entrée
	 * @param String s		  Chaine de caractères à écrire
	 */
    public static void ecrireStringln(OutputStream f, String s) {
    	Ecriture.ecrireString(f, s + "\r\n");
    }
    
    /**
	 * Ecrire une chaine de caractères à l'écran (avec passage à la ligne)
	 * @param String s  Chaine de caractères à écrire
	 */
    public static void ecrireStringln(String s) {
    	Ecriture.ecrireStringln(System.out, s);
    }
    
    
    /**
	 * Ecrire un entier dans le flux (sans formatage)
	 * @param OutputStream f  Flux d'entrée
	 * @param int x		  	  Entier à écrire
	 */
    public static void ecrireInt(OutputStream f, int x) {
    	Ecriture.ecrireString(f, Integer.toString(x));
    }
    
    /**
	 * Ecrire un entier à l'écran (sans formatage)
	 * @param int x  Entier à écrire
	 */
    public static void ecrireInt(int x) {
    	Ecriture.ecrireInt(System.out, x);
    }
    
    /**
	 * Ecrire un entier dans le flux (avec formatage)
	 * @param OutputStream f  Flux d'entrée
	 * @param int x		  	  Entier à écrire
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
	 * Ecrire un entier à l'écran (avec formatage)
	 * @param int x		  	  Entier à écrire
	 * @param int longueur	  Nombre de colonnes sur lequel on affiche l'entier
	 */
    public static void ecrireInt(int x, int longueur) {
    	Ecriture.ecrireInt(System.out, x, longueur);
    }
    
    
    /**
	 * Ecrire un réel dans le flux (sans formatage)
	 * @param OutputStream f  Flux d'entrée
	 * @param double d		  Réel à écrire
	 */
    public static void ecrireDouble(OutputStream f, double d) {
    	Ecriture.ecrireString(f, Double.toString(d));
    }
    
    /**
	 * Ecrire un réel à l'écran (sans formatage)
	 * @param double d  Réel à écrire
	 */
    public static void ecrireDouble(double d) {
    	Ecriture.ecrireDouble(System.out, d);
    }
    
    /**
	 * Ecrire un réel dans le flux (avec formatage)
	 * @param OutputStream f  Flux d'entrée
	 * @param double d		  Réel à écrire
	 * @param int longueur	  Nombre de colonnes sur lequel on affiche le réel
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
	 * Ecrire un réel à l'écran (avec formatage)
	 * @param double d		  Réel à écrire
	 * @param int longueur	  Nombre de colonnes sur lequel on affiche le réel
	 */
    public static void ecrireDouble(double d, int longueur) {
    	Ecriture.ecrireDouble(System.out, d, longueur);
    }
}