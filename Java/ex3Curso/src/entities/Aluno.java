
package entities;

public class Aluno {
    public String nome;
    public double nota1;
    public double nota2;
    public double nota3;
    
    public double notaFinal(){
        return nota1 + nota2 + nota3;
    }
    
    public double pontosNecessarios(){
        return 60 - notaFinal();
    }

    @Override
    public String toString() {
        String result;
        
        if(notaFinal() < 60){
            result = "Nota Final = " + String.format("%.2f", notaFinal()) + "\n" +
                     "Reprovado \n" +
                     "Faltou " + String.format("%.2f", pontosNecessarios()) + " Pontos";
        }
        else{
            result = "Nota Final = " + String.format("%.2f", notaFinal()) + "\n" +
                     "Reprovado";
        }
        return result;
    }
    
    
}
