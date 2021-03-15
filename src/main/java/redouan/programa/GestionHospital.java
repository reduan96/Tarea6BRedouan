/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redouan.programa;

/**
 *
 * @author redu2
 */
public class GestionHospital {
    
    public static void main(String[] args) {
        
        //Creación del objeto hospital
        Hospital CostaDelSol = new Hospital("Costa Del Sol", "Marbella", 2000);
        
        //Inclusión de los empleados en su lista correspondiente tanto de los 
        //2 medicos como los 3 administrativos
        CostaDelSol.contratarEmpleado(crearSanitario("Traumatólogo", "0005148679",
                2000, "Juan", "Gonzalez Marin", new Nif(90763968L)));
        CostaDelSol.contratarEmpleado(crearSanitario("Digestivo", "0006255498", 
                2100, "Maria", "Martin Lopez", new Nif(91746653L)));
        CostaDelSol.contratarEmpleado(crearPersonalPAS(GrupoAdmin.GRUPOA, 
                "0009442311", 1500, "Pepe", "Sanchez Molina", new Nif(95957856L)));
        CostaDelSol.contratarEmpleado(crearPersonalPAS(GrupoAdmin.GRUPOA, 
                "0009446755", 1700, "Luisa", "Martin Ferrera", new Nif(95958322L)));
        CostaDelSol.contratarEmpleado(crearPersonalPAS(GrupoAdmin.GRUPOA, 
                "0009449942", 1300, "Jose", "Fernandez Pardo", new Nif(95958988L)));
        System.out.println("");
        
        //Inclusión y creación previa de los 5 pacientes a registrar en el hospital
        CostaDelSol.ingresarPaciente(crearPaciente("0089", "Hugo", "Rodriguez Fernandez",
                new Nif(96735541L)));
        CostaDelSol.ingresarPaciente(crearPaciente("0115", "Carmen", "Garcia Gonzalez",
                new Nif(96735996L)));
        CostaDelSol.ingresarPaciente(crearPaciente("1054", "Jesus", "Lopez Gomez",
                new Nif(96735563L)));
        CostaDelSol.ingresarPaciente(crearPaciente("1824", "Pablo", "Gomez Cabrera",
                new Nif(96735132L)));
        CostaDelSol.ingresarPaciente(crearPaciente("0017", "Diego", "Martin Sanchez",
                new Nif(96735893L)));
        System.out.println("");
        
        //Tratamiento de un paciente con un medicamento indicado por el medico
        if(CostaDelSol.getListaEmpleados().get(1) instanceof Empleado){
            
            Medico medico = (Medico) CostaDelSol.getListaEmpleados().get(0);
            medico.tratar(CostaDelSol.getListaPacientes().get(0), "Paracetamol\n");
        }
        
        //For each para calcular el irpf
        for(Empleado emp : CostaDelSol.getListaEmpleados()){
            
            System.out.println("el empleado " + emp.getNombre() + " se le retiene "
                    + emp.calcularIRPF() + " euros");
        }
          
    }
    
    //Método que crea el paciente
    public static Paciente crearPaciente(String numHistorial, String nombre, String apellidos,
    Nif nif){
        
        return new Paciente(numHistorial, nombre, apellidos, nif);
    }
    
    //Método que crea el médico
    public static Medico crearSanitario(String especialidad, String numSS, double salario,
            String nombre, String apellidos, Nif nif){
        
        return new Medico(especialidad, numSS, salario, nombre, apellidos, nif);
    }
    
    //Método que crea el administrativo
    public static Administrativo crearPersonalPAS(GrupoAdmin grupo, String numSS, double salario,
            String nombre, String apellidos, Nif nif){
        
        if(grupo.equals(GrupoAdmin.GRUPOA)){
            
            return new Administrativo(GrupoAdmin.GRUPOA, numSS, salario, nombre, 
                    apellidos, nif);
        }else{
            
            return new Administrativo(GrupoAdmin.GRUPOB, numSS, salario, nombre, 
                    apellidos, nif);
        }
    }
}
