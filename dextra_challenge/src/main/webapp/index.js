$(document).ready(function() {
    $('#bacon').change(function(){
        if($("#bacon").is(":checked")){
            var s = $("")
            $("#child2").append("<select id='qtdBacon'></select>");
            $("#qtdBacon").append("<option value='selecione' selected='selected'>Selecione...</option>");
        } else {
            $("#qtdBacon").remove();
        }
    });
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