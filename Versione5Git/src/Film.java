
import it.unibs.ing.mylib.InputDati;

@SuppressWarnings("serial")
public class Film extends Risorsa {
	
	/**
	 * @invariant invariante()
	 */
	private String regista;
	private String casaProduzione;
	private String dataUscita; 
	private int durata;
	/**
	 * costruisce istanza di Film con i parametri immessi
	 * @param nome
	 * @param reg regista
	 * @param casaP casa produzione
	 * @param gen genere 
	 * @param lin lingua
	 * @param anno
	 * @param dur durata
	 * @param id
	 * @param numLicenze
	 */
	public Film(String nome,String reg,String casaP,String gen,String lin,int anno,int dur, int id,int numLicenze) {
		super(nome,gen,lin,anno,id,numLicenze);
		
		regista=reg;
		casaProduzione=casaP;
		durata=dur;	
		dataUscita="";
		
		assert invariante();
	}
	/**
	 * restituisce una stringa descrittiva della risorsa Film
	 * @pre true
	 * @post @nochange
	 * @return stringa descrittiva
	 */
	public String descrizionePrestito() {
		assert invariante();
		Film filmPre = this ;
		
		StringBuffer des = new StringBuffer();
		
		des.append(super.descrizionePrestito());		
		des.append("   regista: "+regista + "\n");
		des.append("   casa di produzione: "+casaProduzione + "\n") ;
		des.append("   durata: "+ durata + " min.\n" );
		
		assert invariante()&&filmPre==this;
		
		return des.toString();
	}
	/**
	 * verifica se la stringa data come parametro � contenuta nel nome del regista della risorsa	
	 * @param chiaveDiRicerca stringa da confrontare
	 * @pre chiaveDiRicerca != null
	 * @post @nochange
	 * @return true se la stringa � contenuta (no case sensitive)
	 */	
	public boolean matchRegista(String chiaveDiRicerca) {
		assert invariante() && chiaveDiRicerca!=null ;
		Film filmPre = this ;
		
		boolean match=false;
		if(regista.toLowerCase().contains(chiaveDiRicerca.toLowerCase()))match = true;
		
		assert invariante()&&filmPre==this;

		return match;
	}
	/**
	 * verifica se la stringa data come parametro � contenuta nel nome della casa di produzione della risorsa	
	 * @param chiaveDiRicerca stringa da confrontare
	 * @pre chiaveDiRicerca != null
	 * @post @nochange
	 * @return true se la stringa � contenuta (no case sensitive)
	 */	
	public boolean matchCasaProduzione(String chiaveDiRicerca) {
		assert invariante() && chiaveDiRicerca!=null ;
		Film filmPre = this ;
		
		boolean match = false;
		if(casaProduzione.toLowerCase().contains(chiaveDiRicerca.toLowerCase())) match = true;
		
		assert invariante()&&filmPre==this;

		return match;
	}
	/**
	 * verifica se l'intero dato come parametro � uguale alla durata in minuti del film	
	 * @param numDiRicerca intero da confrontare
	 * @pre numDiRicerca > 0
	 * @post @nochange
	 * @return true l'intero � uguale alla durata del film
	 */	
	public boolean matchDurata(int numDiRicerca) {
		assert invariante() && numDiRicerca > 0 ;
		Film filmPre = this ;
		
		boolean match = false ;
		if(durata==numDiRicerca) match = true;
		
		assert invariante()&&filmPre==this;

		return match;
	}
	/**
	 * chiede all'utente quali campi devono essere modificati ed esegue le modifiche chiedendo i nuovi valori
	 * @pre true
	 * @post true	
	 */	
	public void modifica() {
		assert invariante();
		
		super.modifica();
		
		String domanda = "vuoi modificare ";
		
		char modificaRegista = InputDati.leggiChar(domanda+"il regista ? (s/n)");
		
		if(modificaRegista=='s'||modificaRegista=='S') {

			String regNuovo= InputDati.leggiStringaNonVuota("inserisci il nuovo regista del film");
		  
			regista=regNuovo;

		}
		
		char modificaCasa = InputDati.leggiChar(domanda+"la casa di produzione ? (s/n)");
		
		if(modificaCasa=='s'||modificaCasa=='S') {

			String casaNuovo= InputDati.leggiStringaNonVuota("inserisci la nuova casa di produzione del film");
		
			casaProduzione=casaNuovo;

		}
		
		char modificaDurata = InputDati.leggiChar(domanda+"la durata del film ? (s/n)");
		
		if(modificaDurata=='s'||modificaDurata=='S') {

			int durataNuovo = InputDati.leggiInteroPositivo("inserisci la nuova durata in minuti del film");		
			durata=durataNuovo;
		}
		assert invariante();
	}
	/**
	 * verifica che le propriet� invarianti della classe Film siano rispettate
	 * @pre true
	 * @post @nochange
	 * @return true se gli attributi assumono valori validi && super.invariante()
	 */
	protected boolean invariante() {
		Film filmPre = this ;
		
		boolean invariante=false;
		if(super.invarianteR() && regista!=null && casaProduzione!=null && durata>0 && dataUscita!=null) invariante=true ;

		assert filmPre==this;
		
		return invariante;
	}
}
