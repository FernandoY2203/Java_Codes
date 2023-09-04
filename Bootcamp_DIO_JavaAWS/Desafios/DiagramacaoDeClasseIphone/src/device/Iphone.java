package device;

public class Iphone implements AparelhoTelefonico, ReprodutorDeMusica, NavegadorDeInternet{
    
    private Boolean internet;
    private Boolean sinalDeRede;
    private Integer porcentBateria;
    private Integer volume;
    private Double memoriaRAM;

    public Iphone(Boolean sinalDeRede, Integer porcentBateria) {
        this.sinalDeRede = sinalDeRede;
        this.porcentBateria = porcentBateria;

        this.memoriaRAM = 16.0;
        this.internet = false;
        this.volume = 100;
    }
    

    public Boolean getInternet() {
        return internet;
    }

    public Boolean getSinalDeRede() {
        return sinalDeRede;
    }

    public Integer getPorcentBateria() {
        return porcentBateria;
    }

    public Integer getVolume() {
        return volume;
    }

    public Double getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setSinalDeRede(Boolean sinalDeRede) {
        this.sinalDeRede = sinalDeRede;
    }

    public void setPorcentBateria(Integer porcentBateria) {
        this.porcentBateria = porcentBateria;
    }

    public void setMemoriaRAM(Double memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }
    
    
// Aparelho Telefônico    
//---------------------------------------------------------------------------------//
    @Override
    public void ligar(String numero) {
        if(sinalDeRede){
            StringBuilder sb = new StringBuilder();
        
            sb.append("|---------------|" + "\n");
            sb.append("|    Ligando    |" + "\n");
            sb.append("|     Para:     |" + "\n");
            sb.append("|   " + numero + "   |" + "\n");
            sb.append("|---------------|");

            System.out.println(sb.toString());
        }
        else{
            System.out.println("Sem Sinal!!");
        }
    }

    @Override
    public void atender() {
        if(sinalDeRede){
            System.out.println("Chamada Atendida");
        }
        else{
            System.out.println("Sem Sinal!!");
        }
    }

    @Override
    public void iniciarCorreioVoz() {
        if(sinalDeRede){
            System.out.println("Iniciando Correio de Voz");
        }
        else{
            System.out.println("Sem Sinal!!");
        }
    }
    
    @Override
    public void desligarChamada() {
        System.out.println("Chamada Finalizada");
    }

// Reprodutor de Música
//---------------------------------------------------------------------------------//
    @Override
    public void tocar() {
        if(porcentBateria > 20){
            System.out.println("Tocando Música");
        }
        else{
            System.out.println("Dispositivo com pouca Bateria");
        }
    }

    @Override
    public void pausar() {
        System.out.println("Música Pausada");
    }

    @Override
    public void selecionarMusica(String musica) {
        if(porcentBateria > 20){
            System.out.println("Tocando: " + musica);
        }
        else{
            System.out.println("Dispositivo com pouca bateria");
        }
    }
    

// Navegador de Internet   
//---------------------------------------------------------------------------------//
    @Override
    public void exibirPagina(String url) {
        if(porcentBateria > 20){
            if(internet){
                if(memoriaRAM == 0){
                    System.out.println("Memória Cheia!!!");
                }
                else{
                    memoriaRAM -= 0.50;
                    
                    System.out.println("Acessando: " + url);
                }
            }
            else{
                System.out.println("Dispositivo sem Internet");
            }
        }
        else{
            System.out.println("Dispositivo com pouca Bateria");
        }
    }

    @Override
    public void adicionarNovaAba() {
        if(porcentBateria > 20){
            if(internet){
                if(memoriaRAM == 0){
                    System.out.println("Memória Cheia!!!");
                }
                else{
                    memoriaRAM -= 0.5;
                    
                    System.out.println("Abrindo Nova Aba");
                }
            }
            else{
                System.out.println("Dispositivo sem Internet");
            }
        }
        else{
            System.out.println("Dispositivo com pouca Bateria");
        }
    }

    @Override
    public void atualizarPagina() {
        if(porcentBateria > 20){
            if(internet){
                System.out.println("Página Atualizada");
            }
            else{
                System.out.println("Dispositivo sem Internet");
            }
        }
        else{
            System.out.println("Dispositivo com pouca Bateria");
        }
    }
    
    @Override
    public void fecharAba() {
        if(memoriaRAM == 16){
            System.out.println("Aba Fechada");
        }
        else{
            memoriaRAM += 0.5;
            
            System.out.println("Aba Fechada");
        }
    }
    
// Métodos do Iphone    
//---------------------------------------------------------------------------------//
    public void ligarInternet(){
        if(internet){
            System.out.println("A internet já está ligada");
        }
        else{
            this.internet = true;
            
            System.out.println("Internet ligada");
        }
    }
    
    public void desligarInternet(){
        if(!internet){
            System.out.println("A internet já está desligada");
        }
        else{
            this.internet = false;
            
            System.out.println("Internet desligada");
        }
    }
    
    public void aumentarVolume(){
        if(volume == 100){
            System.out.println("Volume já está no máximo");
        }
        else{
            this.volume += 10;
            
            System.out.println("Volume aumentado");
        }
    }
    
    public void diminuirVolume(){
        if(volume == 0){
            System.out.println("Volume já está no mínimo");
        }
        else{
            this.volume -= 10;
            
            System.out.println("Volume diminuído");
        }
    }
}
