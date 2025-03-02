<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formul�rio de Pedido de Inten��o</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            box-sizing: border-box;
        }
        h1 {
            text-align: center;
            color: #333;
            font-size: 24px;
            margin-bottom: 20px;
        }
        label {
            font-size: 14px;
            color: #555;
            margin-top: 10px;
            display: block;
        }
        input, textarea, button {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 14px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
            min-height: 100px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
            padding: 12px;
        }
        button:hover {
            background-color: #45a049;
        }
        /* New styles for checkbox container */
        .checkbox-container {
            display: flex;
            align-items: center;
            margin-top: 8px;
        }
        .checkbox-container input {
            width: auto;
            margin-right: 10px;
            margin-top: 0;
        }
        .checkbox-container label {
            margin-top: 0;
            display: inline;
        }
        .message {
            padding: 10px;
            margin-bottom: 20px;
            text-align: center;
            font-size: 14px;
            border-radius: 4px;
        }
        .success {
            background-color: #e6ffe6;
            color: #4CAF50;
            border: 1px solid #4CAF50;
        }
        .error {
            background-color: #ffe6e6;
            color: #f44336;
            border: 1px solid #f44336;
        }
    </style>
</head>
<body>
    <form action="Controller" method="post" onsubmit="return validarEGerarIdentificador()">
       	<h1>
		  Pedido de Inten��o de Est�gio
		  <span style="display: block; font-size: 12px; color: gray;"> Port�o de acesso aos dados em linhas  - Sem camada Service</span>
		</h1>
        <input type="hidden" name="action" value="criarPedidoIntencao">
        
         <!-- �rea para mensagens -->
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            String tipoMensagem = (String) request.getAttribute("tipoMensagem");
            if (mensagem != null && tipoMensagem != null) {
        %>
            <div class="message <%= tipoMensagem %>">
                <%= mensagem %>
            </div>
        <% } %>
           
	    <input type="hidden" name="identificadorExistente" id="identificadorExistente">
	    <input type="hidden" name="identificador" id="identificador">
	
	    <script>
	    function validarEGerarIdentificador() {
	        // Recupera o identificador do usu�rio se j� existir
	        const identificadorSalvo = localStorage.getItem('identificadorPedido_' + document.getElementById('usuario').value);
	        
	        // Se j� existir um identificador para este usu�rio
	        if (identificadorSalvo) {
	            // Verifica se deseja continuar
	            const confirmar = confirm('Voc� j� tem um pedido de inten��o em andamento. Deseja continuar mesmo assim?');
	            
	            if (confirmar) {
	                // Mant�m o identificador existente
	                document.getElementById('identificadorExistente').value = identificadorSalvo;
	                return true;
	            } else {
	                // Cancela o envio do formul�rio
	                return false;
	            }
	        } else {
	            // Gera novo identificador
	            const novoIdentificador = 'ID-' + 
	                new Date().getTime() + 
	                '-' + 
	                Math.random().toString(36).substr(2, 9);
	            
	            // Salva o novo identificador no localStorage
	            localStorage.setItem('identificadorPedido_' + document.getElementById('usuario').value, novoIdentificador);
	            
	            // Define o valor do campo oculto
	            document.getElementById('identificador').value = novoIdentificador;
	            
	            return true;
	        }
	    }
	    </script>
        
        <label for="usuario">Seu nome:</label>
        <input type="text" name="usuario" id="usuario" required><br>
        
        <label for="ira">IRA:</label>
        <input type="number" name="ira" id="ira" required><br>
        
        <div class="checkbox-container">
            <input type="checkbox" name="iraUlt" id="iraUlt" value="true" onclick="this.value = this.checked ? 'true' : 'false';">
            <label for="iraUlt">IRA dos dois �ltimos per�odos</label>
        </div>

        <label for="cargaHorariaCumprida">Carga Hor�ria Cumprida:</label>
        <input type="number" name="cargaHorariaCumprida" id="cargaHorariaCumprida" required><br>
        
        <label for="enderecoResidencia">Endere�o de Resid�ncia:</label>
        <input type="text" name="enderecoResidencia" id="enderecoResidencia" required><br>
        
        <label for="nomeEmpresa">Nome da Empresa:</label>
        <input type="text" name="nomeEmpresa" id="nomeEmpresa" required><br>
        
        <label for="enderecoEmpresa">Endere�o da Empresa:</label>
        <input type="text" name="enderecoEmpresa" id="enderecoEmpresa" required><br>
        
        <label for="modalidadeEstagio">Modalidade do Est�gio:</label>
        <input type="text" name="modalidadeEstagio" id="modalidadeEstagio" required><br>
        
         <div class="checkbox-container">
            <input type="checkbox" name="primeiroEstagio" id="primeiroEstagio" value="true" onclick="this.value = this.checked ? 'true' : 'false';">
            <label for="primeiroEstagio">Primeiro estagio</label>
        </div>
        
        <label for="cargaHorariaSemanal">Carga Hor�ria Semanal:</label>
        <input type="number" name="cargaHorariaSemanal" id="cargaHorariaSemanal" required><br>
        
        <label for="valorBolsa">Valor da Bolsa:</label>
        <input type="number" name="valorBolsa" id="valorBolsa" required><br>
        
        <label for="resumoAtividades">Resumo das Atividades:</label>
        <textarea name="resumoAtividades" id="resumoAtividades" required></textarea><br>
        
        <label for="conteudosTeoricos">Conte�dos Te�ricos:</label>
        <textarea name="conteudosTeoricos" id="conteudosTeoricos" required></textarea><br>
        
        <label for="motivo">Motivo:</label>
        <textarea name="motivo" id="motivo" required></textarea><br>
        
        <button type="submit">Enviar Pedido</button>
    </form>
</body>
</html>