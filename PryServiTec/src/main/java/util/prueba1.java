package util;
import dao.ContratoDao;
import vista.Cobranza;
public class prueba1 {

    public static void main(String[] args) 
    {

            Cobranza contratoDao = new Cobranza();

           // Define el ID de un empleador para filtrar contratos
           String idEmpleador = "E001";  // Reemplaza con el ID de tu empleador

           // Llama al método listaContratoCliente con el ID de empleador
           contratoDao.listaContratoCliente(idEmpleador);
       
       
       
       
       
       
       
       
       
       
       
       
    }
    
}
