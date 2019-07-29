package br.com.ctis.detran.endpoint;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.ctis.detran.dto.veiculo.CadastrarVeiculoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("veiculos")
@Tag(name = "Veiculo", description = "Recursos para realizar operações na entidade Veiculo")
public interface VeiculoEndPoint {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Recurso para cadastro de um novo Veículo no sistema", summary = "Adicionar novo Veículo", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response cadastrarVeiculo(
			@RequestBody(description = "Objeto Veiculo que será adicionado", required = true, content = @Content(schema = @Schema(implementation = CadastrarVeiculoDTO.class))) @Valid CadastrarVeiculoDTO veiculoDTO);
}
