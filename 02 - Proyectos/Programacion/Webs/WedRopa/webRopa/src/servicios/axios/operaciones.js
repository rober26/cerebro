import http from "./axios";
class operaciones{
    getProductos(){
        return http.get("/productos");
    }
    
    getMensajes(){
        return http.get("/mensajes");
    }

    setProducto(nombre,correo,mensaje){
        return http.post("/mensaje",{Nombre : nombre, Correo : correo, Mensaje : mensaje});
    }
    deleteMensaje(id){
        return http.delete("mensajes/" + id)
    }
}

export default new operaciones;