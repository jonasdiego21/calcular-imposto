var Global = Global || {};
	
Global.ComboEstado = (function(){
	
	function ComboEstado() {
		this.combo = $('#estado');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboEstado.prototype.iniciar = function(){
		this.combo.on('change', onEstadoAlterado.bind(this));	
	}
	
	function onEstadoAlterado() {
		this.emitter.trigger('alterado', this.combo.val());
	}
	
	return ComboEstado;
}());

Global.ComboCidade = (function(){
	
	function ComboCidade(comboEstado){
		this.comboEstado = comboEstado;
		this.combo = $('#cidade');
		this.preloader = $('#preloader');
		this.containerCidade = $('#container-cidade');
		this.codigoCidadeSelecionado = $('#inputCidadeSelecionada');
	}
	
	ComboCidade.prototype.iniciar = function(){
		
		reset.call(this);
		
		this.comboEstado.on('alterado', onEstadoAlterado.bind(this));
		
		var codigoEstado = this.comboEstado.combo.val();
		carregarCidades.call(this, codigoEstado);
		
	}
	
	function onEstadoAlterado(evento, codigoEstado) {
		this.codigoCidadeSelecionado.val('');
		carregarCidades.call(this, codigoEstado);
	}
	
	function carregarCidades(codigoEstado) {
		
		if (codigoEstado) {
			
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				data: {'codigo': codigoEstado},
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			
			resposta.done(onBuscarCidadesFinalizado.bind(this));
			
		}		
	}
	
	function onBuscarCidadesFinalizado(cidades) {
		
		var options = [];
		
		if (cidades.length > 0) {
			
			cidades.forEach(function(cidade){
				options.push('<option value="' + cidade.codigo + '" >' + cidade.nome + '</option>');
			});
			
			this.combo.removeAttr('disabled');
			
			this.combo.html(options.join(''));
		} else {
			this.combo.html('<option>Não há cidades</option>');
			this.combo.attr('disabled', true);
		}
		
		var codigoCidadeSelecionado = this.codigoCidadeSelecionado.val();
		if (codigoCidadeSelecionado) {
			this.combo.val(codigoCidadeSelecionado);
		}
	}
	
	function iniciarRequisicao() {
		this.preloader.removeAttr('style');
	}
	
	function finalizarRequisicao() {
		this.preloader.attr('style', 'display: none');
	}
	
	function reset() {
		this.combo.html('<option value="">Selecione o município</option>');
		this.combo.val('');
		this.combo.attr('disabled', 'disabled');
	}
	
	return ComboCidade;
	
}());

$(function(){
	var comboEstado = new Global.ComboEstado();
	comboEstado.iniciar();
	
	var comboCidade = new Global.ComboCidade(comboEstado);
	comboCidade.iniciar();	
});