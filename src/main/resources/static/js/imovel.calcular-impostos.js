var Imovel = Imovel || {};

Imovel.CalcularImpostos = (function() {
	
	function CalcularImpostos() {
		this.areaTerrenoInput = $('#areaTerreno');
		this.areaConstruidaInput = $('#areaConstruida');
		this.areaTotalInput = $('#areaTotal');
		this.valorVenalTerrenoInput = $('#valorVenalTerreno');
		this.valorVenalConstrucaoInput = $('#valorVenalConstrucao');
		this.valorVenalTotalInput = $('#valorVenalTotal');
		this.alicotaInput = $('#alicota');
		this.valorImpostoInput = $('#valorImposto');
		
		this.areaTotal = 0;
		this.valorVenalTotal = 0;
		this.valorImposto = 0;
	}
	
	CalcularImpostos.prototype.start = function() {
		this.areaTerrenoInput.on('blur', calcularAreaTotal.bind(this));		
		this.areaConstruidaInput.on('blur', calcularAreaTotal.bind(this));		
		this.valorVenalTerrenoInput.on('blur', calcularValorVenalTotal.bind(this));		
		this.valorVenalConstrucaoInput.on('blur', calcularValorVenalTotal.bind(this));		
		this.alicotaInput.on('blur', calcularImposto.bind(this));		
		this.valorVenalTotalInput.on('blur', calcularImposto.bind(this));
	}
	
	function calcularAreaTotal() {
		let areaTerreno = parseFloat($(this.areaTerrenoInput).val().replace(/[.]/g, '').replace(',', '.'));
		let areaConstruida = parseFloat($(this.areaConstruidaInput).val().replace(/[.]/g, '').replace(',', '.')); 
		
		this.areaTotal = parseFloat(areaTerreno + areaConstruida).toFixed(2);
		
		this.areaTotalInput.val(this.areaTotal);
		
		this.areaTotalInput.val(this.areaTotalInput.val().replace('.', ','));
	}
	
	function calcularValorVenalTotal() {
		let valorVenalTerreno = parseFloat($(this.valorVenalTerrenoInput).val().replace(/[.]/g, '').replace(',', '.'));
		let valorVenalConstrucao = parseFloat($(this.valorVenalConstrucaoInput).val().replace(/[.]/g, '').replace(',', '.')); 
		
		this.valorVenalTotal = parseFloat(valorVenalTerreno + valorVenalConstrucao).toFixed(2);
		
		this.valorVenalTotalInput.val(this.valorVenalTotal);
		
		this.valorVenalTotalInput.val(this.valorVenalTotalInput.val().replace('.', ','));
	}
	
	function calcularImposto() {
		let valorVenalTotal = parseFloat($(this.valorVenalTotalInput).val().replace(/[.]/g, '').replace(',', '.'));
		let alicota = parseFloat($(this.alicotaInput).val().replace(/[.]/g, '').replace(',', '.')); 
		
		this.valorImposto = parseFloat((valorVenalTotal * alicota) / 100.00).toFixed(2);
		
		this.valorImpostoInput.val(this.valorImposto);
		
		this.valorImpostoInput.val(this.valorImpostoInput.val().replace('.', ','));
	}
	
	return CalcularImpostos;
	
}());

$(function() {
	let calcularImpostos = new Imovel.CalcularImpostos();
	calcularImpostos.start();
});