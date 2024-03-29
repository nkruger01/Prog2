package Etapa_2;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingUtilities;

public class Pedido {

	private int numero;
	private String nomeCLiente;
	private Date data;
	private String endereco;
	private CalculoEntrega tipoEntrega;
	private ArrayList<ItemPedido> itensPedidos = new ArrayList<ItemPedido>();

	protected Pedido(int numero, String nomeCLiente, Date data, String endereco, CalculoEntrega tipoEntrega) {
		this.numero = numero;
		this.nomeCLiente = nomeCLiente;
		this.data = data;
		this.endereco = endereco;
		this.tipoEntrega = tipoEntrega;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNomeCLiente() {
		return nomeCLiente;
	}

	public void setNomeCLiente(String nomeCLiente) {
		this.nomeCLiente = nomeCLiente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public CalculoEntrega getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(CalculoEntrega tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public double getValorPedido() {

		double acumuladorValor = 0;

		for (int i = 0; i < itensPedidos.size(); i++) {
			ItemPedido item = itensPedidos.get(i);
			acumuladorValor += item.getQuantidade() * item.getValorItem();
		}

		return acumuladorValor;

	}

	public void incluirItem(Produto produto, int quantidade) {
		ItemPedido item = new ItemPedido(quantidade, produto);
		itensPedidos.add(item);
	}

	public int getPesoTotalPedido() {

		double acumuladorPeso = 0;

		for (int i = 0; i < itensPedidos.size(); i++) {
			ItemPedido item = itensPedidos.get(i);
			acumuladorPeso += item.getQuantidade() * item.getProduto().getPeso();
		}

		int valorConvertido = (int) acumuladorPeso;

		return valorConvertido / 1000;

	}

	public double getValorEntrega(Pedido pedido) throws TipoEntregaInvalidoException {

		return tipoEntrega.CalculaValorEntrega(pedido);

	}

	public int getQuantidadeProdutos() {
		return itensPedidos.size() + 1;
	}

}
