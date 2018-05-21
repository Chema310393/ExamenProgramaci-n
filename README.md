ExamenProgramación


Parto de una vez el examen hecho la siguiente corrección:


* ~3 main~
* ~Admites perecedero y producto con el mismo nombre~
* ~No limpias fecha en mostrar~
* ~No hay poroductos que mostrar Si/no/cancelar????????~
* ~No limpias tras alta.~
* ~Admites cualquier fecha~
* ~No funciona el iterador derecha/izquierda~
* ~regex de nombre admites un espacio. "www " y "www" ~
* ~Admites variando fecha?~
* FICHERO lo creas en Principal para Fichero.java, y no lo usas en otro sitio. Diseño OO
* ~No usas búfer~
* ~No escribes línea a línea~
* ~No usas fichero de texto~
* ~Podrías haber usado la versión abreviada
  JOptionPane.showMessageDialog(null, "Voy a machacar el fichero", "Mensaje",JOptionPane.PLAIN_MESSAGE);~
* La declaración de las variables suelen hacerse al principio, cuestión de orden
* static AltaProducto altaProducto = new AltaProducto();
* Tendrías que haberlo creado local
* ~Duplicación de salir. No utilizar la herencia para reutilización de código~
* Sobra en la capa de negocio
    if(fichero.exists())
            JOptionPane.showMessageDialog(null, "Voy a machacar el fichero","Mensaje",JOptionPane.PLAIN_MESSAGE);
*usa equalsIgnoreCase en equals de producto
 } else if (!nombre.equals(other.nombre))
* CUIDADO CON EL getClass()
* LEY DE DEMETRIO. new Producto() al envoltorio del arrayList
    Gestion.altaProducto(new Producto(textFieldNombre.getText()));
