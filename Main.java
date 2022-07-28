//Git repo add
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    //commento di fra
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        boolean t = false;
        System.out.println("Inserisci il cognome: ");
        String cognome = sc.nextLine();
        System.out.println("Inserisci il nome: ");
        String nome = sc.nextLine();
        System.out.println("Inserisci il giorno di nascita(01,02,03,04,05,06,07,08,09,ecc...): ");
        String giornonascita = sc.nextLine();
        t = false;
        System.out.println("Inserisci il mese di nascita(INSERIRE IL NUMERO DEL MESE COMPRESO TRA 1 e 12): ");
        String mesenascita = sc.nextLine();

        System.out.println("Inserisci il anno di nascita: ");
        String annonascita = sc.nextLine();
        t = false;
        String M = "M";
        String m = "m";
        String F = "F";
        String f = "f";

        System.out.println("Inserisci il sesso: ");
        String sesso = sc.nextLine();
        while(t==true)
        {
            System.out.println("Inserisci il sesso: ");
            sesso = sc.nextLine();
            if(sesso.equals(M)||sesso.equals(m))
            {
                t = true;
            }
            else if(sesso.equals(F)||sesso.equals(f))
            {
                giornonascita=giornonascita+40;
                t = true;
            }
        }
        System.out.println("Inserisci il comune di nascita: ");
        String comune = sc.nextLine();
        /*Creazione dell'oggetto di tipo codice fiscale*/
        CodiceFiscale cf;
        //char[] controllo;
        /*Chiamata della funzione codice fiscale per l'acquisizione dei dati dal main*/
        cf=new CodiceFiscale(cognome,nome,giornonascita,mesenascita,annonascita,sesso,comune);
        /*Chiamata della funzione della classe codice fiscale per il calcolo del cognome*/
        String cfcogn=cf.Cognome(cognome);
        /*Chiamata della funzione della classe codice fiscale per il calcolo del nome*/
        String cfn=cf.Nome(nome);
        /*Chiamata della funzione della classe codice fiscale per l'asegnazione della lettera in base al mese di nascita*/
        String cfmese=cf.lettmese(mesenascita);
        /*Chiamata della funzione della classe codice fiscale per l'acquisizione degli ultimi due caratteri dell'anno*/
        String cfanno=cf.anno(annonascita);
        /*Chiamata della funzione della classe codice fiscale per l'acquisizione del codice del comune di nascita*/
        String cfcomune=cf.luogonascita();
        System.out.println("Cognome ricavato: "+cfcogn.toUpperCase());
        System.out.println("Nome ricavato: "+cfn.toUpperCase());
        System.out.println("Lettera mese ricavato: "+cfmese);
        System.out.println("Anno ricavato: "+cfanno);
        System.out.println("Sesso ricavato: "+sesso);
        System.out.println("Comune ricavato: "+cfcomune);
        String noccf = cfcogn.toUpperCase()+cfn.toUpperCase()+cfanno+cfmese+giornonascita+cfcomune;
        System.out.println("CF ricavato senza variabile di controllo: "+noccf);
        /*Chiamata della funzione della classe codice fiscale per l'acquisizione della variabile di controllo*/
        char cfc=cf.variabilecontrollo(noccf);
        System.out.println("Lettera: "+cfc);
        String lett=String.valueOf(cfc);
        String codicefiscale=noccf+lett;
        /*Visualizzazione del codice fiscale*/
        System.out.println("CODICE FISCALE: "+codicefiscale);
    }
}