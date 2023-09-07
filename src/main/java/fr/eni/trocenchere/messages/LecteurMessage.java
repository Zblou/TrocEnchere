package fr.eni.trocenchere.messages;

import java.util.ResourceBundle;

public class LecteurMessage {

	private static ResourceBundle rb = null;
	
	//recupère le fichier qui contient les messages d'erreur
	static {
		rb = ResourceBundle.getBundle("fr.eni.trocenchere.messages.messages_erreur");
	}
	
	
	/**
	 * Renvoie une message d'erreur en fonction de son code.
	 * @param code Le code d'erreur.
	 * @return Le message correspondant.
	 */
	
	public static String getMessagesErreur(int code) {
		String message = "";
		
		try {
			if(rb != null) {
				message = rb.getString(String.valueOf(code));
			} else {
				message = "Erreur lors de la lecture du fichier messages_erreur";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Erreur inconnue";
		}
		
		return message;
	}
	
	
	
}
