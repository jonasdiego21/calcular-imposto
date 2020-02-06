var Global = Global || {};

Global.Mascaras = (function() {
	
	function Mascaras() {
		this.moeda = $(".moeda-mask");
		this.area = $('.area-mask');
		this.porcentagem = $('.porcentagem-mask');
	}
	
	Mascaras.prototype.start = function() {		
		this.moeda.maskMoney({
			precision: 2,
			allowNegative: true, 
			thousands:'.', 
			decimal:',', 
			affixesStay: false
		});
		
		this.area.maskMoney({
			precision: 2,
			allowNegative: true, 
			thousands:'.', 
			decimal:',', 
			affixesStay: false
		});
		
		this.porcentagem.maskMoney({
			precision: 2,
			allowNegative: true, 
			thousands:'.', 
			decimal:',', 
			affixesStay: false
		});
	}
	
	return Mascaras;
	
}());

$(function() {
	var mascaras = new Global.Mascaras();
	mascaras.start();
});