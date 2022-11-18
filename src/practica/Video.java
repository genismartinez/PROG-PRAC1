package practica;

/**
 * File where the methods are located, you'll find the setters, getters,
 * constructor and several other methods used to calculate specific operations
 * required 4 the presentation of this work.
 * We've included the "Data" class to calculate the number of days
 * between one date and another and all the dates used in our program are with
 * the format "Data as well"
 * @author Carlos y Genis Martinez
 *
 */
public class Video {
	private String alias;
	private String titulo;
	private String tema;
	private Data fecha;
	private int daysElapsed;	/*dias que pasan desde la fecha actual
								/lo usaremos para calcular la media de visus/dia*/
	private int duracion;
	private int visus;
	private int saved;
	private int likes;
	private int lindar;	//será introducido por tecladon por el usuario
	float prop;		//proporción saved/visus
	

	
	/**
	 * Constructor que inicializa los valores a 0 si no se le pasa nada por parámetro
	 */
	public Video () {
		alias= new String();
		titulo=new String();
		tema=new String();
		//fecha=0;
		duracion=0;
		visus=0;
		saved=0;
		likes=0;
		lindar=50;
		prop=0;
	}
	
	/**
	 * Constructor por defecto
	 * @param alias alias del video
	 * @param titulo titulo que le damos al video
	 * @param tema tema que asignamos al video
	 * @param fecha fecha en formato Data que asignamos al video
	 * @param duracion duracion del video
	 */
	public Video (String alias,String titulo,String tema,
			Data fecha,int duracion) {
		//Quitar visus, saved y likes
		this.alias=alias;
		this.titulo=titulo;
		this.tema=tema;
		this.fecha=fecha;
		this.duracion=duracion;
		lindar=50;
		
	}
	
	/**
	 * Compara un objeto con otro que le pasamos
	 * como parametro y devuelve una copia del que
	 * dura mas
	 * @param v1 es el que le pasamos como parametro
	 * @return una copia del mas largo
	 */
	public Video copiaLonger(Video v1){
		if(this.duracion>v1.getDuracion()){
			return copia();
		}
		if(this.duracion<v1.getDuracion()){
			return v1.copia();
		}
		else
			return null;
	}
	
	/**
	 * Metodo que devuelve si un video esta bien valorado o no
	 * @return true si el calculo de la operacion es superior
	 * o igual al llindar predefinido (50%)
	 */
	public boolean goodRated() {
		if((((float)likes/(float)visus)*100.0)>=lindar) 
			return true;
		else
			return false;
	}
	
	/**
	 * Aumenta en x el num de visus del video
	 * @param x cantidad en la que incrementamos
	 */
	public void increaseVisus(int x) {
	if(x>0)	
		this.visus=this.visus+x;
	calculatePercentage();
	}
	
	/**
	 * Aumenta en x el num de veces que se ha guardado
	 * @param x cantidad en la que incrementamos
	 */
	public void increaseSaved(int x) {
		if(x>0)
			this.saved=this.saved+x;
		calculatePercentage();
	}
	
	 /**
	  * Aumenta en x el numero de likes si es positio el num
	  * @param x cantidad en la que incrementamos
	  */
	public void increaseLikes(int x) {
		if (x>0)
			this.likes=this.likes+x;
		
	}
	/**
	 * Procedimiento que hace una copia del vídeo que queramos,
	 * coge los valores con los getters y se los asigna al nuevo.
	 * @return Una copia del objeto sobre el que llamamos el metodo
	 */
	public Video copia() {
		Video aux=new Video(alias,titulo,tema,
				fecha,duracion);
		aux.setPercentage(this.prop);
		aux.increaseLikes(getLikes());
		aux.increaseSaved(getSaved());
		aux.increaseVisus(getVisus());
		return aux;
	}
	
	
	/**
	 * Procedimiento que dice si se guarda más veces que likes
	 * @return True si saved>likes
	 */
	public boolean util() {
		if(getSaved()>getLikes())
			return true;
		else
			return false;
	}
	
