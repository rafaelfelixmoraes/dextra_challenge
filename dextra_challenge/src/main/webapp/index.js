$(document).ready(function() {
   // declaração da variável
   var valorEscolhido;
 
   $("#sel1").change(function(){
      // obtendo o valor do atributo value da tag option
      valorEscolhido = $("#sel1 option:selected").val();
      // exibindo uma janela com o valor selecionado
      //alert (valorEscolhido);

    	$.ajax({ 
   			type: "GET",
   			url: "http://localhost:8080/lanches/" + valorEscolhido,
   			dataType: 'json',
   			success: function(data){
   				//var lanche = "Lanche Escolhido: " + data.description + ", Preço: " + data.totalPrice;        
     			$("#valorTotal").text(data.totalPrice);
   			}
		});
   });
});