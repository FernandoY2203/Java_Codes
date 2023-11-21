
package entities;

public class PessoaJuridica extends Pessoa{
    private Integer numFuncionarios;

    
    public PessoaJuridica(Integer numFuncionarios, String nome, Double rendaAnual) {
        super(nome, rendaAnual);
        this.numFuncionarios = numFuncionarios;
    }
    

    public Integer getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(Integer numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    @Override
    public double imposto() {
        double aux;
        double renda = getRendaAnual();
        
        if(numFuncionarios <= 10){
            aux = (renda * 0.16);
        }
        else{
            aux = (renda * 0.14);
        }
        
        return aux;
    }
}
