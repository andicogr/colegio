package pe.com.colegio.utils;

public class Constantes {
	
	public final static String ESTADO_USUARIO_ACTIVO = "Activo";
	public final static String ESTADO_USUARIO_INACTIVO = "Inactivo";
	public final static String ESTADO_USUARIO_BLOQUEADO= "Bloqueado";
	public final static String ESTADO_TODOS = "Todos";
	
	
	//MENSAJES DE SELECT - INSERT - DELETE - UPDATE
	public final static String LISTA_VACIA = "No se encontraron resultados para los criterios de busqueda";
	public final static String GUARDAR_ERROR = "No se pudo guardar la informacion, comuniquese con el administrador del sistema";
	public final static String GUARDAR_OK = "Los datos se guardaron correctamente";
	
	//TIPOS DE MENSAJES
	public final static Integer ALERTA_VERDE = 1;
	public final static Integer ALERTA_INFO = 2;
	public final static Integer ALERTA_AMBAR = 3;
	public final static Integer ALERTA_ROJA = 4;
	
	//imagenPath
	public final static String NOTICIA_PROPIEDAD_PATH = "noticiaImagen.path";
	public final static String PERFIL_PROPIEDAD_PATH = "perfilImagen.path";
	public final static String PATH_IMG_NOTICIA = "/resources/imagenNoticia/";
	public final static String PATH_IMG_PERFIL = "/resources/imagePerfil/";
	public final static String PATH_IMG_NOTICIA_DEFAULT = "resources/image/defult_img_noticia";
	public final static String PATH_IMG_PERFIL_DEFAULT = "resources/image/defult_img_perfil";
	public final static String PREFIJO_IMG_NOTICIA = "fotoTitulo-";
	public final static String PREFIJO_IMG_PERFIL = "fotoPerfil-";

}
