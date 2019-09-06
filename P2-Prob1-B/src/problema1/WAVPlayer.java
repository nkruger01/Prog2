/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.problema1;

/**
 *
 * @author natha
 */
public class WAVPlayer {

    public String arquivo;
    public int tempo;

    
    public void setFile(String nomeArquivo){
        this.arquivo = nomeArquivo;
        System.out.println("Arquivo aberto. Nome: " + nomeArquivo);
    }
    
    public WAVPlayer(String arquivo) {
        this.arquivo = arquivo;
    }

    public void play() {
        System.out.println("Reproduzindo arquivo a partir do tempo: " + tempo);
    }

    public void stop() {
        System.out.println("Arquivo parado");
    }

    public int forward(int tempo) {
        int resultado = this.tempo += tempo;
        return resultado;
    }

    public int reward(int tempo) {
        int resultado = this.tempo -= tempo;
        return resultado;
    }
   
    @Override
    public void finalize(){
        System.out.println("Arquivo fechado, memória liberada");
    }

}
