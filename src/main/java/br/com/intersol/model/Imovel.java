package br.com.intersol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "imovel")
@DynamicUpdate(value = true)
public class Imovel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "codigo_proprietario")
	@NotNull(message = "O proprietário é obrigatório")
	private Proprietario proprietario;
	
	@Embedded
	private Endereco endereco;
	
	@Column(name = "area_terreno")
	@Digits(integer = 10, fraction = 2)
	@NotNull(message = "A área do terreno é obrigatória")
	private BigDecimal areaTerreno = BigDecimal.ZERO;
	
	@Column(name = "area_construida")
	@Digits(integer = 10, fraction = 2)
	@NotNull(message = "A área construída é obrigatória")
	private BigDecimal areaConstruida = BigDecimal.ZERO;
	
	@Transient
	private BigDecimal areaTotal = BigDecimal.ZERO;
	
	@Digits(integer = 10, fraction = 2)
	@NotNull(message = "A alícota é obrigatória")
	private BigDecimal alicota = BigDecimal.ZERO;
	
	@Column(name = "valor_venal_terreno")
	@Digits(integer = 10, fraction = 2)
	@NotNull(message = "O valor venal do terreno é obrigatório")
	private BigDecimal valorVenalTerreno = BigDecimal.ZERO;
	
	@Column(name = "valor_venal_construcao")
	@Digits(integer = 10, fraction = 2)
	@NotNull(message = "O valor venal da construção é obrigatório")
	private BigDecimal valorVenalConstrucao = BigDecimal.ZERO;
	
	public Map<String, BigDecimal> calcularImposto() {
		Map<String, BigDecimal> totais = new HashMap<String, BigDecimal>();
		
		totais.put("areaTerreno", this.getAreaTerreno());
		
		totais.put("areaTotal", this.getAreaTotal());
		totais.put("valorVenalTotal", this.getValorVenalTotal());
		totais.put("valorImposto", this.getValorImposto());
		
		System.out.println(totais);
		
		return totais;
	}
	
	@Transient
	private BigDecimal valorVenalTotal = BigDecimal.ZERO;
	
	@Transient
	private BigDecimal valorImposto = BigDecimal.ZERO;
	
	@Column(name = "data_hora_cadastro")
	private LocalDateTime dataHoraCadastro = LocalDateTime.now();
	
	public boolean isNovo() {
		return codigo == null;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getAreaTerreno() {
		return areaTerreno;
	}

	public void setAreaTerreno(BigDecimal areaTerreno) {
		this.areaTerreno = areaTerreno;
	}

	public BigDecimal getAreaConstruida() {
		return areaConstruida;
	}

	public void setAreaConstruida(BigDecimal areaConstruida) {
		this.areaConstruida = areaConstruida;
	}

	/* AREA TOTAL */
	public BigDecimal getAreaTotal() {
		return this.areaTotal = this.areaTerreno.add(this.areaConstruida);
	}

	public void setAreaTotal(BigDecimal areaTotal) {
		this.areaTotal = areaTotal;
	}

	public BigDecimal getAlicota() {
		return alicota;
	}

	public void setAlicota(BigDecimal alicota) {
		this.alicota = alicota;
	}

	public BigDecimal getValorVenalTerreno() {
		return valorVenalTerreno;
	}

	public void setValorVenalTerreno(BigDecimal valorVenalTerreno) {
		this.valorVenalTerreno = valorVenalTerreno;
	}

	public BigDecimal getValorVenalConstrucao() {
		return valorVenalConstrucao;
	}

	public void setValorVenalConstrucao(BigDecimal valorVenalConstrucao) {
		this.valorVenalConstrucao = valorVenalConstrucao;
	}

	/* VALOR VENAL TOTAL */
	public BigDecimal getValorVenalTotal() {
		return this.valorVenalTotal = this.valorVenalTerreno.add(this.valorVenalConstrucao);
	}

	public void setValorVenalTotal(BigDecimal valorVenalTotal) {
		this.valorVenalTotal = valorVenalTotal;
	}

	/* VALOR IMPOSTO */
	public BigDecimal getValorImposto() {
		return this.valorImposto = this.valorVenalTotal.multiply(this.alicota.divide(new BigDecimal("100.00")));
	}

	public void setValorImposto(BigDecimal valorImposto) {
		this.valorImposto = valorImposto;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (codigo == null) {
		if (other.codigo != null)
			return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}