	/**
	 * Obtenemos prop saved/visus
	 * @return prop saved/visus
	 */
	public float getPercentage() {
		return this.prop;
	}
	/**
	 * Calculamos la proporcion saved/visus
	 * @return prop saved/visus
	 */
	public float calculatePercentage() {
		this.prop=((float)saved/(float)visus);
		return prop;
	}
	/**
	 * Cuando hacemos una copia de un video, usamos este metodo para 
	 * copiar tambien la proporcion de saved/visus
	 * @param percentage num que copiaremos a this.prop
	 */
	public void setPercentage(float percentage) {
		this.prop=percentage;
	}
	
	/**
	 * Devuelve true si el objeto sobre el que llamamos al metodo
	 * se ha guardado mas veces que el que le pasamos como parametro
	 * @param v1 video con el que lo compararemos
	 * @return true si this.saved>v1.getSaved()
	 */
	public boolean moreSaved(Video v1) {
		if(this.saved>v1.getSaved())
			return true;
		else
			return false;
	}
	
	/**
	 * Obtiene el alias del video
	 * @return devuelve en formato string el alias del video
	 */
	public String getAlias() {
		return this.alias;
	}
	
	/**
	 * Obtiene la duracion del video
	 * @return num en segundos de la duracion de un video
	 */
	public int getDuracion() {
		return this.duracion;
	}
	
	/**
	 * Obtiene el titulo del video
	 * @return El titulo del video
	 */
	public String getTitulo() {
		return titulo;
	}
	

	/**
	 * Obtenemos el tema del video
	 * @return El tema del video
	 */
	public String getTema() {
		return tema;
	}
	
	/**
	 * Establecemos un tema
	 * @param tema pasamos como string el tema del video
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	/**
	 * Obtiene la fecha actual
	 * @return La fecha en formato 'Data'
	 */
	public Data getFecha() {
		return fecha;
	}
	/**
	 * Nos calcula el numero de dias que han pasado desde que se publico el video
	 * @param diaActual fecha en la que nos encontramos
	 * @return dias que han pasado desde publicación del video
	 */
	public int daysElapsed(Data diaActual) {
		daysElapsed=0;
		daysElapsed=fecha.numDiesAData(diaActual);
		return daysElapsed;
	}
	
	/**
	 * Cálculo de la media de Visualizaciones teniendo en cuenta hace cuantos dias
	 * se ha publicado del video
	 * @param DiaActual pasamos en Formado 'Data' el dia en que nos encontramos
	 * @return media de visus teniendo en cuenta dias pasados desde publicacion del video
	 */
	public float mitjanavisus(Data DiaActual) {
		float contador;
		
		if(daysElapsed(DiaActual)<=0)
			return -1;
		else {
			contador=(float)visus/(float)daysElapsed;
		}
		return contador;
	}
	/**
	 * Obtenim el num de visualizaciones
	 * @return la cantidad de visualizaciones
	 */
	public int getVisus() {
		return visus;
	}

	
	/**
	 * Obtiene cuantas veces se ha guardado
	 * @return num de veces guardado
	 */
	public int getSaved() {
		return saved;
	}

	
	/**
	 * Obtiene cuantas veces se ha dado like al video
	 * @return num de likes que tiene
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * Obtenemos el valor del Lindar
	 * @return el valor del lindar
	 */
	public int getLindar() {
		return this.lindar;
	}
	/**
	 * Establece el rango que determina si un video esta bien valorado
	 * o no
	 * @param lindar es el numero que obtenemos del usuario por teclado
	 */
	public void setLindar(int lindar) {
		this.lindar = lindar;
	}
@Override
public String toString() {
	return "Alias=" + alias + "\nTitulo= " + titulo + "\nTema= " + tema + "\nFecha= " + fecha + "\nDuracion= "
			+ duracion + "\nVisus= " + visus + "\nLikes= " + likes + "\nSaved= " + saved+"\nProp "
					+ "guardados/visus= "+prop;
}
	
}