package practica;
import java.time.LocalDate;
import java.util.Scanner;


public class Programa {
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	System.out.println("Bienvenido/a al programa: ");
    	
        Data fechaV1=new Data(10,9,2021);
        Video v1 = new Video("Alias01", "Importar un proyecto a Eclipse", "Lab01", fechaV1, 120);
        
        Data fechaV2=new Data(10,7,2021);
        Video v2 = new Video("Alias02", "Exportar un proyecto a Eclipse", "Lab02", fechaV2, 40);
        
        Data fechaV3=new Data(24,9,2021);
        Video v3 = new Video("Alias03", "Primeros pasos con el debug", "Lab03", fechaV3, 185);
        
        Data fechaV4=new Data(11,10,2021);
        Video v4 = new Video("Alias04", "Crear un getter", "Lab04", fechaV4, 115);
        
        Data fechaV5=new Data(13,7,2021);
        Video v5 = new Video("Alias05", "Crear un setter", "Lab05", fechaV5, 138);
        
        Data fechaV6=new Data(21,4,2021);
        Video v6 = new Video("Alias06", "Creación del Javadoc", "Lab06", fechaV6, 115);
        
     //SECCIÓN DE PRUEBAS   
     //provaV(Video,moreLikes,moreVisus,moreSaved)
       provaModifV(v1,21,138,12);	//V1
       provaModifV(v2,30,314,50);	//V2
       v3.increaseVisus(45);	v3.increaseSaved(30);
       v5.increaseVisus(100);	v5.increaseSaved(60);
       v4.increaseSaved(32);
       v5.increaseSaved(70);
       provaCopia(v1,v2);
       checkIfUseful(v1);
       checkMoreSaved(v4,v5);
       pruebaLonger(v1,v2);
       v6.increaseVisus(99);
       provaMitjanaVisus(v6);
       benValorat(v1);
    }
    
    /**
     * Comprobamos que funciona el metodo que determina si estan bien valorados o no
     * @param v1 le pasamos el video del que lo queremos comprobar
     */
    public static void benValorat(Video v1) {
    	System.out.println("\n********************************");
    	System.out.println("PRUEBA BIEN VALORADO O NO");
    	System.out.println("Un vídeo está bien valorado si (likes/visus)*100>=lindar");
    	System.out.println("1er lindar= "+ v1.getLindar());
    	if(v1.goodRated())
    		System.out.println(v1.getAlias()+" está bien valorado");
    	else
    		System.out.println(v1.getAlias()+" no está bien valorado");
    	
    	int lindar=0;
    	do{System.out.println("2º lindar: introdúcelo por teclado [40,100]");
    	lindar=teclado.nextInt();
        if(lindar>=40&&lindar<=100) {
        	System.out.println("Has establecido el lindar a "+lindar);
        	v1.setLindar(lindar);}

        else
        	System.out.println("El número que has introducido es incorrecto");
        }while(lindar<40||lindar>100);
    	
    	if(v1.goodRated())
    		System.out.println(v1.getAlias()+" está bien valorado");
    	else
    		System.out.println(v1.getAlias()+" no está bien valorado");
    		
    }
   
    /**
     * Comprobamos el funcionamiento de los métodos para modificar los datos
     * @param v1 el objeto a modificar
     * @param moreLikes cantidad en la que queremos incrementar los likes
     * @param moreVisus cantidad en la que queremos incrementar las visualizaciones
     * @param moreSaved cantidad en la que queremos incrementar las veces guardado
     */
    public static void provaModifV(Video v1,int moreLikes,int moreVisus,int moreSaved) {
    	System.out.println("\n********************************");
    	System.out.println("PRUEBA MODIFICAR LIKES, VISUS, GUARDADOS");
    	System.out.println(v1);	//imprimim l'objecte sense modificar
    	if(moreVisus>0)		//comprovem que el valor sigui positiu
    		v1.increaseVisus(moreVisus);	
    	if(moreLikes>0)
    		v1.increaseLikes(moreLikes);	
    	if(moreSaved>0)
    		v1.increaseSaved(moreSaved);
    	System.out.println("\n--------------------------------");
    	System.out.println(v1.getAlias()+"->visus=visus + "+moreVisus+"   likes=likes + "+moreLikes
    			+"   saved=saved + "+moreSaved);	//imprimim les modificacions que fem
    	System.out.println(v1.getAlias()+" modificado:"+ v1);	//imprimim l'objecte modificat
    }
    /**
     * Comprovamos el funcionamiendo del metodo
     * @param v1 le pasamos el primer objeto
     * @param v2 le pasamos el segundo objeto
     */
    public static void checkMoreSaved(Video v1, Video v2) {
    	System.out.println("\n********************************");
    	System.out.println("PRUEBA COMPROBAR CUAL HA SIDO GUARDADO MAS VECES");
    	System.out.println(v1.getAlias()+" se ha guardado "+v1.getSaved()+" veces, y v2, "+v2.getSaved()+" veces");
    	if(v1.moreSaved(v2))
    		System.out.println(v1.getAlias()+" sí que se ha guardado más veces que "+v2.getAlias());
    	else
    		System.out.println(v1.getAlias()+" no se ha guardado más veces que "+v2.getAlias());
    }
    
    /**
     * Comprobamos si es util un video o no
     * @param v1 le pasamos el video a comprobar
     */
    public static void checkIfUseful(Video v1) {
    	System.out.println("\n********************************");
    	System.out.println("PRUEBA COMPROBAR SI ES UTIL");
    	System.out.println("Un vídeo es útil si saved>likes");
    	System.out.println(v1.getAlias()+" ha sido guardado "+v1.getSaved()+" veces y tiene "+v1.getLikes()+" likes");
    	if(v1.getSaved()>v1.getLikes()) {
    		System.out.println("	Saved > likes= El vídeo es útil");
    	}
    	else
    		System.out.println("Saved < likes=	El vídeo no és útil");
    }
    
    /**
     * Le pasamos dos videos y nos devuelve una copia del que dura mas
     * @param v1 1r video
     * @param v2 2º video
     */
    public static void pruebaLonger(Video v1, Video v2) {
    	System.out.println("\n********************************");
    	System.out.println("PRUEBA COPIA VIDEO MaS LARGO");
    	System.out.println(v1.getAlias()+" dura "+v1.getDuracion()+" segundos y "+v2.getAlias()+", "+
    	v2.getDuracion()+" segundos");
    	
    	System.out.println("Datos del Vídeo más largo: ");
    	System.out.println(v1.copiaLonger(v2));
    }
    
    /**
     * Comprobamos funcionamiento de calcular media visus/dia
     * @param v1 video del que queremos calcular la media
     */
    public static void provaMitjanaVisus(Video v1) {
    	LocalDate currentdate=LocalDate.now();
    	/**
    	 * Detectamos automaticamente la fecha en la que estamos
    	 * y lo guardamos en un objeto con el formato fecha
    	 */
    	Data diaActual=new Data(currentdate.getDayOfMonth(),currentdate.getMonthValue(),currentdate.getYear());
    	System.out.println("\n********************************");
    	System.out.println("PRUEBA MEDIA VISUALIZACIONES/DIA");
    	System.out.println(diaActual+" -> han pasado "+v1.daysElapsed(diaActual)+" días desde la publicación del vídeo");
    	System.out.println("El vídeo tiene un total de "+v1.getVisus()+" visualizaciones");
    	System.out.println("La media de visualizaciones por dia de "+v1.getAlias()+" es: "
    			+v1.mitjanavisus(diaActual));
    }
    
    /**
     * Comprobamos funcionamiento: le pasamos dos videos y copiamos uno
     * sobre el otro
     * @param v1 1r video
     * @param v2 2º video
     */
    public static void provaCopia(Video v1,Video v2) {
    	System.out.println("\n********************************");
    	System.out.println("PRUEBA COPIA VIDEO");
    	System.out.println("Copiarem "+v1.getAlias()+" a: "+v2.getAlias());
    	System.out.println(v2);	//imprimim l'objecte sense modificar
    	System.out.println("\n--------------------------------");
    	System.out.println(v2.getAlias()+" modificado:");
    	v2.setPercentage(v1.getPercentage());
    	v2=v1.copia();
    	System.out.println(v2);//imprimim l'objecte modificat
    	
    }
    
    public static void checkBenValorat(Video v1) {
    	System.out.println("\n********************************");
    }
    
}