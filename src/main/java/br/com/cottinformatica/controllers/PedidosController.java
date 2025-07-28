package br.com.cottinformatica.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.data.domain.Page;

import br.com.cottinformatica.dtos.PedidoRequest;
import br.com.cottinformatica.dtos.PedidoResponse;
import br.com.cottinformatica.interfaces.PedidoService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pedidos")
@Tag(name = "Pedidos", description = "Endpoints para gerenciamento de pedidos.")
public class PedidosController {

	@Autowired PedidoService pedidoService;

	@PostMapping
	@Operation(summary = "Inserir um pedido", description = "Endpoint para inserir um novo pedido.")
	public ResponseEntity<PedidoResponse> post(@RequestBody @Valid PedidoRequest request) {
		System.out.println("Put "+ request);
		return ResponseEntity.ok(pedidoService.criar(request));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um pedido", description = "Endpoint para atualizar um pedido existente.")
	public ResponseEntity<PedidoResponse> put(@PathVariable UUID id, @RequestBody @Valid PedidoRequest request) {
		return ResponseEntity.ok(pedidoService.alterar(id, request));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Excluir um pedido", description = "Endpoint para excluir um pedido existente.")
	public ResponseEntity<PedidoResponse> delete(@PathVariable UUID id) {
		return ResponseEntity.ok(pedidoService.excluir(id));
	}

	@GetMapping
	@Operation(summary = "Obter um pedido", description = "Endpoint para obter os dados de um pedido existente.")
	public ResponseEntity<Page<PedidoResponse>> get(
		@RequestParam(defaultValue = "0") int pagina,
		@RequestParam(defaultValue = "25") int qtdRegistros,
		@RequestParam(defaultValue = "dataPedido") 
		String campoOrdenacao,
		@RequestParam(defaultValue = "asc") String tipoOrdenacao
	) {
		return ResponseEntity.ok(pedidoService.consultar(pagina, qtdRegistros, campoOrdenacao, tipoOrdenacao));
	}

}
