
package entities;

public class PessoaFisica extends Pessoa{
    private double gastosCSaude;

    
    public PessoaFisica(double gastosCSaude, String nome, Double rendaAnual) {
        super(nome, rendaAnual);
        this.gastosCSaude = gastosCSaude;
    }

    
    public double getGastosCSaude() {
        return gastosCSaude;
    }

    public void setGastosCSaude(double gastosCSaude) {
        this.gastosCSaude = gastosCSaude;
    }
    

    @Override
    public double imposto() {
        double aux;
        double renda = getRendaAnual();
        
        if(renda < 20000.00){
            aux = (renda * 0.15) - (gastosCSaude * 0.50);
        }
        else{
            aux = (renda * 0.25) - (gastosCSaude * 0.50);
        }
        
        return aux;
    }
}
