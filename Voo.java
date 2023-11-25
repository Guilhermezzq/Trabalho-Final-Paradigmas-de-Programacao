import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Voo {
    private String nome;
    private ArrayList<Passageiro> listaPassageiros;
    private Queue<Passageiro> filaEspera;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Passageiro> getListaPassageiros() {
        return listaPassageiros;
    }

    public void setListaPassageiros(ArrayList<Passageiro> listaPassageiros) {
        this.listaPassageiros = listaPassageiros;
    }

    public Queue<Passageiro> getFilaEspera() {
        return filaEspera;
    }

    public void setFilaEspera(Queue<Passageiro> filaEspera) {
        this.filaEspera = filaEspera;
    }

    public Voo(String nome) {
        this.nome = nome;
        this.listaPassageiros = new ArrayList<>();
        this.filaEspera = new LinkedList<>();
    }

    

    public void adicionarPassageiro(Passageiro passageiro) {
        if (listaPassageiros.size() < 10) {
            listaPassageiros.add(passageiro);
        } else if (filaEspera.size() < 5) {
            filaEspera.add(passageiro);
            System.out.println("Fila de espera criada para o passageiro " + passageiro.getNome());
        } else {
            System.out.println("Fila Cheia, a reserva não pode ser feita");
        }
    }

    public void removerPassageiro(Passageiro passageiro) {
        if (listaPassageiros.contains(passageiro)) {
            listaPassageiros.remove(passageiro);
            System.out.println("Passageiro removido com sucesso.");
            if (!filaEspera.isEmpty()) {
                Passageiro proximoPassageiro = filaEspera.poll();
                listaPassageiros.add(proximoPassageiro);
                System.out.println("Passageiro " + proximoPassageiro.getNome() + " retirado da fila de espera.");
            }
        } else {
            System.out.println("Passageiro não consta neste voo.");
        }
    }

    public void mostrarListaPassageiros() {
        for (Passageiro passageiro : listaPassageiros) {
            System.out.println("CPF: " + passageiro.getCPF() +
                    ", Nome: " + passageiro.getNome() +
                    ", Número da Passagem: " + passageiro.getNumeroPassagem() +
                    ", Número da Poltrona: " + passageiro.getNumeroPoltrona());
        }
    }

    public void mostrarFilaEspera() {
        for (Passageiro passageiro : filaEspera) {
            System.out.println("CPF: " + passageiro.getCPF() +
                    ", Nome: " + passageiro.getNome() +
                    ", Número da Passagem: " + passageiro.getNumeroPassagem() +
                    ", Número da Poltrona: " + passageiro.getNumeroPoltrona());
        }
    }


    public static Voo carregarDadosDoArquivo(String nomeVoo) {
        Voo voo = new Voo(nomeVoo);
        try (BufferedReader reader = new BufferedReader(new FileReader("dados_" + nomeVoo + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("Lista de Passageiros:")) {
                    while (!(line = reader.readLine()).equals("Fila de Espera:")) {
                        String[] passageiroInfo = line.split(",");
                        if (passageiroInfo.length >= 4) {
                            String cpf = passageiroInfo[0].substring(passageiroInfo[0].indexOf(":") + 2).trim();
                            String nome = passageiroInfo[1].substring(passageiroInfo[1].indexOf(":") + 2).trim();
                            String numeroPassagem = passageiroInfo[2].substring(passageiroInfo[2].indexOf(":") + 2).trim();
                            String numeroPoltrona = passageiroInfo[3].substring(passageiroInfo[3].indexOf(":") + 2).trim();
                            String endereco = "";
                            String telefone = "";
                            String numeroVoo = "";
                            String horario = "";
    
                            if (passageiroInfo.length >= 5) {
                                endereco = passageiroInfo[4].substring(passageiroInfo[4].indexOf(":") + 2).trim();
                            }
                            if (passageiroInfo.length >= 6) {
                                telefone = passageiroInfo[5].substring(passageiroInfo[5].indexOf(":") + 2).trim();
                            }
                            if (passageiroInfo.length >= 7) {
                                numeroVoo = passageiroInfo[6].substring(passageiroInfo[6].indexOf(":") + 2).trim();
                            }
                            if (passageiroInfo.length >= 8) {
                                horario = passageiroInfo[7].substring(passageiroInfo[7].indexOf(":") + 2).trim();
                            }
    
                            Passageiro passageiro = new Passageiro(cpf, nome, endereco, telefone, numeroPassagem, numeroPoltrona, numeroVoo, horario);
                            voo.adicionarPassageiro(passageiro);
                        } 
                    }
                }
                if (line.equals("Fila de Espera:")) {
                    while ((line = reader.readLine()) != null) {
                        String[] passageiroInfo = line.split(",");
                        if (passageiroInfo.length >= 4) {
                            String cpf = passageiroInfo[0].substring(passageiroInfo[0].indexOf(":") + 2).trim();
                            String nome = passageiroInfo[1].substring(passageiroInfo[1].indexOf(":") + 2).trim();
                            String numeroPassagem = passageiroInfo[2].substring(passageiroInfo[2].indexOf(":") + 2).trim();
                            String numeroPoltrona = passageiroInfo[3].substring(passageiroInfo[3].indexOf(":") + 2).trim();
                            String endereco = "";
                            String telefone = "";
                            String numeroVoo = "";
                            String horario = "";
    
                            if (passageiroInfo.length >= 5) {
                                endereco = passageiroInfo[4].substring(passageiroInfo[4].indexOf(":") + 2).trim();
                            }
                            if (passageiroInfo.length >= 6) {
                                telefone = passageiroInfo[5].substring(passageiroInfo[5].indexOf(":") + 2).trim();
                            }
                            if (passageiroInfo.length >= 7) {
                                numeroVoo = passageiroInfo[6].substring(passageiroInfo[6].indexOf(":") + 2).trim();
                            }
                            if (passageiroInfo.length >= 8) {
                                horario = passageiroInfo[7].substring(passageiroInfo[7].indexOf(":") + 2).trim();
                            }
    
                            Passageiro passageiro = new Passageiro(cpf, nome, endereco, telefone, numeroPassagem, numeroPoltrona, numeroVoo, horario);
                            voo.getFilaEspera().add(passageiro);
                        } 
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return voo;
    }
    

    // Método para salvar dados no arquivo
    public void salvarDadosNoArquivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("dados_" + nome + ".txt"))) {
            writer.println("Voo: " + nome);
            writer.println("Lista de Passageiros:");
            for (Passageiro passageiro : listaPassageiros) {
                writer.println("CPF: " + passageiro.getCPF() +
                        ", Nome: " + passageiro.getNome() +
                        ", Número da Passagem: " + passageiro.getNumeroPassagem() +
                        ", Número da Poltrona: " + passageiro.getNumeroPoltrona());
            }
            writer.println("Fila de Espera:");
            for (Passageiro passageiro : filaEspera) {
                writer.println("CPF: " + passageiro.getCPF() +
                        ", Nome: " + passageiro.getNome() +
                        ", Número da Passagem: " + passageiro.getNumeroPassagem() +
                        ", Número da Poltrona: " + passageiro.getNumeroPoltrona());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
