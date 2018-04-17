$(document).ready(function() {
	$('#alface').change(function(){
        if($("#alface").is(":checked")){
            $("#child2").append("<select id='qtdAlface'></select>");
            $("#qtdAlface").append("<option value='selecione' selected='selected'>Selecione...</option>");
            $("#qtdAlface").append("<option value='1'>1</option>");
            $("#qtdAlface").append("<option value='2'>2</option>");
            $("#qtdAlface").append("<option value='3'>3</option>");
            $("#qtdAlface").append("<option value='4'>4</option>");
            $("#qtdAlface").append("<option value='5'>5</option>");
            $("#qtdAlface").append("<option value='6'>6</option>");
        } else {
            $("#qtdAlface").remove();
        }
    });
    $('#bacon').change(function(){
        if($("#bacon").is(":checked")){
            $("#child2").append("<select id='qtdBacon'></select>");
            $("#qtdBacon").append("<option value='selecione' selected='selected'>Selecione...</option>");
            $("#qtdBacon").append("<option value='1'>1</option>");
            $("#qtdBacon").append("<option value='2'>2</option>");
            $("#qtdBacon").append("<option value='3'>3</option>");
            $("#qtdBacon").append("<option value='4'>4</option>");
            $("#qtdBacon").append("<option value='5'>5</option>");
            $("#qtdBacon").append("<option value='6'>6</option>");
        } else {
            $("#qtdBacon").remove();
        }
    });
    $('#hamburguerCarne').change(function(){
        if($("#hamburguerCarne").is(":checked")){
            $("#child2").append("<select id='qtdHamburguer'></select>");
            $("#qtdHamburguer").append("<option value='selecione' selected='selected'>Selecione...</option>");
            $("#qtdHamburguer").append("<option value='1'>1</option>");
            $("#qtdHamburguer").append("<option value='2'>2</option>");
            $("#qtdHamburguer").append("<option value='3'>3</option>");
            $("#qtdHamburguer").append("<option value='4'>4</option>");
            $("#qtdHamburguer").append("<option value='5'>5</option>");
            $("#qtdHamburguer").append("<option value='6'>6</option>");
        } else {
            $("#qtdHamburguer").remove();
        }
    });
    $('#ovo').change(function(){
        if($("#ovo").is(":checked")){
            $("#child2").append("<select id='qtdOvo'></select>");
            $("#qtdOvo").append("<option value='selecione' selected='selected'>Selecione...</option>");
            $("#qtdOvo").append("<option value='1'>1</option>");
            $("#qtdOvo").append("<option value='2'>2</option>");
            $("#qtdOvo").append("<option value='3'>3</option>");
            $("#qtdOvo").append("<option value='4'>4</option>");
            $("#qtdOvo").append("<option value='5'>5</option>");
            $("#qtdOvo").append("<option value='6'>6</option>");
        } else {
            $("#qtdOvo").remove();
        }
    });
    $('#queijo').change(function(){
        if($("#queijo").is(":checked")){
            $("#child2").append("<select id='qtdQueijo'></select>");
            $("#qtdQueijo").append("<option value='selecione' selected='selected'>Selecione...</option>");
            $("#qtdQueijo").append("<option value='1'>1</option>");
            $("#qtdQueijo").append("<option value='2'>2</option>");
            $("#qtdQueijo").append("<option value='3'>3</option>");
            $("#qtdQueijo").append("<option value='4'>4</option>");
            $("#qtdQueijo").append("<option value='5'>5</option>");
            $("#qtdQueijo").append("<option value='6'>6</option>");
        } else {
            $("#qtdQueijo").remove();
        }
    });

    clickButton = function (){
    	var jsonObject = [];
    	if($("#alface").is(":checked")){
    		var item = {};
           	item["id"] = parseInt($("#alface").val());
           	item["description"] = "Alface";
           	item["price"] = "0.40";
           	item["quantity"] = parseInt($("#qtdAlface option:selected").val());
           	jsonObject.push(item);
    	}
    	if($("#bacon").is(":checked")){
    		var item = {};
           	item["id"] = parseInt($("#bacon").val());
           	item["description"] = "Bacon";
           	item["price"] = "2.00";
           	item["quantity"] = parseInt($("#qtdBacon option:selected").val());
           	jsonObject.push(item);
    	}
    	if($("#hamburguerCarne").is(":checked")){
    		var item = {};
           	item["id"] = parseInt($("#hamburguerCarne").val());
           	item["description"] = "Hamburguer de Carne";
           	item["price"] = "3.00";
           	item["quantity"] = parseInt($("#qtdHamburguer option:selected").val());
           	jsonObject.push(item);
    	}
    	if($("#ovo").is(":checked")){
    		var item = {};
           	item["id"] = parseInt($("#ovo").val());
           	item["description"] = "Ovo";
           	item["price"] = "0.80";
           	item["quantity"] = parseInt($("#qtdOvo option:selected").val());
           	jsonObject.push(item);
    	}
    	if($("#queijo").is(":checked")){
    		var item = {};
           	item["id"] = parseInt($("#queijo").val());
           	item["description"] = "Queijo";
           	item["price"] = "1.50";
           	item["quantity"] = parseInt($("#qtdQueijo option:selected").val());
           	jsonObject.push(item);
    	}
    	console.log(jsonObject);
    	callService(jsonObject);
    }

    callService = function(jsonObject){
    	$.ajax({
        	url: "http://localhost:8080/lanches/personalizado",
        	method: "POST",
        	data: JSON.stringify(jsonObject),
        	dataType: 'json',
        	contentType: "application/json",
         	success: function(data,status){
            	  $("#valorTotal").text(data.totalPrice);
         	},
         	error: function(jqXHR, status, errorThrown){
         		 console.log(jqXHR);
            	 alert("Erro ao tentar calcular o preço - " + status.code)
         	}
    	});
    }
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