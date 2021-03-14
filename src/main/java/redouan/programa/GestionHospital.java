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
        Hospital CostaDelSol = new Hospital("CostaDelSol", "Marbella", 2000);
        
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
        
        //Tratamiento de un paciente con un medicamento indicado por el medico
        //CostaDelSol.getListaEmpleados().get(0)
        //NO SE COMO ACCEDER AL MÉTODO TRATAR DE LA CLASE MÉDICO!!!!
        
        //Ejecución del método abstracto del irpf en todos los empleados
        // primer medico
        System.out.println("El empleado " + CostaDelSol.getListaEmpleados().get(0).getNombre()
        + ", médico se le retiene(IRPF) en euros: " + CostaDelSol.getListaEmpleados().get(0).calcularIRPF());
        //segundo medico
        System.out.println("El empleado " + CostaDelSol.getListaEmpleados().get(1).getNombre()
        + ", médico se le retiene(IRPF) en euros: " + CostaDelSol.getListaEmpleados().get(1).calcularIRPF());
        //primer admin
        System.out.println("El empleado " + CostaDelSol.getListaEmpleados().get(2).getNombre()
        + ", médico se le retiene(IRPF) en euros: " + CostaDelSol.getListaEmpleados().get(2).calcularIRPF());
        //segundo admin
        System.out.println("El empleado " + CostaDelSol.getListaEmpleados().get(3).getNombre()
        + ", médico se le retiene(IRPF) en euros: " + CostaDelSol.getListaEmpleados().get(3).calcularIRPF());
        //tercer admin
        System.out.println("El empleado " + CostaDelSol.getListaEmpleados().get(4).getNombre()
        + ", médico se le retiene(IRPF) en euros: " + CostaDelSol.getListaEmpleados().get(4).calcularIRPF());
        
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
        
        if(grupo.equals(grupo.GRUPOA)){
            
            return new Administrativo(grupo.GRUPOA, numSS, salario, nombre, 
                    apellidos, nif);
        }else{
            
            return new Administrativo(grupo.GRUPOB, numSS, salario, nombre, 
                    apellidos, nif);
        }
    }
}
