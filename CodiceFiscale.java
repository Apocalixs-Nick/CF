import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodiceFiscale
{
    private String cognome;
    private String nome;
    private String giornonascita;
    private String mesenascita;
    private String annonascita;
    private String sesso;
    private String comune;
    private String codiceFiscale;
    private String data;
    private String com;
    private String ncf;
    private String lettmes;
    /*Acquisizione dei valori inseriti nel main.java*/
    public CodiceFiscale(String cognome, String nome, String giornonascita, String mesenascita, String annonascita, String sesso, String comune)
    {
        this.cognome = cognome;
        this.nome = nome;
        this.giornonascita = giornonascita;
        this.mesenascita = mesenascita;
        this.annonascita = annonascita;
        this.sesso = sesso;
        this.comune = comune;
    }
    
    /*Calcolo del cognome inserito nel main.java*/
    public String Cognome(String cognome)
    {
        char[] vowels = {'a','e', 'i', 'o', 'u','A','E', 'I', 'O', 'U'};
        char[] ch = cognome.toCharArray();
        int numCons = 0;
        int numVoc = 0;
        String CFcognome = "";
        boolean vocale = false;
        for(int i=0;i<cognome.length();i++)
        {
            if(numCons==3) break;
            for(int j=0;j<vowels.length;j++)
            {
                if(ch[i]==vowels[j])
                {
                    vocale = true;
                    break;
                }
            }
            if(vocale) vocale=false;
            else
            {
                numCons++;
                CFcognome=CFcognome+ch[i];
            }
        }
        if(numCons<3)
        {
            for(int i=0;i<cognome.length();i++)
            {
                if((numCons+numVoc)==3) break;
                for(int j=0;j<vowels.length;j++)
                {
                    if(ch[i]==vowels[j])
                    {
                        vocale = true;
                        break;
                    }
                }
                if(vocale) vocale=false;
                else
                {
                    numCons++;
                    CFcognome=CFcognome+ch[i];
                }
            }
        }
        return CFcognome;
    }

    /*Calcolo del nome inserito nel main.java*/
    public String Nome(String Nome)
    {
        char[] vowels = {'a','e', 'i', 'o', 'u','A','E', 'I', 'O', 'U'};
        char[] ch = nome.toCharArray();
        int numCons = 0;
        int numVoc = 0;
        String CFnome = "";
        boolean vocale = false;
        for(int i=0;i<nome.length();i++)
        {
            if(numCons==3) break;
            for(int j=0;j<vowels.length;j++)
            {
                if(ch[i]==vowels[j])
                {
                    vocale = true;
                    break;
                }
            }
            if(vocale) vocale=false;
            else
            {
                numCons++;
                CFnome=CFnome+ch[i];
            }
        }
        if(numCons<3)
        {
            for(int i=0;i<nome.length();i++)
            {
                if((numCons+numVoc)==3) break;
                for(int j=0;j<vowels.length;j++)
                {
                    if(ch[i]==vowels[j])
                    {
                        vocale = true;
                        break;
                    }
                }
                if(vocale) vocale=false;
                else
                {
                    numCons++;
                    CFnome=CFnome+ch[i];
                }
            }
        }
        return CFnome;
    }

    /*Funzione per l'associazione del mese al suo carattere*/
    public String lettmese(String mesenascita)
    {
            if(mesenascita.equals("1"))
            {
                lettmes="A";
            }
            else if(mesenascita.equals("2"))
            {
                lettmes="B";
            }
            else if(mesenascita.equals("3"))
            {
                lettmes="C";
            }
            else if(mesenascita.equals("4"))
            {
                lettmes="D";
            }
            else if(mesenascita.equals("5"))
            {
                lettmes="E";
            }
            else if(mesenascita.equals("6"))
            {
                lettmes="H";
            }
            else if(mesenascita.equals("7"))
            {
                lettmes="L";
            }
            else if(mesenascita.equals("8"))
            {
                lettmes="M";
            }
            else if(mesenascita.equals("9"))
            {
                lettmes="P";
            }
            else if(mesenascita.equals("10"))
            {
                lettmes="R";
            }
            else if(mesenascita.equals("11"))
            {
                lettmes="S";
            }
            else if(mesenascita.equals("12"))
            {
                lettmes="T";
            }
        return lettmes;
    }

    /*Funzione per ricavare gli ultimi caratteri dell'anno di nascita*/
    public String anno(String annonascita)
    {
        com=annonascita.substring(2, 4);
        return com;
    }

    /*Funzione per l'associazione del codice el comune di nascita*/
    public String luogonascita() throws IOException 
    {
        List<String> risultati_matchati = new ArrayList<String>();
        String linea_matchata = null;
        List<String> lines = Files.readAllLines(Paths.get("CF/comuni.txt"));
        for (String line : lines)
        {
            if (line.contains(this.comune.toUpperCase()))
            {
                risultati_matchati.add(line);
            }
        }
        for (int i = 0; i < risultati_matchati.size(); i++) 
        {
            System.out.println((i + 1) + ")" + risultati_matchati.get(i));
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Quale di questi comuni intendi?: ");
        int scelta = input.nextInt();
        linea_matchata = risultati_matchati.get(scelta - 1);
        int size = linea_matchata.length();
        String codice_comune = linea_matchata.substring(size - 4);
        return codice_comune;
    }
    
    /*Funzione per il calcolo della variabile di controllo*/
    public String variabilecontrollo(String ncf)
    {
        
        return ncf;
    }
    /* 
    public char controllo_cod(String ncf)
    {
        char[] tot = ncf.toCharArray();
        HashMap<Character, Integer> codiciDisp = new HashMap<Character, Integer>();
        codiciDisp.put('0', 1);
        codiciDisp.put('1', 0);
        codiciDisp.put('2', 5);
        codiciDisp.put('3', 7);
        codiciDisp.put('4', 9);
        codiciDisp.put('5', 13);
        codiciDisp.put('6', 15);
        codiciDisp.put('7', 17);
        codiciDisp.put('8', 19);
        codiciDisp.put('9', 21);
        codiciDisp.put('A', 1);
        codiciDisp.put('B', 0);
        codiciDisp.put('C', 5);
        codiciDisp.put('D', 7);
        codiciDisp.put('E', 9);
        codiciDisp.put('F', 13);
        codiciDisp.put('G', 15);
        codiciDisp.put('H', 17);
        codiciDisp.put('I', 19);
        codiciDisp.put('J', 21);
        codiciDisp.put('K', 2);
        codiciDisp.put('L', 4);
        codiciDisp.put('M', 18);
        codiciDisp.put('N', 20);
        codiciDisp.put('O', 11);
        codiciDisp.put('P', 3);
        codiciDisp.put('Q', 6);
        codiciDisp.put('R', 8);
        codiciDisp.put('S', 12);
        codiciDisp.put('T', 14);
        codiciDisp.put('U', 16);
        codiciDisp.put('V', 10);
        codiciDisp.put('W', 22);
        codiciDisp.put('X', 25);
        codiciDisp.put('Y', 24);
        codiciDisp.put('Z', 23);

        HashMap<Character, Integer> codiciPar = new HashMap<Character, Integer>();
        codiciPar.put('0', 1);
        codiciPar.put('1', 0);
        codiciPar.put('2', 5);
        codiciPar.put('3', 7);
        codiciPar.put('4', 9);
        codiciPar.put('5', 13);
        codiciPar.put('6', 15);
        codiciPar.put('7', 17);
        codiciPar.put('8', 19);
        codiciPar.put('9', 21);
        codiciPar.put('A', 1);
        codiciPar.put('B', 0);
        codiciPar.put('C', 5);
        codiciPar.put('D', 7);
        codiciPar.put('E', 9);
        codiciPar.put('F', 13);
        codiciPar.put('G', 15);
        codiciPar.put('H', 17);
        codiciPar.put('I', 19);
        codiciPar.put('J', 21);
        codiciPar.put('K', 2);
        codiciPar.put('L', 4);
        codiciPar.put('M', 18);
        codiciPar.put('N', 20);
        codiciPar.put('O', 11);
        codiciPar.put('P', 3);
        codiciPar.put('Q', 6);
        codiciPar.put('R', 8);
        codiciPar.put('S', 12);
        codiciPar.put('T', 14);
        codiciPar.put('U', 16);
        codiciPar.put('V', 10);
        codiciPar.put('W', 22);
        codiciPar.put('X', 25);
        codiciPar.put('Y', 24);
        codiciPar.put('Z', 23);
        
        int ind = 0;
        int [] numeri = new int [16];
        for (char i : codiciDisp.keySet())
        {
            if(totA[ind] == i)
            {
                numeri[ind] = codiciDisp.get(i);
                ind = ind+2;
            }
        }

        ind = 1;
        for (char i : codiciDisp.keySet())
        {
            if(totA[ind] == i)
            {
                numeri[ind] = codiciDisp.get(i);
                ind = ind+2;
            }
        }
        return this.controllo;
    };*/
}